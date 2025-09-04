package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghutousuEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户投诉 服务类
 */
public interface YonghutousuService extends IService<YonghutousuEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}