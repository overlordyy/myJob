package com.vns.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vns.dao.ReportPirceMapper;
import com.vns.service.IReportPriceService;
import com.vns.vo.ReportPrice;

@Service
public class ReportPriceService extends ReportService implements IReportPriceService {

	@Autowired
	private ReportPirceMapper rpm;
	
	@Override
	public List<ReportPrice> getReportAllData() {
		return rpm.getReportAllData();
	}

	/**
	 * 统计具体执行方法
	 * 注：只统计1天的
	 * @param begin
	 * @param end
	 */
	@Override
	public void statDataImpl(Date begin, Date end) {
		ReportPrice param = new ReportPrice();
		param.setBeginDate(begin);
		param.setEndDate(end);
		
		ReportPrice rp = rpm.getLastPrice(param);
		if (null != rp) {
			int isExist = rpm.isExist(rp);
			if (isExist > 0) {
				// 更新
				rpm.update(rp);
			} else {
				// 入库
				rpm.insert(rp);
			}
		}
	}

}
