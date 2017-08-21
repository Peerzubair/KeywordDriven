package sa.keyDriven;



import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public static XSSFWorkbook workbook;
	public static XSSFSheet	sheet;
	
	public static void openExcelRead(String filePath) throws InvalidFormatException, IOException{
		 workbook = new XSSFWorkbook(new File(filePath));
	}
	
	public static void write()
	{
		
	}
	
	public static String read(int rowNum, int colNum )
	{
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		return cell.getStringCellValue() ;
	}
	
	public static void loadSheet(int sheetNum)
	{
		sheet = workbook.getSheetAt(sheetNum);
	}
	
	public static void main(String args[]) throws InvalidFormatException, IOException{
		openExcelRead("C:/Users/Hvuser/Downloads/test.xlsx");
		loadSheet(0);
		System.out.println(read(0,0));
	}
	
	public static void closeWorkbook() throws IOException{
		workbook.close();
	}
	
	public static Object[][] readAll()
	{
		System.out.println("Check");
		Object[][] data = new Object[3][4];
		int k = 0;
		System.out.println("Check2");
		System.out.println(read(0,0));
		data[0][0] = read(1,0);
		data[0][1] = read(1,1);
		data[0][2] = read(1,2);
		data[0][3] = read(1,3);
		data[1][0] = read(2,0);
		data[1][1] = read(2,1);
		data[1][2] = read(2,2);
		data[1][3] = read(2,3);
		data[2][0] = read(3,0);
		data[2][1] = read(3,1);
		data[2][2] = read(3,2);
		data[2][3] = "Peer";
		
//		 for (int rowNum=1 ; rowNum < 4; rowNum++ ){
//		 for(int ColNum=0; ColNum<4; ColNum++){
//			 System.out.println(read(rowNum,ColNum)+' '+rowNum+' '+ColNum);
//			 
//		 }
//		 k++;
//	 }

		System.out.println(data[0][0]);
		System.out.println("Check1");
		return data;
	}
	
}