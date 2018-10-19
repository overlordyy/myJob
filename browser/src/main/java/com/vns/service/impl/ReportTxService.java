package com.vns.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vns.dao.ReportTxMapper;
import com.vns.service.IReportTxService;
import com.vns.util.Constants;
import com.vns.vo.ReportTransation;

@Service
public class ReportTxService extends ReportService implements IReportTxService{

	@Autowired
	private ReportTxMapper rtm;
	
	@Override
	public List<ReportTransation> getReportAllData() {
		return rtm.getReportAllData();
	}
	
	/**
	 * 统计具体执行方法
	 * 注：只统计1天的
	 * @param begin
	 * @param end
	 */
	@Override
	public void statDataImpl(Date begin, Date end) {
		ReportTransation param = new ReportTransation();
		param.setBeginDate(begin);
		param.setEndDate(end);
		ReportTransation rtx = rtm.statTxData(param);
		
		if (null != rtx) {
			// 将交易额 和 手续费的单位从 Wei 转为 VNS
			double txValue = rtx.getTransactionTotal() / Constants.Trasaction.WEI_4_VNS_UNIT;
			double txPou = rtx.getTransactionPoundage() / Constants.Trasaction.WEI_4_VNS_UNIT;
			
			rtx.setTransactionTotal(txValue);
			rtx.setTransactionPoundage(txPou);
			rtx.setCreateDate(end);
		
			int isExist = rtm.isExist(rtx);
			if (isExist > 0) {
				// 更新
				rtm.update(rtx);
			} else {
				// 入库
				rtm.insert(rtx);
			}
		}
	}
}
