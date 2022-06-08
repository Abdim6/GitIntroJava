package dataExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class WriteData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getDataAge("WriteData");

	}

/**
 * CETTE METHODE - permet d'ecrire des données dans un fichier excel 
 * Create a workbook
 * Create a sheet in workbook
 * Create a row in sheet
 * Add cells in sheet
 * Repeat step 3 and 4 to write more data
 */
/**
 * cette classe ajoutera une ligne de données dans une feuille deja existante
 * la ligne sera ajouté juste après la dernière ligne de la feuille 
 * 
 * A AJOUTER : fait en sorte que cette classe soit générique pour tout ajout de donnée dans un fichier 
 * OU 
 * crée plusieurs methodes similaire avec des paramètres ddifférents, d'un cas une liste des données et parfois des simple nombre ou objets
 * 
 * @param feuille
 * @throws IOException
 */
	public static void getDataAge(String feuille) throws IOException
	{
			
			ArrayList <String> maListe = new ArrayList<String>();
			FileInputStream file = new FileInputStream("/Users/abdi.bileh17/Documents/ExcelData.xlsx");
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			//Create a blank sheet
	        //XSSFSheet sheet = workbook.createSheet("Feuil3");
	        
			//Read a sheet
	        XSSFSheet sheet2 = workbook.getSheet("Feuil3");
	        
			//Open a sheet
	        //XSSFSheet sheet = workbook.getSheet("Feuil1");
	        

		   int nbRow = sheet2.getLastRowNum(); 	        
	       Row row = sheet2.createRow(nbRow+1);	          	        
	       maListe.add("A");        	        
	       maListe.add("B");        	        
	       maListe.add("C");        	        
	       maListe.add("D");        	        
	       maListe.add("E");        	        
	       maListe.add("F"); 
	       
	        for(int i=0; i<maListe.size();i++)
	        {
	        	Cell cell = row.createCell(i);
	        	cell.setCellValue(maListe.get(i));
	        	System.out.println("Done");
				
	 	       try
	 	        {
	 	            //Write the workbook in file system
	 	            FileOutputStream out = new FileOutputStream(new File("/Users/abdi.bileh17/Documents/ExcelData.xlsx"));
	 	            workbook.write(out);
	 	            out.close();
	 	            System.out.println("----- howtodoinjava_demo.xlsx written successfully on disk. -----");
	 	        } 
	 	        catch (Exception e) 
	 	        {
	 	            e.printStackTrace();
	 	        }
	        
	        }		
	        
	        
	        
//Ceci est un exemple pris sur un site 
	       /*	
		//Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee_Data");
          
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
        data.put("2", new Object[] {1, "Amit", "Shukla"});
        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
        data.put("4", new Object[] {3, "John", "Adwards"});
        data.put("5", new Object[] {4, "Brian", "Schultz"});
          
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("/Users/abdi.bileh17/Documents/ExcelData.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("----- howtodoinjava_demo.xlsx written successfully on disk. -----");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }*/
    }
	
}
