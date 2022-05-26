package dataExcel;
/**
 * Note Importante
 * Il est possible de créer une classe dataXsl dans laquelle, on crée plusieurs méthodes
 * pour lire, modifier ou créer un nouveau fichier excel de données.
 * Il suffira juste d'appeler la classe (pk pas en static) pour utiliser ses methodes 
 * A VERIFIER EN PRATIQUE
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreatNewWorkbook {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		XSSFWorkbook workbook = new XSSFWorkbook();
		//ATTENTION : ici c'est du "output" 
		OutputStream file = new FileOutputStream(new File("src/creatNewWorkbook.xlsx"));
		
		//Ecrire une opperation dans le new workbook
		workbook.write(file);
		file.close();
		System.out.println("La création du workbook s'est bien passé");
	}

}
