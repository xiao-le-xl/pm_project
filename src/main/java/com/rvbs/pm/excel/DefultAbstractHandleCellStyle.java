package com.rvbs.pm.excel;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StyleUtil;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.AbstractCellStyleStrategy;

public abstract  class DefultAbstractHandleCellStyle extends AbstractCellStyleStrategy {

    /**
    *   WorkBoot
    * */
    private Workbook workbook;
	@Override
	protected void initCellStyle(Workbook workbook) {
		// TODO Auto-generated method stub
		this.workbook = workbook;
	}
	protected Workbook getWorkbook() {
		return workbook;
	}
	@Override
	protected void setHeadCellStyle(Cell cell, Head head, Integer relativeRowIndex) {
		// TODO Auto-generated method stub
		WriteCellStyle writeCellStyle=new WriteCellStyle();
		CellStyle headCellStyle = StyleUtil.buildContentCellStyle(workbook, writeCellStyle);
//		defaultHeadStyle(writeCellStyle, headCellStyle, cell);
		setHeadStyle(headCellStyle, cell);
	}
	@Override
	protected void setContentCellStyle(Cell cell, Head head, Integer relativeRowIndex) {
		// TODO Auto-generated method stub
		WriteCellStyle writeCellStyle=new WriteCellStyle();
		CellStyle bodyCellStyle = StyleUtil.buildContentCellStyle(workbook, writeCellStyle);
		setBodyStyle(bodyCellStyle, cell);
	}
	/**
	 * 继承此类,设置head样式 , 可参考的defaultHeadStyle
	 * @param writeCellStyle 写单元格样式对象
	 * @param headCellStyle head单元格样式对象
	 * @param headCell 单元格对象
	 */
	protected abstract void setHeadStyle(CellStyle headCellStyle,Cell headCell);
	/**
	 *  继承此类,设置body样式 , 可参考defaultBodyStyle
	 * @param writeCellStyle 写单元格样式对象
	 * @param bodyCellStyle body单元格样式对象
	 * @param bodyCell 单元格对象
	 */
	protected abstract void setBodyStyle(CellStyle bodyCellStyle,Cell bodyCell);
}
