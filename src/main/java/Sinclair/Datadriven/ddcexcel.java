package Sinclair.Datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ddcexcel {

	public List<String> excelmode(String Sheetname, String TCName,String path) throws IOException {
		List<String> list = new ArrayList<String>();
		FileInputStream fil = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fil);
		Iterator<Sheet> ws = wb.sheetIterator();
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			Sheet sheet = ws.next();
			if (sheet.getSheetName().equalsIgnoreCase(Sheetname)) {
				Iterator<Row> row = sheet.iterator();
				Row firstrow = row.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;

					}
					k++;
				}
				
				while (row.hasNext()) {
					Row R = row.next();
					if (R.getCell(column).getStringCellValue().equalsIgnoreCase(TCName)) {
						Iterator<Cell> cv = R.cellIterator();
						
						while (cv.hasNext()) {
							Cell c=cv.next();
							list.add(c.getStringCellValue());
						}
					}
				}
			}
		}
		return list;
	}

}
