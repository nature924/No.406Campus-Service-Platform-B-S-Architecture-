package com.entity.view;

import com.entity.JiedanxiangqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 接单详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiedanxiangqing")
public class JiedanxiangqingView extends JiedanxiangqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 接单状态的值
		*/
		private String jiedanxiangqingStatusValue;



		//级联表 jiedanyuan
			/**
			* 接单员姓名
			*/
			private String jiedanyuanName;
			/**
			* 头像
			*/
			private String jiedanyuanPhoto;
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

		//级联表 paotuirenwu
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
				* 任务类型的值
				*/
				private String paotuirenwuValue;
			/**
			* 单价
			*/
			private Double paotuirenwuNewMoney;
			/**
			* 跑腿任务 的 用户
			*/
			private Integer paotuirenwuYonghuId;
			/**
			* 任务备注
			*/
			private String paotuirenwuText;
			/**
			* 任务状态
			*/
			private Integer paotuirenwuStatusTypes;
				/**
				* 任务状态的值
				*/
				private String paotuirenwuStatusValue;

	public JiedanxiangqingView() {

	}

	public JiedanxiangqingView(JiedanxiangqingEntity jiedanxiangqingEntity) {
		try {
			BeanUtils.copyProperties(this, jiedanxiangqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 接单状态的值
			*/
			public String getJiedanxiangqingStatusValue() {
				return jiedanxiangqingStatusValue;
			}
			/**
			* 设置： 接单状态的值
			*/
			public void setJiedanxiangqingStatusValue(String jiedanxiangqingStatusValue) {
				this.jiedanxiangqingStatusValue = jiedanxiangqingStatusValue;
			}











				//级联表的get和set jiedanyuan

					/**
					* 获取： 接单员姓名
					*/
					public String getJiedanyuanName() {
						return jiedanyuanName;
					}
					/**
					* 设置： 接单员姓名
					*/
					public void setJiedanyuanName(String jiedanyuanName) {
						this.jiedanyuanName = jiedanyuanName;
					}

					/**
					* 获取： 头像
					*/
					public String getJiedanyuanPhoto() {
						return jiedanyuanPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setJiedanyuanPhoto(String jiedanyuanPhoto) {
						this.jiedanyuanPhoto = jiedanyuanPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getJiedanyuanPhone() {
						return jiedanyuanPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setJiedanyuanPhone(String jiedanyuanPhone) {
						this.jiedanyuanPhone = jiedanyuanPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getJiedanyuanEmail() {
						return jiedanyuanEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setJiedanyuanEmail(String jiedanyuanEmail) {
						this.jiedanyuanEmail = jiedanyuanEmail;
					}

					/**
					* 获取： 工资
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 工资
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}





				//级联表的get和set paotuirenwu

					/**
					* 获取： 任务编号
					*/
					public String getPaotuirenwuUuidNumber() {
						return paotuirenwuUuidNumber;
					}
					/**
					* 设置： 任务编号
					*/
					public void setPaotuirenwuUuidNumber(String paotuirenwuUuidNumber) {
						this.paotuirenwuUuidNumber = paotuirenwuUuidNumber;
					}

					/**
					* 获取： 任务标题
					*/
					public String getPaotuirenwuName() {
						return paotuirenwuName;
					}
					/**
					* 设置： 任务标题
					*/
					public void setPaotuirenwuName(String paotuirenwuName) {
						this.paotuirenwuName = paotuirenwuName;
					}

					/**
					* 获取： 任务类型
					*/
					public Integer getPaotuirenwuTypes() {
						return paotuirenwuTypes;
					}
					/**
					* 设置： 任务类型
					*/
					public void setPaotuirenwuTypes(Integer paotuirenwuTypes) {
						this.paotuirenwuTypes = paotuirenwuTypes;
					}


						/**
						* 获取： 任务类型的值
						*/
						public String getPaotuirenwuValue() {
							return paotuirenwuValue;
						}
						/**
						* 设置： 任务类型的值
						*/
						public void setPaotuirenwuValue(String paotuirenwuValue) {
							this.paotuirenwuValue = paotuirenwuValue;
						}

					/**
					* 获取： 单价
					*/
					public Double getPaotuirenwuNewMoney() {
						return paotuirenwuNewMoney;
					}
					/**
					* 设置： 单价
					*/
					public void setPaotuirenwuNewMoney(Double paotuirenwuNewMoney) {
						this.paotuirenwuNewMoney = paotuirenwuNewMoney;
					}

					/**
					* 获取：跑腿任务 的 用户
					*/
					public Integer getPaotuirenwuYonghuId() {
						return paotuirenwuYonghuId;
					}
					/**
					* 设置：跑腿任务 的 用户
					*/
					public void setPaotuirenwuYonghuId(Integer paotuirenwuYonghuId) {
						this.paotuirenwuYonghuId = paotuirenwuYonghuId;
					}



					/**
					* 获取： 任务备注
					*/
					public String getPaotuirenwuText() {
						return paotuirenwuText;
					}
					/**
					* 设置： 任务备注
					*/
					public void setPaotuirenwuText(String paotuirenwuText) {
						this.paotuirenwuText = paotuirenwuText;
					}

					/**
					* 获取： 任务状态
					*/
					public Integer getPaotuirenwuStatusTypes() {
						return paotuirenwuStatusTypes;
					}
					/**
					* 设置： 任务状态
					*/
					public void setPaotuirenwuStatusTypes(Integer paotuirenwuStatusTypes) {
						this.paotuirenwuStatusTypes = paotuirenwuStatusTypes;
					}


						/**
						* 获取： 任务状态的值
						*/
						public String getPaotuirenwuStatusValue() {
							return paotuirenwuStatusValue;
						}
						/**
						* 设置： 任务状态的值
						*/
						public void setPaotuirenwuStatusValue(String paotuirenwuStatusValue) {
							this.paotuirenwuStatusValue = paotuirenwuStatusValue;
						}
















}
