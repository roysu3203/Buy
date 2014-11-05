package com.roy.buy.dao;

import com.roy.buy.entity.User;

/**
 * 使用者相關查詢 介面
 */
public interface IUserDao extends IBaseDao<User> {

	/**
	 * 根據帳號查詢, 若查詢不到回傳 null
	 */
	public User findByAccount(String account);
	
	/**
	 * 根據 EMail 查詢, 若查詢不到回傳 null
	 */
	public User findByEmail(String email);

}
