package com.vns.vo;

import java.util.Date;

/**
 * 数据字典配置信息
 * @author Lvp
 *
 */
public class DictionaryInfo extends BaseDomain {

	private String dataKey; // key
	private String dataValue; // value
	private String creater; // 
	private Date createTime; // 
	private String remark; // 
	
	
	public String getDataKey() {
		return dataKey;
	}
	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
