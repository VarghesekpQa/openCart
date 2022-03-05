package com.opencart.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow wr;
	public static XSSFCell wc;
	
	
	public static int getRowNum(String xcelFile,String sheet) throws IOException {
		
		fi = new FileInputStream(xcelFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		int rowNum = ws.getLastRowNum();	
		wb.close();
		fi.close();
		
		return rowNum;
	}
	
	public static int getCellNum(String xcelFile,String sheet, int rownum) throws IOException {
		
		fi = new FileInputStream(xcelFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		wr = ws.getRow(rownum);
		int cellNum = wr.getLastCellNum();
		
		wb.close();
		fi.close();
		
		return cellNum;
		
	}
	
	public static String getCellData(String xcelFile,String sheet,int row,int cell) throws IOException {
		
		fi = new FileInputStream(xcelFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		wr = ws.getRow(row);
		wc = wr.getCell(cell);
			
		DataFormatter  fr = new DataFormatter();
		String cellData = fr.formatCellValue(wc);
				
		wb.close();
		fi.close();
	
		return cellData;
	}
}
