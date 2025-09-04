package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 接单详情
 *
 * @author 
 * @email
 */
@TableName("jiedanxiangqing")
public class JiedanxiangqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiedanxiangqingEntity() {

	}

	public JiedanxiangqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiedanxiangqing{" +
            "id=" + id +
            ", paotuirenwuId=" + paotuirenwuId +
            ", jiedanyuanId=" + jiedanyuanId +
            ", jiedanxiangqingStatusTypes=" + jiedanxiangqingStatusTypes +
            ", createTime=" + createTime +
        "}";
    }
}
