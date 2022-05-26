package dataExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArrayList <String> maListe = new ArrayList<String>();
		FileInputStream file = new FileInputStream("/Users/abdi.bileh17/Documents/ExcelData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);	
		
	/**
	 * Ci-dessous, on recupère les données de la 1ere cellule de la 1ere feuille du fichier excel
	 * Cette lecture est en dure, ça peut convenir aux données qui bougent jamais
	 * Mais vaut mieux les variabiliser
	 */
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(1);
		System.out.println(cel);
		System.out.println(sheet.getRow(0).getCell(0));
		
		String cellval = cel.getStringCellValue();
		System.out.println(cellval);
	}

}
