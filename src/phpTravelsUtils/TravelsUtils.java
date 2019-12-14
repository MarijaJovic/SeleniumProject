package phpTravelsUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TravelsUtils {
	
	private XSSFWorkbook wb = null;
	private XSSFSheet sheet = null;
	private String excellFileLocation;

	public boolean setExcell(String path) 
	{
		if (wb != null) 
		{
			try 
			{
				wb.close();
			} 
			
			catch (Exception e) 
			{
				System.out.println(e.toString());
				return false;
			}
		}
		
		File f = new File(path);
		
		try 
		{
			FileInputStream fis = new FileInputStream(f);

			wb = new XSSFWorkbook(fis);
			excellFileLocation = path;
			return true;
		} 
		
		catch (Exception e) 
		{
			System.out.println(e.toString());
			System.out.println("Fajl nije uspešno otvoren!");
			return false;
		}
	}

	public boolean setWorkSheet(int index) 
	{
		try 
		{
			sheet = wb.getSheetAt(index);
			return true;
		} 
		
		catch (Exception e) 
		{
			System.out.println(e.toString());
			System.out.println("Worksheet nije uspešno otvoren!");
			return false;
		}
	}

	public String getDataAt(int row, int column) 
	{
		
		try 
		{
			XSSFRow r = sheet.getRow(row);
			XSSFCell celija = r.getCell(column);
			return celija.toString();
		} 
		
		catch (NullPointerException e) 
		{
			System.out.println(e.toString());
			System.out.println("Došlo je do null greške!");
		} 
		
		catch (Exception e) 
		{
			System.out.println(e.toString());
			System.out.println("Došlo je do neke greške!");
		}
		return "";
	}

	public boolean setDataAt(int row, int column, String data) 
	{
		try {
			XSSFRow r = sheet.getRow(row);
			if (r == null) {
				r = sheet.createRow(row);
			}
			
			XSSFCell celija = r.getCell(column);
			
			if (celija == null) 
			{
				celija = r.createCell(column);
			}
			
			celija.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(excellFileLocation);
			wb.write(fos);
			return true;
		} 
		
		catch (Exception e) 
		{
			System.out.println(e.toString());
			System.out.println("Došlo je do neke greške!");
			return false;
		}
	}

	public int getRowNumber() 
	{
		try 
		{
			return sheet.getLastRowNum() + 1;
		} 
		
		catch (Exception e) 
		{
			System.out.println(e.toString());
			System.out.println("Došlo je do neke greške!");
			return -1;
		}
	}

	public boolean closeExcell() 
	{
		if (wb != null) 
		{
			try 
			{
				wb.close();
				wb = null;
				return true;
			} 
			
			catch (IOException e) 
			{
				e.printStackTrace();
				wb = null;
				return false;
			}

		}
		return true;
	}

}
