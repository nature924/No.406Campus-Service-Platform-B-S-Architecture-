package com.entity.view;

import com.entity.PaotuirenwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 跑腿任务
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("paotuirenwu")
public class PaotuirenwuView extends PaotuirenwuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 任务类型的值
		*/
		private String paotuirenwuValue;
		/**
		* 任务状态的值
		*/
		private String paotuirenwuStatusValue;



		//级联表 shouhuodizhi
			/**
			* 收货地址 的 创建用户
			*/
			private Integer shouhuodizhiYonghuId;
			/**
			* 收货人
			*/
			private String shouhuodizhiName;
			/**
			* 电话
			*/
			private String shouhuodizhiPhone;
			/**
			* 地址
			*/
			private String shouhuodizhiDizhi;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public PaotuirenwuView() {

	}

	public PaotuirenwuView(PaotuirenwuEntity paotuirenwuEntity) {
		try {
			BeanUtils.copyProperties(this, paotuirenwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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




















				//级联表的get和set shouhuodizhi

					/**
					* 获取：收货地址 的 创建用户
					*/
					public Integer getShouhuodizhiYonghuId() {
						return shouhuodizhiYonghuId;
					}
					/**
					* 设置：收货地址 的 创建用户
					*/
					public void setShouhuodizhiYonghuId(Integer shouhuodizhiYonghuId) {
						this.shouhuodizhiYonghuId = shouhuodizhiYonghuId;
					}


					/**
					* 获取： 收货人
					*/
					public String getShouhuodizhiName() {
						return shouhuodizhiName;
					}
					/**
					* 设置： 收货人
					*/
					public void setShouhuodizhiName(String shouhuodizhiName) {
						this.shouhuodizhiName = shouhuodizhiName;
					}

					/**
					* 获取： 电话
					*/
					public String getShouhuodizhiPhone() {
						return shouhuodizhiPhone;
					}
					/**
					* 设置： 电话
					*/
					public void setShouhuodizhiPhone(String shouhuodizhiPhone) {
						this.shouhuodizhiPhone = shouhuodizhiPhone;
					}

					/**
					* 获取： 地址
					*/
					public String getShouhuodizhiDizhi() {
						return shouhuodizhiDizhi;
					}
					/**
					* 设置： 地址
					*/
					public void setShouhuodizhiDizhi(String shouhuodizhiDizhi) {
						this.shouhuodizhiDizhi = shouhuodizhiDizhi;
					}


				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}










}
