package com.entity.model;

import com.entity.PaotuirenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 跑腿任务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PaotuirenwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 任务编号
     */
    private String paotuirenwuUuidNumber;


    /**
     * 任务标题
     */
    private String paotuirenwuName;


    /**
     * 任务类型
     */
    private Integer paotuirenwuTypes;


    /**
     * 单价
     */
    private Double paotuirenwuNewMoney;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 地址
     */
    private Integer shouhuodizhiId;


    /**
     * 任务备注
     */
    private String paotuirenwuText;


    /**
     * 任务状态
     */
    private Integer paotuirenwuStatusTypes;


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
	 * 获取：任务编号
	 */
    public String getPaotuirenwuUuidNumber() {
        return paotuirenwuUuidNumber;
    }


    /**
	 * 设置：任务编号
	 */
    public void setPaotuirenwuUuidNumber(String paotuirenwuUuidNumber) {
        this.paotuirenwuUuidNumber = paotuirenwuUuidNumber;
    }
    /**
	 * 获取：任务标题
	 */
    public String getPaotuirenwuName() {
        return paotuirenwuName;
    }


    /**
	 * 设置：任务标题
	 */
    public void setPaotuirenwuName(String paotuirenwuName) {
        this.paotuirenwuName = paotuirenwuName;
    }
    /**
	 * 获取：任务类型
	 */
    public Integer getPaotuirenwuTypes() {
        return paotuirenwuTypes;
    }


    /**
	 * 设置：任务类型
	 */
    public void setPaotuirenwuTypes(Integer paotuirenwuTypes) {
        this.paotuirenwuTypes = paotuirenwuTypes;
    }
    /**
	 * 获取：单价
	 */
    public Double getPaotuirenwuNewMoney() {
        return paotuirenwuNewMoney;
    }


    /**
	 * 设置：单价
	 */
    public void setPaotuirenwuNewMoney(Double paotuirenwuNewMoney) {
        this.paotuirenwuNewMoney = paotuirenwuNewMoney;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：地址
	 */
    public Integer getShouhuodizhiId() {
        return shouhuodizhiId;
    }


    /**
	 * 设置：地址
	 */
    public void setShouhuodizhiId(Integer shouhuodizhiId) {
        this.shouhuodizhiId = shouhuodizhiId;
    }
    /**
	 * 获取：任务备注
	 */
    public String getPaotuirenwuText() {
        return paotuirenwuText;
    }


    /**
	 * 设置：任务备注
	 */
    public void setPaotuirenwuText(String paotuirenwuText) {
        this.paotuirenwuText = paotuirenwuText;
    }
    /**
	 * 获取：任务状态
	 */
    public Integer getPaotuirenwuStatusTypes() {
        return paotuirenwuStatusTypes;
    }


    /**
	 * 设置：任务状态
	 */
    public void setPaotuirenwuStatusTypes(Integer paotuirenwuStatusTypes) {
        this.paotuirenwuStatusTypes = paotuirenwuStatusTypes;
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
