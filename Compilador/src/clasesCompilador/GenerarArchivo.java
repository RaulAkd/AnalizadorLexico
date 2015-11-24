package clasesCompilador;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerarArchivo {
	
	public static void genera(ArrayList<String> lexema, ArrayList<String> token) {
		// TODO Auto-generated method stub
		String outputFile = "D:/iso/documento.csv";
	    boolean alreadyExists = new File(outputFile).exists();
		
		if(alreadyExists)
		{
	        File ficheroUsuarios = new File(outputFile);
	        ficheroUsuarios.delete();
	    }        
	    System.out.println("Archivo generado"); 
	    try 
	    { 
	        CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');
	        
	        for(int n=0;n<lexema.size();n++)
			{
	        	csvOutput.write(lexema.get(n));
		        csvOutput.write(token.get(n));
		        csvOutput.endRecord();
			}
	        csvOutput.close();
	     
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }

	}
}
