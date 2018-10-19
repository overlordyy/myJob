package com.vns.dao;

import java.util.List;

import com.vns.vo.ReportTokenTx;

/**
 * 报表-Token交易
 * @author Lvp
 *
 */
public interface ReportTokenTxMapper {

	/**
	 * 根据时间段获取
	 * @param vnsValue
	 * @return
	 */
	public List<ReportTokenTx> getReportByTime(ReportTokenTx rtt);
	
	/**
	 * 获取全部数据
	 * @return
	 */
	public List<ReportTokenTx> getReportAllData();
	
	/**
	 * 获取昨天的Token交易数据：交易额、交易量、手续费
	 * @param rtx 昨天的开始、结束时间
	 * @return
	 */
	public ReportTokenTx statTokenTxData(ReportTokenTx rttx);
	
	/**
	 * 判断是否有记录在库里
	 * @param rtt 通过日期查找
	 * @return 0=无，>0 则已有
	 */
	public int isExist(ReportTokenTx rtt);
	
	/**
	 * 插入
	 * @param vnsValue
	 */
	public void insert(ReportTokenTx rtt);
	
	/**
	 * 更新
	 * @param rtt 根据日期更新
	 */
	public void update(ReportTokenTx rtt);
}
