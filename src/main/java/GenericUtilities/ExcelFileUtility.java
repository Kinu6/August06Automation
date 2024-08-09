package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String readDataFromExcelFile(String sheet, int row, int cell) throws EncryptedDocumentException, IOException{
		FileInputStream fisE= new FileInputStream(IConstantUtility.excel);
		Workbook wb = WorkbookFactory.create(fisE);
		Sheet sh = wb.getSheet(sheet);
		Row rw= sh.getRow(row);
		Cell ce= rw.getCell(cell);
		String value= ce.toString();
		wb.close();
		return value;
	}
	
	public void writeDataIntoExcelFile(String sheet, int row, int cell, String value1) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new  FileInputStream(IConstantUtility.excel);
		Workbook wb= WorkbookFactory.create(fis);
		 Sheet sh=wb.getSheet(sheet);
		 sh.getRow(row).getCell(cell).setCellValue(value1);
		 FileOutputStream fos= new FileOutputStream(IConstantUtility.excel);
		 wb.write(fos);
		 wb.close();	
	}
	
	//***************************************************************************************************//
	public Object[][] readDataFromExcelToDataProvider(String SheetName) throws EncryptedDocumentException, IOException{
		FileInputStream fis= new FileInputStream(IConstantUtility.excel);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(SheetName);
		int lastRow= sh.getPhysicalNumberOfRows();
		System.out.println(lastRow);
		int lastCell= sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println(lastCell);
		
		Object[][] data= new Object[lastRow-1][lastCell];
		for(int i=1;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		wb.close();	
		return data;
	}
	
}
