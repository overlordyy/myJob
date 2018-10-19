package com.vns.dao;

import java.util.List;

import com.vns.vo.ReportUser;

/**
 * 报表-用户
 * @author Lvp
 *
 */
public interface ReportUserMapper {

	/**
	 * 根据时间段获取
	 * @param vnsValue
	 * @return
	 */
	public List<ReportUser> getReportByTime(ReportUser ru);
	
	/**
	 * 获取全部数据
	 * @return
	 */
	public List<ReportUser> getReportAllData();
	
	/**
	 * 统计昨天的新增用户数
	 * @param ru 昨天开始、结束时间
	 * @return
	 */
	public ReportUser statYesterdayUserData(ReportUser ru);
	
	/**
	 * 判断是否有记录在库里
	 * @param ru 通过日期查找
	 * @return 0=无，>0 则已有
	 */
	public int isExist(ReportUser ru);
	
	/**
	 * 插入
	 * @param vnsValue
	 */
	public void insert(ReportUser ru);
	
	/**
	 * 更新
	 * @param ru 根据日期更新
	 */
	public void update(ReportUser ru);
}
