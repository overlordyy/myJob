package com.vns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vns.dao.TokenUserMapper;
import com.vns.service.ITokenUserService;
import com.vns.service.ITransactionService;
import com.vns.vo.TokenUser;
import com.vns.vo.TransactionInfo;

/**
 * Token用户 Service
 * @author Lvp
 *
 */
@Service
public class TokenUserService implements ITokenUserService {

	@Autowired
	public TokenUserMapper tum;
	@Autowired
	private ITransactionService its;
	
	@Override
	public void addTokenUser(TokenUser tu) {
		if (null == tu) {
			return;
		}
		// 先查询是否存在，存在则不再添加
		int isExist = tum.isExists(tu);
		if (0 == isExist) {
			tum.insert(tu);
		}
	}

	/**
	 * 从昨天的交易里，查询Token交易往来地址，不在Token用户表里的，说明是Token新用户。将其地址添加到Token用户表中
	 * 凌晨定时任务调用，一天统计一次
	 */
	public void addYesterdayNewTokenUser() {
		// 先查询昨天的发送交易地址，查询时即过滤掉已经在用户表里的地址
		List<TransactionInfo> tokenFromAddrs = its.getYesterdayTokenTxFromAddr();
		for (int i = 0;i < tokenFromAddrs.size(); i++) {
			TransactionInfo tx = tokenFromAddrs.get(i);
			TokenUser newUser = new TokenUser();
			newUser.setUserAddress(tx.getFromAddress());
			newUser.setCreateTime(tx.getTransactionTime());
			tum.insert(newUser);
		}
		// 查询昨天的接收交易地址，查询时即过滤掉已经在用户表里的地址
		List<TransactionInfo> tokenToAddrs = its.getYesterdayTokenTxToAddr();
		for (int i = 0; i < tokenToAddrs.size(); i++) {
			TransactionInfo txTo = tokenToAddrs.get(i);
			TokenUser newUser = new TokenUser();
			newUser.setUserAddress(txTo.getToAddress());
			newUser.setCreateTime(txTo.getTransactionTime());
			tum.insert(newUser);
		}
	}
}
