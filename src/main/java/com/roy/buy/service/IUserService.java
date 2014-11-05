package com.roy.buy.service;

import com.roy.buy.entity.User;
import com.roy.buy.exception.DataCheckException;

/**
 * 使用者相關操作 Service 介面
 */
public interface IUserService {
	
	/**
	 * 使用者註冊, 若帳號或信箱已被申請過會拋出例外
	 */
	public void register(User user) throws DataCheckException;
	
}
