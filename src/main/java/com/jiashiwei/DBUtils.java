package com.jiashiwei;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {
   private static ComboPooledDataSource ds=new ComboPooledDataSource();
   private static QueryRunner r=new QueryRunner(ds);
   //��ɾ�Ĳ���
   public static void update(String sql,Object...args){
	   try {
		r.update(sql,args);
	} catch (SQLException e) {
		e.printStackTrace();
	}
   }
   public static <T> List<T> query(Class clazz,String sql,Object...args){
	   try {
		return  r.query(sql, new BeanListHandler<T>(clazz),args);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   return null;
   }
}
