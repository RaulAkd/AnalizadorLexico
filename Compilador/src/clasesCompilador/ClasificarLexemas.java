package clasesCompilador;

import java.util.ArrayList;

public class ClasificarLexemas {

	String operadoresAritmeticos[]={"+","-","*","/","%","++","--"};
	String operadoresLogicos[]={"!","&&","||"};
	String operadoresRelacionales[]={">",">=","<","<=","==","!="};
	String operadoresPunteros[]={"&","*"};
	String operadoresSecuencia[]={","};
	String agrupadores[]={"{","}","(",")"};
	String otros[]={"[","]"};
	String palabrasReservadas[]={"","","","","","",""};
	
	public String clasificar(String lexema)
	{
		
		
		return "";
	}
	
	public static boolean esIdentificador(String lexema)
	{
		return true;
	}
	
	public static boolean esPalabraResevada(String lexema)
	{
		return true;
	}
	
	public static boolean esUnNumero(String lexema)
	{
		return true;
	}
	
	public static boolean esAgrupador(String lexema)
	{
		return true;
	}
	
	public static boolean esOperador(String lexema)
	{
		return true;
	}
}
