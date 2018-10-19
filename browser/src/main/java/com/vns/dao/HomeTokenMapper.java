package com.vns.dao;

import java.util.List;

import com.vns.vo.HomeToken;

/**
 * Token概览
 * @author Lvp
 *
 */
public interface HomeTokenMapper {

    public List<HomeToken> query(HomeToken ht);
    public int queryCount(HomeToken ht);
    public void insert(HomeToken ht);
    public void udpate(HomeToken ht);
    public HomeToken findHomeToken();
}
