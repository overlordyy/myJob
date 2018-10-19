package com.vns.service;

import com.vns.vo.PriceMarket;

/**
 * 币价行情 Service 接口
 * @author Lvp
 *
 */
public interface IPriceMarketService {

	/**
	 * 获取1天（24H整）前的币价
	 * @return
	 */
	public PriceMarket before24HPrice();
	
	/**
     * 获取当前最新币价
     * @return
     */
    public PriceMarket queryRecentPrice();
    
    /**
     * 实时获取币价
     */
    public void homeTask();
    
    /**
     * 获取汇率
     */
    public void exchangeRate();
}
