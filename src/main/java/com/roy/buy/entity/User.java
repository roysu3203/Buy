package com.roy.buy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 使用者
 */
@SuppressWarnings("serial")
@Entity
public class User implements Serializable {

	/** 主鍵, 使用者 ID */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** 帳號 */
	private String account;
	
	/** 密碼 */
	private String password;
	
	/** 姓名 */
	private String name;
	
	/** 信箱 */
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}
