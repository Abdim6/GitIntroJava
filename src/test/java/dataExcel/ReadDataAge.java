package dataExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class ReadDataAge {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getDataAge("DataAge");

	}

/**
 * CETTE METHODE - permet de recuperer les données d'une feuille passé en paramètre
 * Ces données peut importe leur types seront recupérer grâce à ce switch case
 */
	public static void getDataAge(String feuille) throws IOException
	{
				
			ArrayList <String> maListe = new ArrayList<String>();
			FileInputStream file = new FileInputStream("/Users/abdi.bileh17/Documents/ExcelData.xlsx");
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			int sheets = workbook.getNumberOfSheets();
			
			for(int i=0; i<sheets;i++)
			{
				if (workbook.getSheetName(i).equalsIgnoreCase(feuille))
				{
					XSSFSheet sheet = workbook.getSheetAt(i);	
					//FormulaEvaluator formule = workbook.getCreationHelper().createFormulaEvaluator();
					
					for (Row row :sheet)   //Toutes les lignes de la feuille 
					{
						for (Cell cell : row)   // Puis toutes les colonnes de lignes - étape par étape
						{
							switch (cell.getCellType())
							{
								case NUMERIC:
									System.out.print(cell.getNumericCellValue()+"\t\t");
									break;
								case STRING:
									System.out.print(cell.getStringCellValue()+"\t\t");
									break;
								
							}
						}
						System.out.println();
					}
					
				}
			}
	}
}
