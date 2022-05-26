package dataExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIntro
{

	/**
	 * cette methode renvoie une liste de data de la ligne souhaitée, 
	 * ces données seront utilisées dans des fichier de tests, en faisant appelle à cette classe. 
	 * ATTENTION la variable recherchée dans la colonne doit être variabilisé
	 */
	//------------------------------//
	/**
	 * Il peut être possible de créer un script qui permet d'accéder à n'importe quel fichier excel et, 
	 * lire ses données. Dans ce cas faut tous parametrer ... 
	 */
	
	public ArrayList<String> getData(String str) throws IOException
	{
		
		/**
		 * POI API est une library qui permet de connecter java Test au fichier Excel
		 */
			ArrayList <String> maListe = new ArrayList<String>();
			//File  inFile= new File("/Users/abdi.bileh17/Documents/ExcelData.xlsx");
			FileInputStream file = new FileInputStream("/Users/abdi.bileh17/Documents/ExcelData.xlsx");
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			//tu recupère le nombre de sheet du fichier
			int sheets = workbook.getNumberOfSheets();
			
		/**
		 * Une fois recupéré le nombre de feuille dans le fichier excel, 
		 * on parcours les feuille jusqu'à la feuille voulue
		 */
			for(int i=0; i<sheets;i++)
			{
				if (workbook.getSheetName(i).equalsIgnoreCase("DataDemo"))
				{
					XSSFSheet sheet = workbook.getSheetAt(i);	
					
					//accéder aux lignes de la feuille 
					Iterator<Row> rows = sheet.rowIterator();
					Row firstRow = rows.next(); //Accès à la 1ère ligne de la feuille
					
					Iterator<Cell> cel = firstRow.cellIterator(); //accès aux différentes cellules de la ligne selectionnée
					
					
					//On parcours les différentes cellule de la 1ere ligne 
					//Jusqu'a trouver la cellule qui nous interesse
					int k=0; //cette variable est ... un compteur qui évolue avec litération
					int column=0 ; //determiner la colonne 
					while(cel.hasNext())
					{
						Cell cellule = cel.next();
						
						if(cellule.getStringCellValue().equalsIgnoreCase("TestCases"))
						{
							column =k;
							break;
						}
						k++;
					}
					System.out.println("la colonne desirée sera : "+column);
					
			/**
			 * une fois la colonne identifiée, maintenant on parcours la colonne pour trouver la cellule recherchée
			 */
					
					while(rows.hasNext())
					{
						Row r = rows.next(); //Parcours les différentes ligne de la feuille
						if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Data2"))  //Ici on recupère uniquement la valeur des cellule se trouvant dans la colonne identifiée					
						{
							//ligne = j;
							Iterator<Cell> cv = r.cellIterator();
							while(cv.hasNext())
							{
								//System.out.println(cv.next().getStringCellValue());
								maListe.add(cv.next().getStringCellValue());
							}
						}
					}
					//System.out.println(maListe);
					
				}
			}
			return maListe;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	
	}

}
