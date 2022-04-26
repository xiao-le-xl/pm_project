package com.rvbs.pm.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.rvbs.pm.core.BaseBean;
import com.rvbs.pm.core.Service;
/**
 * Excel读取监听抽象类
 * @author xiaole
 *
 * @param <T>
 */
public abstract class ExcelAbstractReadListen<T extends BaseBean> extends AnalysisEventListener<T>{
	
	/** 日志对象 */
	private final Logger logger = LoggerFactory.getLogger(ExcelAbstractReadListen.class);
	
//	/* 缓存数据 **/
	private List<BaseBean> cacheDataList;
	/** 总的缓存数据 */
	private Map<String,List<BaseBean>> totalCacheDataMap;
	
	/** 执行最大处理数 */
	private final int MAX_COUNT = 100;
	
	/** 基本Mapper处理对象 */
	private Service<?>[] mappersy;
	
	public ExcelAbstractReadListen() {
		cacheDataList = new ArrayList<BaseBean>();
		totalCacheDataMap = new HashMap<String, List<BaseBean>>();
	}

	protected Service<?>[] getMappersy() {
		return mappersy;
	}

	public void setMappersy(Service<?>...mappersy) {
		this.mappersy = mappersy;
	}

	@Override
	public void invoke(T data, AnalysisContext context) {
		// TODO Auto-generated method stub
		// 1 - 判断数据是否正确
		if(!this.dataCheck(data)) { 
			return;
		}
		// 2 - 添加缓存数据
		this.cacheDataList.add(data);
		// 3 - 数据处理
		this.dataHandle(data);
		
		// 4 - 判断数据是否超过最大，执行入库等操作 
		if (this.cacheDataList.size() >= MAX_COUNT) {
			this.bathInsert(this.totalCacheDataMap); // 批量入库草最
			this.cacheDataList.clear(); // 清理list缓存数据
			this.totalCacheDataMap.clear(); // 清理map总缓存数据
		}
		
	}
	/**
	 * 添加用户bean
	 * @param key 自定义key，注明：bathInsert取值根据key来取值
	 * @param baseBean
	 */
	public void addCashData(String key,BaseBean baseBean) {
		List<BaseBean> dataList = null;
		if(totalCacheDataMap.get(key) == null) {
			dataList = new ArrayList<BaseBean>();
		}else {
			dataList = totalCacheDataMap.get(key);
		}
		dataList.add(baseBean);
		totalCacheDataMap.put(key, dataList);
	}
	
	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		// TODO Auto-generated method stub
		this.bathInsert(this.totalCacheDataMap); // 批量入库草最
		this.cacheDataList.clear(); // 清理list缓存数据
	}
	
	/**
	 *  数据校验，提前检查是否可入库
	 * @param data 缓存数据
	 * @return
	 */
	protected abstract boolean dataCheck(T data);
	
	/**
	 *  数据处理，如需对缓存数据处理，可再此方法里处理
	 * @param data 缓存数据
	 * @return
	 */
	protected  abstract void dataHandle(T data);
	
	/**
	 * 	执行数据存储操作，批量更新或批量插入
	 * @param cacheDataList 缓存数据
	 */
	protected abstract void bathInsert(Map<String,List<BaseBean>> totalCacheDataMap);
	
	/**
	 * 读取Excel
	 * @param filePath 文件路径
	 * @param clazz ExcelBean对象class 例如： Excelbean.class
	 * @param headRowNum  头行数
	 * @param sheetNum 读取地几个sheet页
	 */
	public boolean excelRead(String filePath,Class<?> clazz,int headRowNum,int sheetNum) {
		try {
			EasyExcel.read(new FileInputStream(filePath),clazz,this).headRowNumber(headRowNum).sheet(sheetNum).doRead();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info("文件不存在：",e);
			return false;
		}
		return true;
	}
	
	@Override
	public void onException(Exception exception, AnalysisContext context) throws Exception {
		// TODO Auto-generated method stub
		logger.error("第{}行异常了：",context.readRowHolder().getRowIndex(),exception);
	}
}
