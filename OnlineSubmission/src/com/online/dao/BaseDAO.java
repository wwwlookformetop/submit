package com.online.dao;


import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import com.online.utils.JDBCUtils;
/*
 * ����daoʵ����ĸ���
 */
public abstract class BaseDAO<T> { // Map<K,V>

	private Class<T> beanClass;
	private QueryRunner queryRunner = new QueryRunner();

	public BaseDAO() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass()
				.getGenericSuperclass();
		beanClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];

	}

	/*
	 * ִ��DML,������ɾ�ĵĲ���
	 */
	public void update(String sql, Object... params) {
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getConn();
			queryRunner.update(conn, sql, params);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCUtils.close(conn);
	}

	/*
	 * ִ��DQL,�õ�����
	 */
	public T query(String sql, Object... params) {
		Connection conn = null;
		T t = null;

		try {
			conn = JDBCUtils.getConn();
			t = queryRunner.query(conn, sql, new BeanHandler<T>(beanClass),
					params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCUtils.close(conn);
		return t;
	}

	/*
	 * ִ��DQL,�õ�����ļ���
	 */
	public List<T> queryForList(String sql, Object... params) {

		Connection conn = null;
		List<T> list = new ArrayList<T>();

		try {
			conn = JDBCUtils.getConn();
			list = queryRunner.query(conn, sql, new BeanListHandler<T>(
					beanClass), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCUtils.close(conn);
		return list;
	}
	
	/**
	 *  ִ��DQL, �õ���һ�������еĵ�һ���ֶε�ֵ
	 * @param sql
	 * @param params
	 * @return
	 */
	public <K> K QueryForSingleValue(String sql, Object... params) {
		K k = null;
		Connection conn = null;

		try {
			conn = JDBCUtils.getConn();
			k = (K) queryRunner.query(conn, sql, new ScalarHandler(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCUtils.close(conn);
		return k;
	}
	
	/**
	 * ��������
	 * @param sql
	 * @param params
	 */
	public void batch(String sql, Object[]... params) {
		Connection conn = null;

		try {
			conn = JDBCUtils.getConn();
			queryRunner.batch(conn, sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

