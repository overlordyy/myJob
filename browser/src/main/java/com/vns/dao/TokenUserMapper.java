package com.vns.dao;

import java.util.List;

import com.vns.vo.TokenUser;

/**
 * Token用户
 * @author Lvp
 *
 */
public interface TokenUserMapper {

	
    public List<TokenUser> queryByTime(TokenUser tu);
    public int queryByTimeCount(TokenUser tu);
    
    /**
     * 查询所有Token的用户数量
     * @return
     */
    public List<TokenUser> queryTokenUserNum();
    
    /**
     * 根据 合约地址和用户地址判断是否已经存在，如果存在，则不再新增
     * @param tu
     * @return
     */
    public int isExists(TokenUser tu);
    
    /**
     * 新增 Token 用户
     * @param tu
     */
    public void insert(TokenUser tu);
}
