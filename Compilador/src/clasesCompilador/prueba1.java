package clasesCompilador;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class prueba1 {
	public static void main()
	{
		String outputFile = "test/usuarios_export.csv";
	    boolean alreadyExists = new File(outputFile).exists();
	    File ficheroUsuarios = new File(outputFile);
		//CsvWriter cvsSalida=new CsvWriter(outputFile);
		
		/*if(alreadyExists)
		{
	        File ficheroUsuarios = new File(outputFile);
	        ficheroUsuarios.delete();
	    }*/        
	    System.out.println("Archivo generado"); 
	    try 
	    { 
	        CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
	     
	        csvOutput.write("Codigo");
	        csvOutput.write("Nombres");
	        csvOutput.write("Apellidos");
	        csvOutput.write("Correo");
	        csvOutput.endRecord();
	        csvOutput.close();
	     
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	}
}
