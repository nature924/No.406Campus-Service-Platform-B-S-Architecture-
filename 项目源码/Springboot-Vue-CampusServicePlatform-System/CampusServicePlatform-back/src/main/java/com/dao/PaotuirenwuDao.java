package com.dao;

import com.entity.PaotuirenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PaotuirenwuView;

/**
 * 跑腿任务 Dao 接口
 *
 * @author 
 */
public interface PaotuirenwuDao extends BaseMapper<PaotuirenwuEntity> {

   List<PaotuirenwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
