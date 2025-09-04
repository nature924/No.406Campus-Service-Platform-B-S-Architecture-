package com.entity.vo;

import com.entity.PaotuirenwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 跑腿任务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("paotuirenwu")
public class PaotuirenwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 任务编号
     */

    @TableField(value = "paotuirenwu_uuid_number")
    private String paotuirenwuUuidNumber;


    /**
     * 任务标题
     */

    @TableField(value = "paotuirenwu_name")
    private String paotuirenwuName;


    /**
     * 任务类型
     */

    @TableField(value = "paotuirenwu_types")
    private Integer paotuirenwuTypes;


    /**
     * 单价
     */

    @TableField(value = "paotuirenwu_new_money")
    private Double paotuirenwuNewMoney;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 地址
     */

    @TableField(value = "shouhuodizhi_id")
    private Integer shouhuodizhiId;


    /**
     * 任务备注
     */

    @TableField(value = "paotuirenwu_text")
    private String paotuirenwuText;


    /**
     * 任务状态
     */

    @TableField(value = "paotuirenwu_status_types")
    private Integer paotuirenwuStatusTypes;


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
	 * 设置：任务编号
	 */
    public String getPaotuirenwuUuidNumber() {
        return paotuirenwuUuidNumber;
    }


    /**
	 * 获取：任务编号
	 */

    public void setPaotuirenwuUuidNumber(String paotuirenwuUuidNumber) {
        this.paotuirenwuUuidNumber = paotuirenwuUuidNumber;
    }
    /**
	 * 设置：任务标题
	 */
    public String getPaotuirenwuName() {
        return paotuirenwuName;
    }


    /**
	 * 获取：任务标题
	 */

    public void setPaotuirenwuName(String paotuirenwuName) {
        this.paotuirenwuName = paotuirenwuName;
    }
    /**
	 * 设置：任务类型
	 */
    public Integer getPaotuirenwuTypes() {
        return paotuirenwuTypes;
    }


    /**
	 * 获取：任务类型
	 */

    public void setPaotuirenwuTypes(Integer paotuirenwuTypes) {
        this.paotuirenwuTypes = paotuirenwuTypes;
    }
    /**
	 * 设置：单价
	 */
    public Double getPaotuirenwuNewMoney() {
        return paotuirenwuNewMoney;
    }


    /**
	 * 获取：单价
	 */

    public void setPaotuirenwuNewMoney(Double paotuirenwuNewMoney) {
        this.paotuirenwuNewMoney = paotuirenwuNewMoney;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：地址
	 */
    public Integer getShouhuodizhiId() {
        return shouhuodizhiId;
    }


    /**
	 * 获取：地址
	 */

    public void setShouhuodizhiId(Integer shouhuodizhiId) {
        this.shouhuodizhiId = shouhuodizhiId;
    }
    /**
	 * 设置：任务备注
	 */
    public String getPaotuirenwuText() {
        return paotuirenwuText;
    }


    /**
	 * 获取：任务备注
	 */

    public void setPaotuirenwuText(String paotuirenwuText) {
        this.paotuirenwuText = paotuirenwuText;
    }
    /**
	 * 设置：任务状态
	 */
    public Integer getPaotuirenwuStatusTypes() {
        return paotuirenwuStatusTypes;
    }


    /**
	 * 获取：任务状态
	 */

    public void setPaotuirenwuStatusTypes(Integer paotuirenwuStatusTypes) {
        this.paotuirenwuStatusTypes = paotuirenwuStatusTypes;
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
