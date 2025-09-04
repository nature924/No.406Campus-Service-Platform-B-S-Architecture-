package com.entity.vo;

import com.entity.YonghutousuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 用户投诉
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yonghutousu")
public class YonghutousuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 投诉标题
     */

    @TableField(value = "yonghutousu_name")
    private String yonghutousuName;


    /**
     * 投诉类型
     */

    @TableField(value = "yonghutousu_types")
    private Integer yonghutousuTypes;


    /**
     * 投诉详情
     */

    @TableField(value = "yonghutousu_content")
    private String yonghutousuContent;


    /**
     * 投诉状态
     */

    @TableField(value = "yonghutousu_yesno_types")
    private Integer yonghutousuYesnoTypes;


    /**
     * 投诉结果
     */

    @TableField(value = "yonghutousu_yesno_text")
    private String yonghutousuYesnoText;


    /**
     * 投诉时间
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
	 * 设置：投诉标题
	 */
    public String getYonghutousuName() {
        return yonghutousuName;
    }


    /**
	 * 获取：投诉标题
	 */

    public void setYonghutousuName(String yonghutousuName) {
        this.yonghutousuName = yonghutousuName;
    }
    /**
	 * 设置：投诉类型
	 */
    public Integer getYonghutousuTypes() {
        return yonghutousuTypes;
    }


    /**
	 * 获取：投诉类型
	 */

    public void setYonghutousuTypes(Integer yonghutousuTypes) {
        this.yonghutousuTypes = yonghutousuTypes;
    }
    /**
	 * 设置：投诉详情
	 */
    public String getYonghutousuContent() {
        return yonghutousuContent;
    }


    /**
	 * 获取：投诉详情
	 */

    public void setYonghutousuContent(String yonghutousuContent) {
        this.yonghutousuContent = yonghutousuContent;
    }
    /**
	 * 设置：投诉状态
	 */
    public Integer getYonghutousuYesnoTypes() {
        return yonghutousuYesnoTypes;
    }


    /**
	 * 获取：投诉状态
	 */

    public void setYonghutousuYesnoTypes(Integer yonghutousuYesnoTypes) {
        this.yonghutousuYesnoTypes = yonghutousuYesnoTypes;
    }
    /**
	 * 设置：投诉结果
	 */
    public String getYonghutousuYesnoText() {
        return yonghutousuYesnoText;
    }


    /**
	 * 获取：投诉结果
	 */

    public void setYonghutousuYesnoText(String yonghutousuYesnoText) {
        this.yonghutousuYesnoText = yonghutousuYesnoText;
    }
    /**
	 * 设置：投诉时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：投诉时间
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
