package com.roy.buy.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 基礎查詢 介面, 子介面需宣告 T 屬於何 Entity Class
 */
public interface IBaseDao<T extends Serializable> {

	/**
	 * 新增 Entity, 回傳 ID
	 */
	public Integer save(T entity);

	/**
	 * 新增或修改 Entity, 用ID區別功能
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 刪除 Entity
	 */
	public void delete(T entity);

	/**
	 * 查詢整個 Table, 取得 Entity List
	 */
	public List<T> findAll();

	/**
	 * 根據 ID, 取得 Entity
	 */
	public T findById(Integer id);
	
}
