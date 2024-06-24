package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility 
{
	public static String filename = System.getProperty("user.dir")+"/TestData/testData.xlsx";
	public  String path;
	public  FileInputStream fis;
	public  FileOutputStream fileOut;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	
	
	public XLUtility(String path)
	{
		this.path = path;
		
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		fis= new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		
		return rowcount;
	}
	
	public int getCellCount(String sheetName , int rownum) throws IOException
	{
		fis= new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		
		int cellcount = row.getLastCellNum();
		workbook.close();
		fis.close();
		
		return cellcount;
	}
	
	public String getCellData(String sheetName, int rownum , int colnum) throws IOException
	{
		fis= new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		
		String data;
		try 
		{
			data = formatter.formatCellValue(cell);
		}
		catch (Exception e) 
		{
			data = "";
		}
		
		workbook.close();
		fis.close();
		return data;
	}

	public void setCellData(String sheetName, int rownum , int colnum, String data) throws IOException
	{
		File xlfile = new File(path);
		if(!xlfile.exists()) //If File Not Exists then Create New File
		{
			workbook = new XSSFWorkbook();
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			
		}
		
		fis = new FileInputStream(path);
		workbook= new XSSFWorkbook(fis);
		
		if(workbook.getSheetIndex(sheetName)==-1)  //If Sheet Not Exists then Create New Sheet
		
			workbook.createSheet(sheetName);
		 sheet=workbook.getSheet(sheetName);
		 
		 if(sheet.getRow(rownum)==null)  // If Row Not Exists then Create New Row
			 sheet.createRow(rownum);
		 row = sheet.getRow(rownum);
		
		 cell=row.createCell(colnum);
		 cell.setCellValue(data);
		 fileOut = new FileOutputStream(path);
		 workbook.write(fileOut);
		 workbook.close();
		 fis.close();
		 fileOut.close();
	}
	
	public void fillGreenColour(String sheetName, int rownum , int colnum) throws IOException
	{
		fis= new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();
		
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fileOut);
		workbook.close();
		fis.close();
		fileOut.close();
	}
	
	public void fillRedColour(String sheetName, int rownum , int colnum) throws IOException
	{
		fis= new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();
		
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fileOut);
		workbook.close();
		fis.close();
		fileOut.close();
	}
	
	
}
