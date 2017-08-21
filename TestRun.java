package sa.keyDriven;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestRun {
	String order_no;
	@Test
	void test() throws InvalidFormatException, IOException{
		ExcelOperations.openExcelRead("C:/Users/Hvuser/Downloads/Kdrive.xlsx");
		ExcelOperations.loadSheet(0);
		System.out.println("Excel Data");
        Action.initDriver();		
		for (int i=1; i<24;i++){
			System.out.println(i);
			String cmd = ExcelOperations.sheet.getRow(i).getCell(2).getStringCellValue();
			System.out.println(cmd);
			if (cmd.equals("EnterText"))
			{
				String locatorType = ExcelOperations.sheet.getRow(i).getCell(0).getStringCellValue();
				String locator = ExcelOperations.sheet.getRow(i).getCell(1).getStringCellValue();
				String value = ExcelOperations.sheet.getRow(i).getCell(3).getStringCellValue();
				Action.enterText(locatorType, locator, value);			
				
			}
			if (cmd.equals("Click"))
			{
				String locatorType = ExcelOperations.sheet.getRow(i).getCell(0).getStringCellValue();
				String locator = ExcelOperations.sheet.getRow(i).getCell(1).getStringCellValue();
				Action.click(locatorType, locator);
			}
			if (cmd.equals("Assert"))
			{
				String locator = ExcelOperations.sheet.getRow(i).getCell(1).getStringCellValue();
				String value = ExcelOperations.sheet.getRow(i).getCell(3).getStringCellValue();
				Action.assertVerify(locator,value);
			}
			
			if (cmd.equals("Select"))
			{
				String locator = ExcelOperations.sheet.getRow(i).getCell(1).getStringCellValue();
				String value = ExcelOperations.sheet.getRow(i).getCell(3).getStringCellValue();
				Action.select(locator, value);

			}
			
			if (cmd.equals("Wait")){

				WebDriverWait wait = new WebDriverWait(Action.driver, 10);
				String locator = ExcelOperations.sheet.getRow(i).getCell(1).getStringCellValue();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
				order_no = Action.driver.findElement(By.id(locator)).getAttribute("value");
				System.out.println(order_no);
			}
		}

	}
	
}
