package com.vns.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vns.dao.BlockMapper;
import com.vns.dao.ReportPirceMapper;
import com.vns.dao.ReportVnsValueMapper;
import com.vns.service.IReportVnsValueService;
import com.vns.util.Constants;
import com.vns.vo.ReportPrice;
import com.vns.vo.ReportVnsValue;

@Service
public class ReportVnsValueService extends ReportService implements IReportVnsValueService {

	@Autowired
	private BlockMapper bm;
	
	@Autowired
	private ReportPirceMapper rpm;
	
	@Autowired
	private ReportVnsValueMapper rvvm;
	
	@Override
	public List<ReportVnsValue> getReportAllData() {
		return rvvm.getReportAllData();
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
			// 获取出币总量
			long allCoins = bm.rewardSum()+Constants.DictionaryPath.PREDUG;
			// 计算总市值
			ReportVnsValue vnsValue = new ReportVnsValue();
			vnsValue.setRmbValue(allCoins * rp.getRmbPrice());
			vnsValue.setDollerValue(allCoins * rp.getDollerPrice());
			vnsValue.setEthValue(allCoins * rp.getEthPrice());
			vnsValue.setCreateDate(end);
			
			int isExist = rvvm.isExist(vnsValue);
			if (isExist > 0) {
				// 更新
				rvvm.update(vnsValue);
			} else {
				// 入库
				rvvm.insert(vnsValue);
			}
		}
	}
}
