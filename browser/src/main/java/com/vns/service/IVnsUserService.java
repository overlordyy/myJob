package com.vns.service;

import com.vns.vo.VnsUser;

/**
 * Vns用户
 * @author Lvp
 *
 */
public interface IVnsUserService {

	/**
	 * 添加用户
	 * @param vu
	 */
	public void addUser(VnsUser vu);
	
	/**
	 * 添加昨天新增的用户
	 * 定时任务调用
	 */
	public void addYesterdayNewUser();
}
