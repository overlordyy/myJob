package com.vns.dao;

import java.util.List;

import com.vns.vo.TokenUser;

/**
 * Token用户
 * @author Lvp
 *
 */
public interface TokenUserMapper {

	//TODO : SQL 未完成
    public List<TokenUser> queryByTime(TokenUser tu);
    public int queryByTimeCount(TokenUser tu);
    
    //TODO : 还需要实现
    // 1.查询每个Token有多少用户
    // 2.查询用户最多的Token
    
    /**
     * 根据 合约地址和用户地址判断是否已经存在，如果存在，则不再新增
     * @param tu
     * @return
     */
    public int isExists(TokenUser tu);
    
    public void insert(TokenUser tu);
}
