package com.roy.buy.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.roy.buy.entity.User;

/**
 * 註冊 Form
 */
public class RegisterForm {
	
	private String account;
	private String password;
	private String name;
	private String email;
	
	/** 錯誤訊息 */
	private List<String> errorMessage = new ArrayList<String>();
	
	/**
	 * 驗證 RegisterForm, 若驗證失敗回傳 true
	 */
	public boolean validateFail() {
		errorMessage.clear();
		if(account.length() == 0) {
			errorMessage.add("帳號不能空著哦！");
		}
		if(password.length() == 0) {
			errorMessage.add("密碼不能空著哦！");
		}
		if(name.length() == 0) {
			errorMessage.add("姓名不能空著哦！");
		}
		if(email.length() == 0) {
			errorMessage.add("Email不能空著哦！");
		}
		return errorMessage.size() > 0;
	}
	
	/**
	 * 取得驗證失敗的錯誤訊息
	 */
	public List<String> getErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * 將 RegisterForm 轉為 User
	 */
	public User toUser() {
		User user = new User();
		user.setAccount(account);
		user.setPassword(DigestUtils.md5Hex(password));
		user.setName(name);
		user.setEmail(email);
		return user;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
