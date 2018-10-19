package com.vns.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vns.vo.TokenInfo;

/**
 * Created by Administrator on 2018/7/11.
 */
public interface TokenMapper {

    /**
     * 查询全部token，管理员功能
     * @param qo  可根据搜索条件过滤
     * @return
     */
    public List<TokenInfo> queryAll(TokenInfo ti);
    public int queryAllForCount(TokenInfo ti);
    public void insertToken(TokenInfo ti);
    public int findTokenByAddress(@Param("tokenReceivetAddress") String tokenReceivetAddress);

}
