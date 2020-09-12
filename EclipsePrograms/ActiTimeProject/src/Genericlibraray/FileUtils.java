package Genericlibraray;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils 
{
	public String getExcelData(String excelPath,String sheeetname,int rownum,int columnnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheeetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(columnnum);
		String un = cell.getStringCellValue();
		book.close();
		return un;
		
	}
	

}
