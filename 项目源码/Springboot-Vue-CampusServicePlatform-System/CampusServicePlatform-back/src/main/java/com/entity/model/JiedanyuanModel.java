package com.entity.model;

import com.entity.JiedanyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 接单员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiedanyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 接单员姓名
     */
    private String jiedanyuanName;


    /**
     * 头像
     */
    private String jiedanyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 联系方式
     */
    private String jiedanyuanPhone;


    /**
     * 邮箱
     */
    private String jiedanyuanEmail;


    /**
     * 工资
     */
    private Double newMoney;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show2 photoShow
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：接单员姓名
	 */
    public String getJiedanyuanName() {
        return jiedanyuanName;
    }


    /**
	 * 设置：接单员姓名
	 */
    public void setJiedanyuanName(String jiedanyuanName) {
        this.jiedanyuanName = jiedanyuanName;
    }
    /**
	 * 获取：头像
	 */
    public String getJiedanyuanPhoto() {
        return jiedanyuanPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setJiedanyuanPhoto(String jiedanyuanPhoto) {
        this.jiedanyuanPhoto = jiedanyuanPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getJiedanyuanPhone() {
        return jiedanyuanPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setJiedanyuanPhone(String jiedanyuanPhone) {
        this.jiedanyuanPhone = jiedanyuanPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getJiedanyuanEmail() {
        return jiedanyuanEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setJiedanyuanEmail(String jiedanyuanEmail) {
        this.jiedanyuanEmail = jiedanyuanEmail;
    }
    /**
	 * 获取：工资
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 设置：工资
	 */
    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
