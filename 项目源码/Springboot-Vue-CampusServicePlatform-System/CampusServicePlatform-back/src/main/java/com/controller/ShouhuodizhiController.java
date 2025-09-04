
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
 * 收货地址
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shouhuodizhi")
public class ShouhuodizhiController {
    private static final Logger logger = LoggerFactory.getLogger(ShouhuodizhiController.class);

    @Autowired
    private ShouhuodizhiService shouhuodizhiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
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
        else if("接单员".equals(role))
            params.put("jiedanyuanId",request.getSession().getAttribute("userId"));
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shouhuodizhiService.queryPage(params);

        //字典表数据转换
        List<ShouhuodizhiView> list =(List<ShouhuodizhiView>)page.getList();
        for(ShouhuodizhiView c:list){
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
        ShouhuodizhiEntity shouhuodizhi = shouhuodizhiService.selectById(id);
        if(shouhuodizhi !=null){
            //entity转view
            ShouhuodizhiView view = new ShouhuodizhiView();
            BeanUtils.copyProperties( shouhuodizhi , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(shouhuodizhi.getYonghuId());
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
    public R save(@RequestBody ShouhuodizhiEntity shouhuodizhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shouhuodizhi:{}",this.getClass().getName(),shouhuodizhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shouhuodizhi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShouhuodizhiEntity> queryWrapper = new EntityWrapper<ShouhuodizhiEntity>()
            .eq("yonghu_id", shouhuodizhi.getYonghuId())
            .eq("shouhuodizhi_name", shouhuodizhi.getShouhuodizhiName())
            .eq("shouhuodizhi_phone", shouhuodizhi.getShouhuodizhiPhone())
            .eq("shouhuodizhi_dizhi", shouhuodizhi.getShouhuodizhiDizhi())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShouhuodizhiEntity shouhuodizhiEntity = shouhuodizhiService.selectOne(queryWrapper);
        if(shouhuodizhiEntity==null){
            shouhuodizhi.setInsertTime(new Date());
            shouhuodizhi.setCreateTime(new Date());
            shouhuodizhiService.insert(shouhuodizhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShouhuodizhiEntity shouhuodizhi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shouhuodizhi:{}",this.getClass().getName(),shouhuodizhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shouhuodizhi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShouhuodizhiEntity> queryWrapper = new EntityWrapper<ShouhuodizhiEntity>()
            .notIn("id",shouhuodizhi.getId())
            .andNew()
            .eq("yonghu_id", shouhuodizhi.getYonghuId())
            .eq("shouhuodizhi_name", shouhuodizhi.getShouhuodizhiName())
            .eq("shouhuodizhi_phone", shouhuodizhi.getShouhuodizhiPhone())
            .eq("shouhuodizhi_dizhi", shouhuodizhi.getShouhuodizhiDizhi())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShouhuodizhiEntity shouhuodizhiEntity = shouhuodizhiService.selectOne(queryWrapper);
        shouhuodizhi.setUpdateTime(new Date());
        if(shouhuodizhiEntity==null){
            shouhuodizhiService.updateById(shouhuodizhi);//根据id更新
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
        shouhuodizhiService.deleteBatchIds(Arrays.asList(ids));
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
            List<ShouhuodizhiEntity> shouhuodizhiList = new ArrayList<>();//上传的东西
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
                            ShouhuodizhiEntity shouhuodizhiEntity = new ShouhuodizhiEntity();
//                            shouhuodizhiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //创建用户 要改的
//                            shouhuodizhiEntity.setShouhuodizhiName(data.get(0));                    //收货人 要改的
//                            shouhuodizhiEntity.setShouhuodizhiPhone(data.get(0));                    //电话 要改的
//                            shouhuodizhiEntity.setShouhuodizhiDizhi(data.get(0));                    //地址 要改的
//                            shouhuodizhiEntity.setInsertTime(date);//时间
//                            shouhuodizhiEntity.setUpdateTime(sdf.parse(data.get(0)));          //修改时间 要改的
//                            shouhuodizhiEntity.setCreateTime(date);//时间
                            shouhuodizhiList.add(shouhuodizhiEntity);


                            //把要查询是否重复的字段放入map中
                                //电话
                                if(seachFields.containsKey("shouhuodizhiPhone")){
                                    List<String> shouhuodizhiPhone = seachFields.get("shouhuodizhiPhone");
                                    shouhuodizhiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> shouhuodizhiPhone = new ArrayList<>();
                                    shouhuodizhiPhone.add(data.get(0));//要改的
                                    seachFields.put("shouhuodizhiPhone",shouhuodizhiPhone);
                                }
                        }

                        //查询是否重复
                         //电话
                        List<ShouhuodizhiEntity> shouhuodizhiEntities_shouhuodizhiPhone = shouhuodizhiService.selectList(new EntityWrapper<ShouhuodizhiEntity>().in("shouhuodizhi_phone", seachFields.get("shouhuodizhiPhone")));
                        if(shouhuodizhiEntities_shouhuodizhiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShouhuodizhiEntity s:shouhuodizhiEntities_shouhuodizhiPhone){
                                repeatFields.add(s.getShouhuodizhiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [电话] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shouhuodizhiService.insertBatch(shouhuodizhiList);
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
