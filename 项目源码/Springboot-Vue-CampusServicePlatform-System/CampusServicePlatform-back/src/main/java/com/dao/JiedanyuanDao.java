package com.dao;

import com.entity.JiedanyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiedanyuanView;

/**
 * 接单员 Dao 接口
 *
 * @author 
 */
public interface JiedanyuanDao extends BaseMapper<JiedanyuanEntity> {

   List<JiedanyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
