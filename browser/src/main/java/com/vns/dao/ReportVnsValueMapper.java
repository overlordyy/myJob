package com.vns.dao;

import java.util.List;

import com.vns.vo.ReportVnsValue;

/**
 * 报表-市值
 * @author Lvp
 *
 */
public interface ReportVnsValueMapper {

	/**
	 * 根据时间段获取
	 * @param vnsValue
	 * @return
	 */
	public List<ReportVnsValue> getReportByTime(ReportVnsValue vnsValue);
	
	/**
	 * 获取全部数据
	 * @return
	 */
	public List<ReportVnsValue> getReportAllData();
	
	/**
	 * 判断是否有记录在库里
	 * @param vnsValue 通过日期查找
	 * @return 0=无，>0 则已有
	 */
	public int isExist(ReportVnsValue vnsValue);
	
	/**
	 * 插入
	 * @param vnsValue
	 */
	public void insert(ReportVnsValue vnsValue);
	
	/**
	 * 更新
	 * @param vnsValue 根据日期更新
	 */
	public void update(ReportVnsValue vnsValue);
}
