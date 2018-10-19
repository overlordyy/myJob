package com.vns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vns.dao.VnsUserMapper;
import com.vns.service.ITransactionService;
import com.vns.service.IVnsUserService;
import com.vns.vo.TransactionInfo;
import com.vns.vo.VnsUser;

@Service
public class VnsUserService implements IVnsUserService {

	@Autowired
	private VnsUserMapper vum;
	@Autowired
	private ITransactionService its;
	
	@Override
	public void addUser(VnsUser vu) {
		if (null == vu) {
			return;
		}
		// 先查询是否存在，存在则不再添加
		int isExist = vum.isExists(vu);
		if (0 == isExist) {
			vum.insert(vu);
		}
	}
	
	/**
	 * 从昨天的交易里，查询交易往来地址，不在用户表里的，说明是新用户。将其地址添加到用户表中
	 * 凌晨定时任务调用
	 */
	public void addYesterdayNewUser() {
		// 先查询昨天的发送交易地址，查询时即过滤掉已经在用户表里的地址
		List<TransactionInfo> txFromAddrs = its.getYesterdayTxFromAddr();
		for (int i = 0;i < txFromAddrs.size(); i++) {
			TransactionInfo tx = txFromAddrs.get(i);
			VnsUser newUser = new VnsUser();
			newUser.setUserAddress(tx.getFromAddress());
			newUser.setCreateTime(tx.getTransactionTime());
			vum.insert(newUser);
		}
		// 查询昨天的接收交易地址，查询时即过滤掉已经在用户表里的地址
		List<TransactionInfo> txToAddrs = its.getYesterdayTxToAddr();
		for (int i = 0; i < txToAddrs.size(); i++) {
			TransactionInfo txTo = txFromAddrs.get(i);
			VnsUser newUser = new VnsUser();
			newUser.setUserAddress(txTo.getToAddress());
			newUser.setCreateTime(txTo.getTransactionTime());
			vum.insert(newUser);
		}
	}

}
