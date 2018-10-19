package com.vns.service;

import com.vns.vo.TokenUser;


/**
 * Token用户Service
 * @author Lvp
 *
 */
public interface ITokenUserService {

	public void addTokenUser(TokenUser tu);
	
	/**
	 * 从昨天的交易里，查询Token交易往来地址，不在Token用户表里的，说明是Token新用户。将其地址添加到Token用户表中
	 * 凌晨定时任务调用，一天统计一次
	 */
	public void addYesterdayNewTokenUser();
}
