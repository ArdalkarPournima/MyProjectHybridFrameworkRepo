package qa.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
public class Utilities {

	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int WAIT_TIME=10;
	
	public static String generateEmailTimeStamp()
	{
		Date date= new Date();
		String timestamp= date.toString().replace(" ","_").replace(":", "_");	
		return "pournima"+timestamp+"@gmail.com";
		
	}
	
	//get data from ExcelSheet
	public static Object[][] GetDataFromExcel(String SheetName)
	{ 
		
		//Excel File reference
		File excelFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\Testdata\\LoginTestdata.xlsx");		
		XSSFWorkbook workbook = null;

		try {
		FileInputStream fisExcel = new FileInputStream(excelFile);
		workbook=new XSSFWorkbook(fisExcel);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(SheetName);
		
		//find no. of rows & cols
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		//two dimensional object array - when called GetDataFromExcel() then it will return 2-dimensional array
		Object[][] data = new Object[rows][cols];
		
		for(int i=0;i<rows;i++)
		{
			XSSFRow row =sheet.getRow(i+1); //i+1 because to skip Sr. no. col from excel
			
			for(int j=0;j<cols;j++)
			{
				XSSFCell cell = row.getCell(j);
				//to find the type of cell -ex: Email is string type, pass could be integer type
				CellType cellType = cell.getCellType();			
				
				switch(cellType) 
				{
				
				//retrieve data from Excel and assign it to two-dimensional Array.
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j] =Integer.toString((int) cell.getNumericCellValue());  //getNumericCellValue() will return in the form of 12345.00,12345.10 etc. so we typeCast into (int)
					break;																//before passing data to 2-dimensional-array, we've to convert it to String so used,Integer.toString() 			
				
				case BOOLEAN:
					
					data[i][j] = cell.getBooleanCellValue();
					break;
				
												
				}
				
			}
				
		}
		
		return data;
		
	}
	public static String captureScreenshot(WebDriver driver,String testName)
	{
		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshot = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot, new File(destinationScreenshot));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationScreenshot;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
