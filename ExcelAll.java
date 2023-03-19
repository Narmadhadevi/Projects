package week7.day1w7;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAll {
	public static String[][] excelAll(String filename,int sheetNo) throws IOException {
		XSSFWorkbook book=new XSSFWorkbook("./datasexcel/"+filename+".xlsx");
		XSSFSheet sheet = book.getSheetAt(sheetNo);
		 XSSFRow row = sheet.getRow(0); 
		 //XSSFCell cell = row.getCell(0);
		int rowCount = sheet.getLastRowNum();
		int cellCount = row.getLastCellNum();
		String[][] data=new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(value);
				data[i-1][j]=value;
			}
		}
		book.close();
		return data;
	}

}
