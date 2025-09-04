
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 跑腿任务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/paotuirenwu")
public class PaotuirenwuController {
    private static final Logger logger = LoggerFactory.getLogger(PaotuirenwuController.class);

    @Autowired
    private PaotuirenwuService paotuirenwuService;

    @Autowired
    private YuebiangengjilService yuebiangengjilService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShouhuodizhiService shouhuodizhiService;
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private JiedanyuanService jiedanyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("接单员".equals(role)){
            params.put("jiedanyuanId",request.getSession().getAttribute("userId"));
            params.put("paotuirenwuStatusTypes",1);
        }
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = paotuirenwuService.queryPage(params);

        //字典表数据转换
        List<PaotuirenwuView> list =(List<PaotuirenwuView>)page.getList();
        for(PaotuirenwuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PaotuirenwuEntity paotuirenwu = paotuirenwuService.selectById(id);
        if(paotuirenwu !=null){
            //entity转view
            PaotuirenwuView view = new PaotuirenwuView();
            BeanUtils.copyProperties( paotuirenwu , view );//把实体数据重构到view中

                //级联表
                ShouhuodizhiEntity shouhuodizhi = shouhuodizhiService.selectById(paotuirenwu.getShouhuodizhiId());
                if(shouhuodizhi != null){
                    BeanUtils.copyProperties( shouhuodizhi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShouhuodizhiId(shouhuodizhi.getId());
                    view.setShouhuodizhiYonghuId(shouhuodizhi.getYonghuId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(paotuirenwu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PaotuirenwuEntity paotuirenwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,paotuirenwu:{}",this.getClass().getName(),paotuirenwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            paotuirenwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<PaotuirenwuEntity> queryWrapper = new EntityWrapper<PaotuirenwuEntity>()
            .eq("paotuirenwu_uuid_number", paotuirenwu.getPaotuirenwuUuidNumber())
            .eq("paotuirenwu_name", paotuirenwu.getPaotuirenwuName())
            .eq("paotuirenwu_types", paotuirenwu.getPaotuirenwuTypes())
            .eq("yonghu_id", paotuirenwu.getYonghuId())
            .eq("shouhuodizhi_id", paotuirenwu.getShouhuodizhiId())
            .eq("paotuirenwu_text", paotuirenwu.getPaotuirenwuText())
            .eq("paotuirenwu_status_types", paotuirenwu.getPaotuirenwuStatusTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PaotuirenwuEntity paotuirenwuEntity = paotuirenwuService.selectOne(queryWrapper);
        if(paotuirenwuEntity==null){
            YonghuEntity userId = yonghuService.selectById((Integer) request.getSession().getAttribute("userId"));
            if(userId.getNewMoney()< paotuirenwu.getPaotuirenwuNewMoney()){
                return R.error("余额不足，请充值");
            }
            userId.setNewMoney(userId.getNewMoney() - paotuirenwu.getPaotuirenwuNewMoney());
            yonghuService.updateById(userId);
            paotuirenwu.setCreateTime(new Date());
            YuebiangengjilEntity yuebiangengjilEntity = new YuebiangengjilEntity();
            yuebiangengjilEntity.setYuebiangengjilName("发布跑腿单子");
            yuebiangengjilEntity.setYuebiangengjilNumber(paotuirenwu.getPaotuirenwuNewMoney());
            yuebiangengjilEntity.setJifenTypes(1);
            yuebiangengjilEntity.setYonghuId(userId.getId());
            yuebiangengjilEntity.setInsertTime(new Date());
            yuebiangengjilEntity.setCreateTime(new Date());
            yuebiangengjilService.insert(yuebiangengjilEntity);
            paotuirenwuService.insert(paotuirenwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PaotuirenwuEntity paotuirenwu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,paotuirenwu:{}",this.getClass().getName(),paotuirenwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            paotuirenwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<PaotuirenwuEntity> queryWrapper = new EntityWrapper<PaotuirenwuEntity>()
            .notIn("id",paotuirenwu.getId())
            .andNew()
            .eq("paotuirenwu_uuid_number", paotuirenwu.getPaotuirenwuUuidNumber())
            .eq("paotuirenwu_name", paotuirenwu.getPaotuirenwuName())
            .eq("paotuirenwu_types", paotuirenwu.getPaotuirenwuTypes())
            .eq("yonghu_id", paotuirenwu.getYonghuId())
            .eq("shouhuodizhi_id", paotuirenwu.getShouhuodizhiId())
            .eq("paotuirenwu_text", paotuirenwu.getPaotuirenwuText())
            .eq("paotuirenwu_status_types", paotuirenwu.getPaotuirenwuStatusTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PaotuirenwuEntity paotuirenwuEntity = paotuirenwuService.selectOne(queryWrapper);
        if(paotuirenwuEntity==null){
            paotuirenwuService.updateById(paotuirenwu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        paotuirenwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<PaotuirenwuEntity> paotuirenwuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            PaotuirenwuEntity paotuirenwuEntity = new PaotuirenwuEntity();
//                            paotuirenwuEntity.setPaotuirenwuUuidNumber(data.get(0));                    //任务编号 要改的
//                            paotuirenwuEntity.setPaotuirenwuName(data.get(0));                    //任务标题 要改的
//                            paotuirenwuEntity.setPaotuirenwuTypes(Integer.valueOf(data.get(0)));   //任务类型 要改的
//                            paotuirenwuEntity.setPaotuirenwuNewMoney(data.get(0));                    //单价 要改的
//                            paotuirenwuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            paotuirenwuEntity.setShouhuodizhiId(Integer.valueOf(data.get(0)));   //地址 要改的
//                            paotuirenwuEntity.setPaotuirenwuText(data.get(0));                    //任务备注 要改的
//                            paotuirenwuEntity.setPaotuirenwuStatusTypes(Integer.valueOf(data.get(0)));   //任务状态 要改的
//                            paotuirenwuEntity.setCreateTime(date);//时间
                            paotuirenwuList.add(paotuirenwuEntity);


                            //把要查询是否重复的字段放入map中
                                //任务编号
                                if(seachFields.containsKey("paotuirenwuUuidNumber")){
                                    List<String> paotuirenwuUuidNumber = seachFields.get("paotuirenwuUuidNumber");
                                    paotuirenwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> paotuirenwuUuidNumber = new ArrayList<>();
                                    paotuirenwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("paotuirenwuUuidNumber",paotuirenwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //任务编号
                        List<PaotuirenwuEntity> paotuirenwuEntities_paotuirenwuUuidNumber = paotuirenwuService.selectList(new EntityWrapper<PaotuirenwuEntity>().in("paotuirenwu_uuid_number", seachFields.get("paotuirenwuUuidNumber")));
                        if(paotuirenwuEntities_paotuirenwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PaotuirenwuEntity s:paotuirenwuEntities_paotuirenwuUuidNumber){
                                repeatFields.add(s.getPaotuirenwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [任务编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        paotuirenwuService.insertBatch(paotuirenwuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
