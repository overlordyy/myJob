package com.vns.dao;

import java.util.List;

import com.vns.vo.ReportPrice;

/**
 * 报表-币价
 * @author Lvp
 *
 */
public interface ReportPirceMapper {

	/**
	 * 根据时间段获取
	 * @param vnsValue
	 * @return
	 */
	public List<ReportPrice> getReportByTime(ReportPrice rp);
	
	/**
	 * 获取全部数据
	 * @return
	 */
	public List<ReportPrice> getReportAllData();
	
	/**
	 * 获得昨天最后的一条币价，从币价表t_price_market中获得。 插入报表用的币价表，1天一次
	 * @param rp 昨日时间
	 * @return
	 */
	public ReportPrice getLastPrice(ReportPrice rp);
	
	/**
	 * 判断是否有记录在库里
	 * @param rp 通过日期查找
	 * @return 0=无，>0 则已有
	 */
	public int isExist(ReportPrice rp);
	
	/**
	 * 插入
	 * @param vnsValue
	 */
	public void insert(ReportPrice rp);
	
	/**
	 * 更新
	 * @param rp 根据日期更新
	 */
	public void update(ReportPrice rp);
}
