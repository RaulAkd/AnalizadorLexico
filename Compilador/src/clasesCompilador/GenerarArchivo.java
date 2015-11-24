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
		int cont=1;
		String outputFile = "D:/iso/documento.csv";
	    boolean alreadyExists = new File(outputFile).exists();
	    //File ficheroUsuarios = new File(outputFile);
		//CsvWriter cvsSalida=new CsvWriter(outputFile);
		
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
	     
	        /*csvOutput.write("Codigo");
	        csvOutput.write("Nombres");
	        csvOutput.write("Apellidos");
	        csvOutput.write("Correo");
	        csvOutput.write("Silvyy");
	        csvOutput.endRecord();*/
	        csvOutput.close();
	     
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }

	}
}
