package com.entity.vo;

import com.entity.YuebiangengjilEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 余额变更记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuebiangengjil")
public class YuebiangengjilVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户姓名
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 原因
     */

    @TableField(value = "yuebiangengjil_name")
    private String yuebiangengjilName;


    /**
     * 涉及数量
     */

    @TableField(value = "yuebiangengjil_number")
    private Double yuebiangengjilNumber;


    /**
     * 类型
     */

    @TableField(value = "jifen_types")
    private Integer jifenTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：用户姓名
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户姓名
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：原因
	 */
    public String getYuebiangengjilName() {
        return yuebiangengjilName;
    }


    /**
	 * 获取：原因
	 */

    public void setYuebiangengjilName(String yuebiangengjilName) {
        this.yuebiangengjilName = yuebiangengjilName;
    }
    /**
	 * 设置：涉及数量
	 */
    public Double getYuebiangengjilNumber() {
        return yuebiangengjilNumber;
    }


    /**
	 * 获取：涉及数量
	 */

    public void setYuebiangengjilNumber(Double yuebiangengjilNumber) {
        this.yuebiangengjilNumber = yuebiangengjilNumber;
    }
    /**
	 * 设置：类型
	 */
    public Integer getJifenTypes() {
        return jifenTypes;
    }


    /**
	 * 获取：类型
	 */

    public void setJifenTypes(Integer jifenTypes) {
        this.jifenTypes = jifenTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

}
