package com.rvbs.pm.tool;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * jwts工具类
 * @author xiaole
 *
 */
public class JwtsUtil {
	
	/** 加密密钥 */
	private static final String SECRETKEY = "12345678";
	
//	private static final String PRE_SECRET = "PMSIGN";
	
	/**
	 * 获取token
	 * @param map 自定义Map
	 * @param maxTime 最大超时时间
	 * @return
	 */
	public static String getToken(Map<String, Object> map,Long maxTime) {
		return getToken(map, null, null, maxTime);
	}
	
	/**
	 * 获取token
	 * @param map 自定义对象
	 * @param issuser 签发用户
	 * @param subject 面向用户
	 * @param maxTime 最大超时时间
	 * @return
	 */
	public static String getToken(Map<String, Object> map,String issuser,String subject,Long maxTime) {
		Date now = new Date(System.currentTimeMillis());
		String token = Jwts.builder().
			setClaims(map) // 自定义对象
			.setIssuedAt(now) // 签发日期
			.setIssuer(issuser) // 签发用户
			.setExpiration(new Date(now.getTime()+maxTime)) // 到期日期
			.setSubject(subject) // 面向用户
			.signWith(SignatureAlgorithm.HS512, SECRETKEY) // 签名类型以及密钥
			.compact();
		return token;
	}
	
	/**
	 * 解析签名
	 * @param token token
	 * @return
	 */
	public static Map<String,Object> unSign(String token) {
		return Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody();
	}
	
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", "001");
		map.put("userName", "普通用户");
		String token = JwtsUtil.getToken(map, 3600_000L);
		
		System.out.println(token);
		System.out.println(unSign(token));
		
	}
}
