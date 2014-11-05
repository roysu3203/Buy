package com.roy.buy.dao.imple;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.roy.buy.dao.IBaseDao;

/**
 * 基礎查詢 實作, 子介面需宣告 T 屬於何 Entity Class
 */
public class BaseDao<T extends Serializable> implements IBaseDao<T> {

	/** Entity Class */
	private Class<T> clazz;

    /** 自動注入 SessionFactory */
	@Autowired
	@Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

	/** 無參數建構子 */
	public BaseDao(){
		
	} 

	/** 建構子, 供子類別傳入 Entity Class */
	public BaseDao(final Class<T> clazz) {
		this.clazz = clazz;
	}
	
	/**
	 * 新增 Entity, 回傳 ID
	 */
	@Override
	public Integer save(T entity) {
		return (Integer) getSession().save(entity);
	}

	/**
	 * 新增或修改 Entity, 用ID區別功能
	 */
	@Override
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	/**
	 * 刪除 Entity
	 */
	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	/**
	 * 查詢整個 Table, 取得 Entity List
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getSession().createCriteria(clazz).list();
	}

	/**
	 * 根據 ID, 取得 Entity
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Integer id) {
		return (T) getSession().get(clazz, id);
	}
	
	/**
	 * 根據欄位名稱與查詢條件，回傳 Entity
	 */
	@SuppressWarnings("unchecked")
	public T findBy(String columnName, Object value) {
		T entity = null;
        Criteria criteria = getSession().createCriteria(clazz);    
        criteria.add(Restrictions.in(columnName, new Object[]{value}));
        if(criteria.list().size() > 0) {
        	entity = (T) criteria.list().get(0); 
        }
        return entity;
    }
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
