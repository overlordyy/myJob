package com.vns.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vns.dao.ReportTokenTxMapper;
import com.vns.service.IReportTokenTxService;
import com.vns.util.Constants;
import com.vns.vo.ReportTokenTx;

@Service
public class ReportTokenTxService extends ReportService implements IReportTokenTxService{

	@Autowired
	private ReportTokenTxMapper rttm;
	
	@Override
	public List<ReportTokenTx> getReportAllData() {
		return rttm.getReportAllData();
	}
	
	/**
	 * 统计具体执行方法
	 * 注：只统计1天的
	 * @param begin
	 * @param end
	 */
	@Override
	public void statDataImpl(Date begin, Date end) {
		ReportTokenTx param = new ReportTokenTx();
		param.setBeginDate(begin);
		param.setEndDate(end);
		ReportTokenTx rttx = rttm.statTokenTxData(param);
		
		if (null != rttx) {
			// 将 手续费的单位从 Wei 转为 VNS
			double txPou = rttx.getTokenTxPoundage() / Constants.Trasaction.WEI_4_VNS_UNIT;
			
			rttx.setTokenTxPoundage(txPou);;
			rttx.setCreateDate(end);
		
			int isExist = rttm.isExist(rttx);
			if (isExist > 0) {
				// 更新
				rttm.update(rttx);
			} else {
				// 入库
				rttm.insert(rttx);
			}
		}
	}
}
