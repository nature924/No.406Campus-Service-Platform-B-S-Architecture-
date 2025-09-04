package com.dao;

import com.entity.ShouhuodizhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShouhuodizhiView;

/**
 * 收货地址 Dao 接口
 *
 * @author 
 */
public interface ShouhuodizhiDao extends BaseMapper<ShouhuodizhiEntity> {

   List<ShouhuodizhiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
