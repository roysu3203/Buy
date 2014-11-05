package com.roy.buy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roy.buy.dao.IUserDao;
import com.roy.buy.entity.User;
import com.roy.buy.exception.DataCheckException;
import com.roy.buy.service.IUserService;

/**
 * 使用者相關操作 Service 實作
 */
@Service("userService")
@Transactional
public class UserService implements IUserService {
	
	/** 自動注入 UserDao */
	@Autowired
	private IUserDao userDao;

	/**
	 * 使用者註冊
	 * @throws DataCheckException 
	 */
	@Override
	public void register(User user) throws DataCheckException {
		// 驗證是否有相同帳號
		User validateAccountUser = userDao.findByAccount(user.getAccount());
		if(validateAccountUser != null) {
			throw new DataCheckException(1);
		}			
		// 驗證是否有相同Email
		User validateEmailUser = userDao.findByEmail(user.getEmail());
		if(validateEmailUser != null) {
			throw new DataCheckException(2);
		}
		userDao.save(user);
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
