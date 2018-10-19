package com.vns.dao;

import java.util.List;

import com.vns.vo.PriceMarket;

/**
 * 币价行情
 * @author Lvp
 *
 */
public interface PriceMarketMapper {

	//TODO : SQL 未完成
	/**
	 * 查询某一段时间的行情
	 * 做图表会用到（行情折线图
	 * @param pm
	 * @return
	 */
    public List<PriceMarket> queryByTime(PriceMarket pm);
    public int queryByTimeCount(PriceMarket pm);
    
    //TODO : SQL 未完成
    /**
     * 查询过去某个时间点的行情
     * @param pm
     * @return
     */
    public PriceMarket querySingleByTime(PriceMarket pm);
    
    /**
     * 从交易所同步行情数据，15S一次
     * @param pm
     */
    public void insert(PriceMarket pm);
    
}
