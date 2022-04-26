package com.rvbs.pm.excel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;

public class DefultHandleCellStyle extends DefultAbstractHandleCellStyle{

	@Override
	public void setHeadStyle( CellStyle headCellStyle, Cell headCell) {
		// TODO Auto-generated method stub
		this.defaultHeadStyle(headCellStyle, headCell);
	}

	@Override
	public void setBodyStyle( CellStyle bodyCellStyle, Cell bodyCell) {
		// TODO Auto-generated method stub
		this.defaultBodyStyle(bodyCellStyle, bodyCell);
	}
	/**
	 *  默认Head样式
	 * @param headCellStyle head单元格样式对象
	 * @param cell 单元格对象
	 */
	private void defaultHeadStyle(CellStyle headCellStyle,Cell cell) {
		// TODO Auto-generated method stub
		 // WriteCellStyle转换为CellStyle
		Font cellFont = this.getWorkbook().createFont();
		cellFont.setBold(true);
		cellFont.setFontName("隶书");
		cellFont.setFontHeightInPoints((short) 14);
		headCellStyle.setFont(cellFont);
		headCellStyle.setBorderBottom(BorderStyle.THIN);
		headCellStyle.setBorderLeft(BorderStyle.THIN);
		headCellStyle.setBorderRight(BorderStyle.THIN);
		headCellStyle.setBorderTop(BorderStyle.THIN);
		headCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
		headCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(headCellStyle);
	}
	/**
	 *  默认body样式
	 * @param headCellStyle body单元格样式对象
	 * @param cell 单元格对象
	 */
	private void defaultBodyStyle(CellStyle bodyCellStyle,Cell cell) {
       // 设置体样式
       // WriteCellStyle转换为CellStyle
		Font cellFont = this.getWorkbook().createFont();
       cellFont.setBold(true);
       cellFont.setFontName("隶书");
       cellFont.setFontHeightInPoints((short) 9);
       bodyCellStyle.setFont(cellFont);
       bodyCellStyle.setBorderBottom(BorderStyle.THIN);
       bodyCellStyle.setBorderLeft(BorderStyle.THIN);
       bodyCellStyle.setBorderRight(BorderStyle.THIN);
       bodyCellStyle.setBorderTop(BorderStyle.THIN);
       //设置前景色是需设置setFillPattern
       bodyCellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
       bodyCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
       
       bodyCellStyle.setAlignment(HorizontalAlignment.CENTER);
       cell.setCellStyle(bodyCellStyle);
	}
}
