package com.rvbs.pm.excel;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.EasyExcel;
//import com.rvbs.pm.model.UserInfo;

public class ExcelWriteTool<T> {
	
	/** 头数据 */
	private List<List<String>>  headList = new ArrayList<List<String>>();
	
	/** 体数据 */
	private List<List<T>> bodyData = new ArrayList<List<T>>();
	
	/** 文件路径 */
	private String filePath;
	/** sheetName */
	private String sheetName = "模板";
	/** 头部Class */
	private Class<?> headClass;
	/** 样式 */
	private DefultAbstractHandleCellStyle writeHandler;
	
	public <K> ExcelWriteTool(String filePath,String sheetName,Class<K> headClass,DefultAbstractHandleCellStyle writeHandler) {
		this.filePath = filePath;
		this.sheetName = sheetName;
		this.headClass = headClass;
		if(writeHandler == null) {
			this.writeHandler = new DefultHandleCellStyle();
		}else {
			this.writeHandler = writeHandler;
		}
		
	}
	public <K> ExcelWriteTool(String filePath,String sheetName,Class<K> headClass){
		this(filePath, sheetName, headClass, null);
	}
	public <K> ExcelWriteTool(String filePath,String sheetName){
		this(filePath, sheetName, null, null);
	}
	public void setHeadList(List<String> headData) {
		if(headData == null) return;
		this.headList.add(headData);
	}

	public void setBodyData(List<T> bodyData) {
//		this.bodyData.(bodyData);
		this.bodyData.add(bodyData) ;
	}

	/**
	 * 写入excel(bean为头)
	 * 定义modle处理写入头部数据,构建方法时：传入headClass定义头部数据
	 */
	public void writeBeanExcel() {
		if(headClass == null) {
			EasyExcel.write(this.filePath).registerWriteHandler(writeHandler).sheet(this.sheetName).doWrite(this.bodyData);
		}else {
			EasyExcel.write(this.filePath, this.headClass).registerWriteHandler(writeHandler).sheet(this.sheetName).doWrite(this.bodyData);
		}
		
	}
	
	/**
	 * 自定义头 
	 *  setHeadList 传入其定义头部数据
	 */
	public void writeCustomHeadExcel() {
		if(headList.isEmpty()) {
			EasyExcel.write(this.filePath).registerWriteHandler(writeHandler).sheet(this.sheetName).doWrite(this.bodyData);
		}else {
			System.out.println("*******"+headList.size());
			EasyExcel.write(this.filePath).head(headList).registerWriteHandler(writeHandler).sheet(this.sheetName).doWrite(this.bodyData);
		}
	}
	
	

	/**
	 * 清空数据
	 */
	public void clearData() {
		bodyData.clear();
		headList.clear();
	}
	
	public static void main(String[] args) {
//		EasyExcel.write(filename, DemoData.class).sheet("列表").doWrite(getData());
		
//		ExcelWriteTool<UserInfo> s = new ExcelWriteTool<UserInfo>("", "", null);
		// 第一种写法
//		UserInfo u = new UserInfo();
//		u.setUserId("1");
////		UserInfo u1 = new UserInfo();
//		u.setUserId("2");
////		s.setBodyData(u);
////		s.setBodyData(u1);
//		
//		// 第二种写法
//		
//		List<UserInfo> l1 = new ArrayList<UserInfo>();
//		UserInfo u2 = new UserInfo();
//		u2.setUserId("1");
//		UserInfo u3 = new UserInfo();
//		u3.setUserId("2");
//		l1.add(u2);
//		l1.add(u3);
//		s.setBodyData(l1);
//		
//		s.writeCustomHeadExcel();
	}
		
}
