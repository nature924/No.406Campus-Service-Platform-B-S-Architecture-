package com.entity.vo;

import com.entity.JiedanxiangqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 接单详情
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiedanxiangqing")
public class JiedanxiangqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 任务
     */

    @TableField(value = "paotuirenwu_id")
    private Integer paotuirenwuId;


    /**
     * 接单员
     */

    @TableField(value = "jiedanyuan_id")
    private Integer jiedanyuanId;


    /**
     * 接单状态
     */

    @TableField(value = "jiedanxiangqing_status_types")
    private Integer jiedanxiangqingStatusTypes;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：任务
	 */
    public Integer getPaotuirenwuId() {
        return paotuirenwuId;
    }


    /**
	 * 获取：任务
	 */

    public void setPaotuirenwuId(Integer paotuirenwuId) {
        this.paotuirenwuId = paotuirenwuId;
    }
    /**
	 * 设置：接单员
	 */
    public Integer getJiedanyuanId() {
        return jiedanyuanId;
    }


    /**
	 * 获取：接单员
	 */

    public void setJiedanyuanId(Integer jiedanyuanId) {
        this.jiedanyuanId = jiedanyuanId;
    }
    /**
	 * 设置：接单状态
	 */
    public Integer getJiedanxiangqingStatusTypes() {
        return jiedanxiangqingStatusTypes;
    }


    /**
	 * 获取：接单状态
	 */

    public void setJiedanxiangqingStatusTypes(Integer jiedanxiangqingStatusTypes) {
        this.jiedanxiangqingStatusTypes = jiedanxiangqingStatusTypes;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
