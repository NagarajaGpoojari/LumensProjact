package com.Lumens.ExcelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ReadExcelFile {

		public ArrayList<String> getData(String TestCaseName) throws IOException {
			
			ArrayList<String> data = new ArrayList<String>();
			//initializing the Excel to fetch the data from Excel data 
			FileInputStream file = new FileInputStream("D:\\Automation\\InputData.xlsx");
			// initializing workbook
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			int sheetsCount = workbook.getNumberOfSheets();
			// using for loop to count the no of colums in Sheet
			for (int i = 0; i < sheetsCount; i++) {
				if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
					//iinitializing the Sheet Name and fetching the data 
					XSSFSheet sheet = workbook.getSheetAt(i);
					
					//Identify the testcase coloum by scanning the entire 1st row
					
					Iterator<Row> rows=sheet.iterator();// sheet is collection of rows
					
					while(rows.hasNext()) {
						Row firstRow=rows.next();
						//To read the data from the current row
						
						Iterator<Cell> cell=firstRow.cellIterator();
						// Row is collection of cell
						int k=0;
						int coloumn=0;
						while(cell.hasNext()) {
							Cell value=cell.next();
							//initializing the current Row to read the data 
							if(value.getStringCellValue().equalsIgnoreCase("Users")) {
								
								coloumn=k;	
							}
							//increamenting the column
							k++;
						}
						System.out.println("Coloumn is "+coloumn);
						
						//once the couloumn is identified then scan the entire Users coloumn to identify the user1 row
						while(rows.hasNext()) {
							Row row2=rows.next();
							if(row2.getCell(coloumn).getStringCellValue().equalsIgnoreCase(TestCaseName)) {
								
								//once reached particular row= pull the all the data of the row and feed into test
								Iterator<Cell> celldata=row2.cellIterator();
								while(celldata.hasNext()) {
									Cell c=celldata.next();
									 if(c.getCellTypeEnum()==CellType.STRING) {
										 data.add(c.getStringCellValue());
									 }else {
										 data.add(NumberToTextConverter.toText(c.getNumericCellValue()));
									 }
								}
							}
						}
					}
				}

			}
			return data;
		}

		
	}
