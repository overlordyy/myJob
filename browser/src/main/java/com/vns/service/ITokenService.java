package com.vns.service;

import com.vns.vo.DataResult;
import com.vns.vo.HomeToken;
import com.vns.vo.TableSplitResult;
import com.vns.vo.TokenInfo;
import com.vns.vo.TransactionInfo;

public interface ITokenService {
	
	public TableSplitResult<TokenInfo> findTokenList(TokenInfo ti);
	
	public DataResult<HomeToken> findHomeToken();
}
