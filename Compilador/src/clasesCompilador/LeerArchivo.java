package clasesCompilador;

import java.io.FileReader;
import java.io.BufferedReader;
public class LeerArchivo
{
	public static String leer(String direccion)
	{
		System.out.println("Program leer archivo");
		//Creamos un String que va a contener todo el texto del archivo
		String texto="";
		String texto2="";

		try
		{
			//Creamos un archivo FileReader que obtiene lo que tenga el archivo
			FileReader lector=new FileReader(direccion);

			//El contenido de lector se guarda en un BufferedReader
			BufferedReader contenido=new BufferedReader(lector);

			//Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
			while((texto=contenido.readLine())!=null)
			{
				//texto+=contenido.readLine();
				texto2+=texto+" ";
				//System.out.println("leendo texto");
			}
		}

		//Si se causa un error al leer cae aqui
		catch(Exception e)
		{
			System.out.println("Error al leer");
		}
		return texto2;
	}
}
