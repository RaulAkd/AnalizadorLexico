package clasesCompilador;
import java.util.ArrayList;
import java.util.Scanner;

public class Prueba3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena, cadena1, direccion, cadenaTexto, identificador;
		ArrayList<String> lexemasSeparados=new ArrayList();
		SepararLexemas separar=new SepararLexemas();
		LeerArchivo leer =new LeerArchivo();
		boolean ok=false;
		/*cadena=ingresoTeclado("Ingrese cadena");
		lexemasSeparados=(ArrayList<String>) separar.separar(cadena);
		//cadena1=separar.separar(cadena);
		for(int i=0;i<lexemasSeparados.size();i++)
		{
			System.out.println(lexemasSeparados.get(i));
		}*/
		//direccion=ingresoTeclado("Ingrese la direccion del archivo");
		//cadenaTexto=leer.leer(direccion);
		//System.out.println("Esta es la cadena de texto:"+cadenaTexto);
		identificador=ingresoTeclado("ingrese identificador");
		//ok=identificador.matches("[a-z|A-Z].*[a-z|A-z|0-9].+\\S+[^-]+");
		ok=identificador.matches("[a-z]\\w+");
		//boolean mal =identificador.matches("\d|\.")
		if(ok==true)
		{
			System.out.println("Correctoooooo");
		}
		else
		{
			System.out.println("Errorrrrrrrrr");
		}
		
		/*ok=identificador.matches("[0-9].*");
		if(ok==true)
		{
			System.out.println("Correctoooooo");
		}
		else
		{
			System.out.println("Errorrrrrrrrr");
		}*/
	}

	public static String ingresoTeclado(String mensaje)
	{
		Scanner in = new Scanner(System.in);
		System.out.println(mensaje);
		return in.nextLine();
	}
}
