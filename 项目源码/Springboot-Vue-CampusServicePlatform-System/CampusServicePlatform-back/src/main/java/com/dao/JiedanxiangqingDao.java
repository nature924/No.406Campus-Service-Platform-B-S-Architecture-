package com.dao;

import com.entity.JiedanxiangqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiedanxiangqingView;

/**
 * 接单详情 Dao 接口
 *
 * @author 
 */
public interface JiedanxiangqingDao extends BaseMapper<JiedanxiangqingEntity> {

   List<JiedanxiangqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
