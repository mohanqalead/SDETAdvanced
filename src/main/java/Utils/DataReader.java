package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	
	public static Object[][] readData(String filePath, String sheetName) throws IOException
	{
		
		
		//File file = new File(filePath);
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount][1];
		
		for(int i = 0; i<rowCount; i++) {
			Map<Object, Object> dataMap = new HashMap<Object, Object>();
			for(int j = 0; j< colcount; j++) {
				dataMap.put(sheet.getRow(0).getCell(j).getRichStringCellValue().toString(), sheet.getRow(i+1).getCell(j).getRichStringCellValue().toString());
			}
			data[i][0] = dataMap;
		}
		
		return data;
		
	}

}
