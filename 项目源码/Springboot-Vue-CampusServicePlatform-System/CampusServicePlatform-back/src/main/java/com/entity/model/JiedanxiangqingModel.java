package com.entity.model;

import com.entity.JiedanxiangqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 接单详情
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiedanxiangqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 任务
     */
    private Integer paotuirenwuId;


    /**
     * 接单员
     */
    private Integer jiedanyuanId;


    /**
     * 接单状态
     */
    private Integer jiedanxiangqingStatusTypes;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：任务
	 */
    public Integer getPaotuirenwuId() {
        return paotuirenwuId;
    }


    /**
	 * 设置：任务
	 */
    public void setPaotuirenwuId(Integer paotuirenwuId) {
        this.paotuirenwuId = paotuirenwuId;
    }
    /**
	 * 获取：接单员
	 */
    public Integer getJiedanyuanId() {
        return jiedanyuanId;
    }


    /**
	 * 设置：接单员
	 */
    public void setJiedanyuanId(Integer jiedanyuanId) {
        this.jiedanyuanId = jiedanyuanId;
    }
    /**
	 * 获取：接单状态
	 */
    public Integer getJiedanxiangqingStatusTypes() {
        return jiedanxiangqingStatusTypes;
    }


    /**
	 * 设置：接单状态
	 */
    public void setJiedanxiangqingStatusTypes(Integer jiedanxiangqingStatusTypes) {
        this.jiedanxiangqingStatusTypes = jiedanxiangqingStatusTypes;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
