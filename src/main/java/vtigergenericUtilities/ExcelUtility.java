package vtigergenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	// fetchlastrowNum
	public int fetchLastRow(String sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\soundarya\\src\\test\\resources\\e1.xlsx");
		Workbook book =WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
	int lastcell=sh.getLastRowNum();

		return lastcell;
		
	}
	
	
//	
	//fetchdatarowwise()
	public List getdataRowWise(String sheetname,int row,int cell) throws Throwable
	{
List l=new ArrayList();
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\soundarya\\src\\test\\resources\\e1.xlsx");
		Workbook book =WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);	
		DataFormatter df=new DataFormatter();
		int lastrow=fetchLastRow(sheetname);
		for(int i=0;i<lastrow;i++)
		{
		String data=df.formatCellValue(sh.getRow(i).getCell(cell));
	l.add(data);
		}
		return l;
		
	}
	
	
	//writesingledata
public void writeSingleData(String sheetname,int row,int cell,String data) throws Throwable, Throwable
{
FileInputStream fis=new FileInputStream("");
	Workbook book =WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheetname);
	sh.createRow(row).createCell(cell).setCellValue(data);
	FileOutputStream fos=new FileOutputStream("C:\\Users\\admin\\Desktop\\Selenium\\soundarya\\src\\test\\resources\\e1.xlsx");
	fos.write(cell);
	book.close();
}	
	
	

public String fetchSingledata(String sheetname,int row,int cell) throws Throwable {
	FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\soundarya\\src\\test\\resources\\e1.xlsx");
	Workbook book =WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheetname);	
	return sh.getRow(row).getCell(cell).getStringCellValue();
	
	
	
	}
	
	
public Object[][] fetchMultipleData(String sheetname) throws Throwable
{
	
	FileInputStream fis=new FileInputStream("C:\\\\Users\\\\admin\\\\Desktop\\\\Selenium\\\\soundarya\\\\src\\\\test\\\\resources\\\\e1.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheetname);
	int lastRow=sh.getLastRowNum();/// MultipleData
	int lastcell=sh.getRow(0).getLastCellNum();
	Object[][]data=new Object[lastRow][lastcell];
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastcell;j++)
		{
		 data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();		
		}
	}
	
	return data;
	
	
	
	
	
}
	
	
}
