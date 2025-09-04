
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
 * 接单员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiedanyuan")
public class JiedanyuanController {
    private static final Logger logger = LoggerFactory.getLogger(JiedanyuanController.class);

    @Autowired
    private JiedanyuanService jiedanyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = jiedanyuanService.queryPage(params);

        //字典表数据转换
        List<JiedanyuanView> list =(List<JiedanyuanView>)page.getList();
        for(JiedanyuanView c:list){
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
        JiedanyuanEntity jiedanyuan = jiedanyuanService.selectById(id);
        if(jiedanyuan !=null){
            //entity转view
            JiedanyuanView view = new JiedanyuanView();
            BeanUtils.copyProperties( jiedanyuan , view );//把实体数据重构到view中

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
    public R save(@RequestBody JiedanyuanEntity jiedanyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiedanyuan:{}",this.getClass().getName(),jiedanyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiedanyuanEntity> queryWrapper = new EntityWrapper<JiedanyuanEntity>()
            .eq("username", jiedanyuan.getUsername())
            .or()
            .eq("jiedanyuan_phone", jiedanyuan.getJiedanyuanPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiedanyuanEntity jiedanyuanEntity = jiedanyuanService.selectOne(queryWrapper);
        if(jiedanyuanEntity==null){
            jiedanyuan.setInsertTime(new Date());
            jiedanyuan.setCreateTime(new Date());
            jiedanyuan.setPassword("123456");
            jiedanyuanService.insert(jiedanyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiedanyuanEntity jiedanyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiedanyuan:{}",this.getClass().getName(),jiedanyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<JiedanyuanEntity> queryWrapper = new EntityWrapper<JiedanyuanEntity>()
            .notIn("id",jiedanyuan.getId())
            .andNew()
            .eq("username", jiedanyuan.getUsername())
            .or()
            .eq("jiedanyuan_phone", jiedanyuan.getJiedanyuanPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiedanyuanEntity jiedanyuanEntity = jiedanyuanService.selectOne(queryWrapper);
        if("".equals(jiedanyuan.getJiedanyuanPhoto()) || "null".equals(jiedanyuan.getJiedanyuanPhoto())){
                jiedanyuan.setJiedanyuanPhoto(null);
        }
        if(jiedanyuanEntity==null){
            jiedanyuanService.updateById(jiedanyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiedanyuanService.deleteBatchIds(Arrays.asList(ids));
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
            List<JiedanyuanEntity> jiedanyuanList = new ArrayList<>();//上传的东西
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
                            JiedanyuanEntity jiedanyuanEntity = new JiedanyuanEntity();
//                            jiedanyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //jiedanyuanEntity.setPassword("123456");//密码
//                            jiedanyuanEntity.setJiedanyuanName(data.get(0));                    //接单员姓名 要改的
//                            jiedanyuanEntity.setJiedanyuanPhoto("");//详情和图片
//                            jiedanyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            jiedanyuanEntity.setJiedanyuanPhone(data.get(0));                    //联系方式 要改的
//                            jiedanyuanEntity.setJiedanyuanEmail(data.get(0));                    //邮箱 要改的
//                            jiedanyuanEntity.setNewMoney(data.get(0));                    //工资 要改的
//                            jiedanyuanEntity.setInsertTime(date);//时间
//                            jiedanyuanEntity.setCreateTime(date);//时间
                            jiedanyuanList.add(jiedanyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("jiedanyuanPhone")){
                                    List<String> jiedanyuanPhone = seachFields.get("jiedanyuanPhone");
                                    jiedanyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jiedanyuanPhone = new ArrayList<>();
                                    jiedanyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("jiedanyuanPhone",jiedanyuanPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<JiedanyuanEntity> jiedanyuanEntities_username = jiedanyuanService.selectList(new EntityWrapper<JiedanyuanEntity>().in("username", seachFields.get("username")));
                        if(jiedanyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiedanyuanEntity s:jiedanyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<JiedanyuanEntity> jiedanyuanEntities_jiedanyuanPhone = jiedanyuanService.selectList(new EntityWrapper<JiedanyuanEntity>().in("jiedanyuan_phone", seachFields.get("jiedanyuanPhone")));
                        if(jiedanyuanEntities_jiedanyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiedanyuanEntity s:jiedanyuanEntities_jiedanyuanPhone){
                                repeatFields.add(s.getJiedanyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiedanyuanService.insertBatch(jiedanyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        JiedanyuanEntity jiedanyuan = jiedanyuanService.selectOne(new EntityWrapper<JiedanyuanEntity>().eq("username", username));
        if(jiedanyuan==null || !jiedanyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(jiedanyuan.getId(),username, "jiedanyuan", "接单员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","接单员");
        r.put("username",jiedanyuan.getJiedanyuanName());
        r.put("tableName","jiedanyuan");
        r.put("userId",jiedanyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JiedanyuanEntity jiedanyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<JiedanyuanEntity> queryWrapper = new EntityWrapper<JiedanyuanEntity>()
            .eq("username", jiedanyuan.getUsername())
            .or()
            .eq("jiedanyuan_phone", jiedanyuan.getJiedanyuanPhone())
            ;
        JiedanyuanEntity jiedanyuanEntity = jiedanyuanService.selectOne(queryWrapper);
        if(jiedanyuanEntity != null)
            return R.error("账户或者联系方式已经被使用");
        jiedanyuan.setNewMoney(0.0);
        jiedanyuan.setInsertTime(new Date());
        jiedanyuan.setCreateTime(new Date());
        jiedanyuanService.insert(jiedanyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        JiedanyuanEntity jiedanyuan = new JiedanyuanEntity();
        jiedanyuan.setPassword("123456");
        jiedanyuan.setId(id);
        jiedanyuan.setInsertTime(new Date());
        jiedanyuanService.updateById(jiedanyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        JiedanyuanEntity jiedanyuan = jiedanyuanService.selectOne(new EntityWrapper<JiedanyuanEntity>().eq("username", username));
        if(jiedanyuan!=null){
            jiedanyuan.setPassword("123456");
            boolean b = jiedanyuanService.updateById(jiedanyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrJiedanyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JiedanyuanEntity jiedanyuan = jiedanyuanService.selectById(id);
        if(jiedanyuan !=null){
            //entity转view
            JiedanyuanView view = new JiedanyuanView();
            BeanUtils.copyProperties( jiedanyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
