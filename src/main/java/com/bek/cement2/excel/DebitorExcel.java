package com.bek.cement2.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bek.cement2.entity.DailyInfo;

public class DebitorExcel {

	
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<DailyInfo> listMalumot;
    
	public DebitorExcel(List<DailyInfo> listMalumot) {
		super();
		this.listMalumot = listMalumot;
		workbook = new XSSFWorkbook();
	}
    
    
	 private void writeHeaderLine() {
	        sheet = workbook.createSheet("Users");
	         
	        Row row = sheet.createRow(0);
	         
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	         
	        createCell(row, 0, "Sana", style);      
	        createCell(row, 1, "Boshlangich Debitor Xolati", style);       
	        createCell(row, 2, "Debitor Qo'shildi", style);    
	        createCell(row, 3, "Debitor Qaytdi", style);
	        createCell(row, 4, "Oxirgi Debitor Xolati", style);
	       
	         
	    }
	 private void createCell(Row row, int columnCount, Object value, CellStyle style) {
	        sheet.autoSizeColumn(columnCount);
	        Cell cell = row.createCell(columnCount);
	        if (value instanceof Float) {
	            cell.setCellValue((Float) value);
	        } else if (value instanceof Double) {
	            cell.setCellValue((Double) value);
	        } else if (value instanceof Integer) {
	            cell.setCellValue((Integer) value);
	        }
	        else {
	            cell.setCellValue((String) value);
	        }
	        cell.setCellStyle(style);
	    }
	 private void writeDataLines() {
	        int rowCount = 1;
	 
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	                 
	        for (DailyInfo m : listMalumot) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	             
	            createCell(row, columnCount++, m.getSana().toString(), style);
	            createCell(row, columnCount++, m.getBoshlangich_debitor(), style);
	            createCell(row, columnCount++, m.getDebitorda_hamma_narx(), style);
	            createCell(row, columnCount++, m.getDebitordan_qaytgan_narx(), style);
	            createCell(row, columnCount++, m.getDebitorda_qoldiq_narx(), style);
	            
	             
	        }
	    }
	 public void export(HttpServletResponse response) throws IOException {
	        writeHeaderLine();
	        writeDataLines();
	         
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	         
	        outputStream.close();
	         
	    }
	
}
