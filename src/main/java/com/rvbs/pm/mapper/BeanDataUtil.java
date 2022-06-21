package com.rvbs.pm.mapper;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.meta.When;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.apache.poi.ss.formula.functions.T;

import com.baomidou.mybatisplus.annotation.TableId;
import com.rvbs.pm.core.FieldColumn;
import com.rvbs.pm.model.UserInfo;


public class BeanDataUtil {
	
	static BeanDataUtil u=new BeanDataUtil();
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		UserInfo userInfo = new UserInfo();
		userInfo.setLoginstatus("0");
		u.sql(userInfo, 0, 0, "t_userdetail_info","t_userlogin_info");
//		Map<String ,T> m  = new HashMap<>();
//		test(m);
		
	}
	
	public static void test(Map<String, T> key) {
		
	}
	/**
	 * 
	 * @param <T>
	 * @param data 所要查询的对象
	 * @param page 查询偏移量
	 * @param size 查询的个数
	 * @param tables 要查的表
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	 public <T>  SQL sql(@Param("data")T data,@Param("page")int page,@Param("size")int size,@Param("tables")String... tables) throws IllegalArgumentException, IllegalAccessException {
		 SQL sqlObject = new SQL();
		 Field[] f = data.getClass().getDeclaredFields();
		 System.out.println(Arrays.asList(f));
		 sqlObject.SELECT("*");
		 sqlObject.FROM(tables);
		 for(Field s1 : f) {
			 s1.setAccessible(true); // 允许访问私有属性
			 if(s1.isAnnotationPresent(TableId.class)) {
				 sqlObject.WHERE(tables[0]+"."+s1.getName()+" = "+tables[1]+"."+s1.getName());
			 }
		 }
		 for(Field s1 : f) {
			 s1.setAccessible(true); // 允许访问私有属性
			 System.out.println(s1.getAnnotatedType());
			 
			 if(StringUtils.isNotBlank((String)s1.get(data))) {
				 if(s1.isAnnotationPresent(FieldColumn.class)) {//判断注解是否有指定表名，如果指定表明则将条件拼接
					 FieldColumn fieldColumn = s1.getDeclaredAnnotation(FieldColumn.class);
//					 System.out.println(fieldColumn.fieldTableName());
					 sqlObject.WHERE(fieldColumn.fieldTableName()+"."+s1.getName()+" = "+s1.get(data));
				 }else {
					 sqlObject.WHERE(s1.getName()+" = "+s1.get(data));
				}
				 
				
			 }
		 }
//		 判断是否需要分页
		 if (size != 0 ) {//所需要分页的条数不为0 
			sqlObject.OFFSET(page);
			sqlObject.LIMIT(size);
		}
		 System.out.println("通过反射获取的sql为："+sqlObject);
		 
		 return sqlObject;
		 
	 }
	 
	 
//	 public <T>  SQL sql1(Map<String, T> map) throws IllegalArgumentException, IllegalAccessException {
//		 SQL sqlObject = new SQL();
//		 T data = map.get("data");
//		 map.get
//		 Field[] f = data.getClass().getDeclaredFields();
//		 System.out.println(Arrays.asList(f));
//		 sqlObject.SELECT("*");
//		 sqlObject.FROM(tables);
//		 for(Field s1 : f) {
//			 s1.setAccessible(true); // 允许访问私有属性
//			 if(s1.isAnnotationPresent(TableId.class)) {
//				 sqlObject.WHERE(tables[0]+"."+s1.getName()+" = "+tables[1]+"."+s1.getName());
//			 }
//		 }
//		 for(Field s1 : f) {
//			 s1.setAccessible(true); // 允许访问私有属性
//			 System.out.println(s1.getAnnotatedType());
//			 
//			 if(StringUtils.isNotBlank((String)s1.get(data))) {
//				 if(s1.isAnnotationPresent(FieldColumn.class)) {//判断注解是否有指定表名，如果指定表明则将条件拼接
//					 FieldColumn fieldColumn = s1.getDeclaredAnnotation(FieldColumn.class);
////					 System.out.println(fieldColumn.fieldTableName());
//					 sqlObject.WHERE(fieldColumn.fieldTableName()+"."+s1.getName()+" = "+s1.get(data));
//				 }else {
//					 sqlObject.WHERE(s1.getName()+" = "+s1.get(data));
//				}
//				 
//				
//			 }
//		 }
////		 判断是否需要分页
//		 if (size != 0 ) {//所需要分页的条数不为0 
//			sqlObject.OFFSET(page);
//			sqlObject.LIMIT(size);
//		}
//		 System.out.println("通过反射获取的sql为："+sqlObject);
//		 
//		 return sqlObject;
//		 
//	 }
	 

}
