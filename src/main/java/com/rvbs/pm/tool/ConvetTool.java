package com.rvbs.pm.tool;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * 转换工具
 * @author xiaole
 *
 */
public class ConvetTool {
	/**
	 * java对象转换为Map
	 * @param object 对象 
	 * @return
	 * @throws Exceptionc
	 */
	public static Map<String, Object> convert(Object object) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Class<?> clazz = object.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			if (Modifier.isFinal(field.getModifiers()))
				continue;

			field.setAccessible(true);
			String value = field.get(object) != null ? field.get(object).toString() : "";

			map.put(field.getName(), value);
		}
		return map;
	}
}
