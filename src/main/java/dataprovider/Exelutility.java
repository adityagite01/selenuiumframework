package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exelutility {

	static XSSFWorkbook wb = null;
	public static Object[][] getdata(String sheetname) {
		
		
		File src= new File(System.getProperty("user.dir")+"/testdata/seltest1.xlsx");
		FileInputStream fis = null ;
		
		try {
			 fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			System.out.println("file not found "+e.getMessage());
			
		}
			try {
				 wb= new XSSFWorkbook(fis);
			} catch (IOException e) {
				System.out.println(" could not able to load the file "+e.getMessage());
				
			}
			XSSFSheet sh1=wb.getSheet(sheetname);
			
			int row=wb.getSheet(sheetname).getPhysicalNumberOfRows();
			int col= wb.getSheet(sheetname).getRow(0).getPhysicalNumberOfCells();
			
			Object [][]arr= new Object[row][col];
			
			//for rows
			for (int i=0;i<row;i++) {
				//for column
				for(int j=0;j<col;j++) 
				{
				arr[i][j]=	Exelutility.getcelldata(sheetname, i, j);
				}
			}
			return arr;
	}
	
	// check cell type and return data as string 
public static String getcelldata(String sheetname , int row , int column) {
	
	XSSFCell cell=wb.getSheet(sheetname).getRow(row).getCell(column);
	
	CellType celltype=wb.getSheet(sheetname).getRow(row).getCell(column).getCellType();
	
	String data="";
	if(celltype==CellType.STRING) {
		data=cell.getStringCellValue();
	}
	
	else if(celltype==CellType.BOOLEAN) {
		data=String.valueOf(cell.getBooleanCellValue());
	}
	
	else if(celltype==CellType.NUMERIC) {
		data=String.valueOf(cell.getNumericCellValue());
	}
	else if (celltype==CellType.BLANK) {
		data="";
	}
	return data;
}
	
}