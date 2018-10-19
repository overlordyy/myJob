package com.vns.dao;

import java.util.List;

import com.vns.vo.HomeBlock;

/**
 * 区块概览
 * @author Lvp
 *
 */
public interface HomeBlockMapper {

    public List<HomeBlock> query(HomeBlock hb);
    public int queryCount(HomeBlock hb);
    public void insert(HomeBlock hb);
    public void udpate(HomeBlock hb);
}
