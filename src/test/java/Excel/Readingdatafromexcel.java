package Excel;

import java.io.IOException;

public class Readingdatafromexcel {
	
	public static void main(String[] args) throws IOException {
		
		ExcelUtil excel= new ExcelUtil("Sheet1");
		excel.getRowcount();
		excel.getCellData(1, 0);
		excel.getCellData(1, 1);
		excel.getCellData(1, 2);
	}

}
