package fileReading;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel_RW_EX {
	
	/*
	 * four classes for reading excel using Apache POI
	 * 
	 * XSSFWorkbook
	 * XSSFSheet
	 * XSSFRow
	 * XSSFCell
	 * 
	 */
	
	static XSSFWorkbook workbook;
	
	static XSSFSheet workSheet;
	
	static XSSFRow row;
	
	@Test
	public void excel() {
		
		try {
			
			workbook = new XSSFWorkbook(System.getProperty("user.dir")+"\\FileRead_Write\\Excel_Testing.xlsx");
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		workSheet = workbook.getSheetAt(0);
		
		row = workSheet.getRow(0);
		
		XSSFCell cell = row.getCell(0);
		
		System.out.println(cell);
	}
	
	@Test
	public void noOf_Rows_Cell() {
		
		
		int physicalNumberOfRows = workSheet.getPhysicalNumberOfRows();
		
		int physicalNumberOfCells = row.getPhysicalNumberOfCells();
		
		for (int i = 0; i < physicalNumberOfRows; i++) {
			
			for (int j = 0; j < physicalNumberOfCells; j++) {
				
				System.out.print(workSheet.getRow(i).getCell(j).toString()+"     ");
			}
			
			System.out.println();
		}
		
		XSSFSheet createSheet = workbook.createSheet("Second_Sheet");
		
		XSSFRow createRow = createSheet.createRow(0);
		
		createRow.createCell(0).setCellValue("Google.com");
		
		try {
			workbook.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	
}
