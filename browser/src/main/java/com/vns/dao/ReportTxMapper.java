package com.vns.dao;

import java.util.List;

import com.vns.vo.ReportTransation;

/**
 * 报表-交易
 * @author Lvp
 *
 */
public interface ReportTxMapper {

	/**
	 * 根据时间段获取
	 * @param vnsValue
	 * @return
	 */
	public List<ReportTransation> getReportByTime(ReportTransation rtx);
	
	/**
	 * 获取全部数据
	 * @return
	 */
	public List<ReportTransation> getReportAllData();
	
	/**
	 * 获取昨天的交易数据：交易额、交易量、手续费
	 * @param rtx 昨天的开始、结束时间
	 * @return
	 */
	public ReportTransation statTxData(ReportTransation rtx);
	
	/**
	 * 判断是否有记录在库里
	 * @param rtx 通过日期查找
	 * @return 0=无，>0 则已有
	 */
	public int isExist(ReportTransation rtx);
	
	/**
	 * 插入
	 * @param vnsValue
	 */
	public void insert(ReportTransation rtx);
	
	/**
	 * 更新
	 * @param rtx 根据日期更新
	 */
	public void update(ReportTransation rtx);
}
