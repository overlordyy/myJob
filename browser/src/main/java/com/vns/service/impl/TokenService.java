package com.vns.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.vns.dao.HomeTokenMapper;
import com.vns.dao.TokenMapper;
import com.vns.redisUtils.ConfigUtils;
import com.vns.redisUtils.SerializeUtil;
import com.vns.service.ITokenService;
import com.vns.util.DateUtil;
import com.vns.vo.DataResult;
import com.vns.vo.HomeToken;
import com.vns.vo.TableSplitResult;
import com.vns.vo.TokenInfo;

@Service
public class TokenService implements ITokenService{

	@Autowired
	public TokenMapper tm;
	@Autowired
	public HomeTokenMapper htm;
	@Override
	public TableSplitResult<TokenInfo> findTokenList(TokenInfo ti) {
		TableSplitResult<TokenInfo> result = new TableSplitResult<TokenInfo>();
		int count = tm.queryAllForCount(ti);
		if(count != 0){
			result.setRows(tm.queryAll(ti));
			result.setTotal(count);
		}
		return result;
	}
	@Override
	public DataResult<HomeToken> findHomeToken() {
		Jedis jedis = new Jedis(ConfigUtils.ip, ConfigUtils.port);
		DataResult<HomeToken> dr = new DataResult<HomeToken>();
		HomeToken ht = new HomeToken();
		ht = htm.findHomeToken();
		try {
			BigDecimal bd1 = new BigDecimal(ht.getTokenPoundageSum());
			BigDecimal bd2 = new BigDecimal(ht.getMaxPoundage());
			BigDecimal bd3 = new BigDecimal(ht.getTokenGasSum());
			ht.setTokenPoundageSumStr(DateUtil.toDecimal(18, new BigInteger(bd1.toString())));
			ht.setMaxPoundageStr(DateUtil.toDecimal(18, new BigInteger(bd2.toString())));
			ht.setTokenGasSumStr(bd3.toString());
			dr.setData(ht);
			jedis.set("findHomeToken".getBytes(), SerializeUtil.serialize(dr));
		} finally { 
//			JedisUtils.returnResource(jedis);
//			jedis.close();
		}
		return dr;
	}

}
