package com.vns.dao;

import java.util.List;

import com.vns.vo.HomeBlock;

/**
 * 区块概览
 * @author Lvp
 *
 */
public interface HomeBlockMapper {

	public HomeBlock queryNewData();
    public HomeBlock query();
    public int queryCount(HomeBlock hb);
    public void insert(HomeBlock hb);
    public void udpate(HomeBlock hb);
    public void delete();
}
