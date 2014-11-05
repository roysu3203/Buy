package com.roy.buy.dao.imple;

import org.springframework.stereotype.Service;

import com.roy.buy.dao.IUserDao;
import com.roy.buy.entity.User;

/**
 * 使用者相關查詢 實作
 */
@Service("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {
	
	/**
	 * 於建構子使用 BaseDao 建構子, 傳入Entity Class
	 */
	public UserDao() {
		super(User.class);
	}

	/**
	 * 根據帳號查詢, 若查詢不到回傳 null
	 */
	@Override
	public User findByAccount(String account) {
		return super.findBy("account", account);
	}
	
	/**
	 * 根據 EMail 查詢, 若查詢不到回傳 null
	 */
	@Override
	public User findByEmail(String email) {
		return findBy("email", email);
	}

}
