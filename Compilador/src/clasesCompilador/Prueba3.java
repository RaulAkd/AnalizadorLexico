package clasesCompilador;
import java.util.ArrayList;
import java.util.Scanner;

public class Prueba3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena, cadena1;
		ArrayList<String> lexemasSeparados=new ArrayList();
		SepararLexemas separar=new SepararLexemas();
		cadena=ingresoTeclado("Ingrese cadena");
		lexemasSeparados=(ArrayList<String>) separar.separar(cadena);
		//cadena1=separar.separar(cadena);
		for(int i=0;i<lexemasSeparados.size();i++)
		{
			System.out.println(lexemasSeparados.get(i));
		}
	}

	public static String ingresoTeclado(String mensaje)
	{
		Scanner in = new Scanner(System.in);
		System.out.println(mensaje);
		return in.nextLine();
	}
}
