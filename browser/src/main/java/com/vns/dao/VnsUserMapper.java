package com.vns.dao;

import com.vns.vo.VnsUser;

/**
 * VNS 用户
 * @author Lvp
 *
 */
public interface VnsUserMapper {

	/**
	 * 判断用户是否存在
	 * @param vu 用户地址判断
	 * @return
	 */
	public int isExists(VnsUser vu);
    
    /**
     * 新增 VNS 用户
     * @param tu
     */
    public void insert(VnsUser vu);
}
