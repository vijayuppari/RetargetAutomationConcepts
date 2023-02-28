package Excel;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	static XSSFWorkbook worksbook;
	static XSSFSheet worksheet;
	
	public ExcelUtil(String sheetname) throws IOException{
	String excelpth= "./Data/TestData.xlsx";
	 worksbook= new XSSFWorkbook(excelpth);
	 worksheet= worksbook.getSheet(sheetname);
	}
		
	public  static void getRowcount() throws IOException{
		int totalrows = worksheet.getPhysicalNumberOfRows();
		System.out.println(totalrows);	
	}
	
	
	public static void getCellData(int row, int column){
		
		DataFormatter dform= new DataFormatter();
		String cellvalue = dform.formatCellValue(worksheet.getRow(row).getCell(column));
		System.out.println(cellvalue);
		
		
	}

}
