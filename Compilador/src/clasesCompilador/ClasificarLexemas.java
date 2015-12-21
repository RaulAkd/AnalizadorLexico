package clasesCompilador;

import java.util.ArrayList;

public class ClasificarLexemas {

	static String operadoresAritmeticos[]={"+","-","*","/","%","++","--"};
	static String operadoresLogicos[]={"!","&&","||"};
	static String operadoresRelacionales[]={">",">=","<","<=","==","!="};
	static String operadoresPunteros[]={"&","*"};
	static String operadoresSecuencia[]={",",";","<<",">>"};
	static String agrupadores[]={"{","}","(",")"};
	static String otros[]={"[","]"};
	static String operadorAsignacion[]={"="};
	static String palabrasReservadas[]={"#include","asm","auto","bool","break","case","catch","char","class","cin","cout","const","const_cast","continue","default","delete","do","double","dynamic_cast","else","enum","endl","explicit","extern","false","float","for","friend","goto","getch","if","inline","int","iostream","long","main","mutable","namespace","new","operator","private","protected","public","register","reinterpret_cast","return","short","signed","sizeof","static","static_cast","struct","switch","template","this","throw","true","try","typedef","typeid","typename","union","unsigned","using","virtual","void","volatile","while"};
	
	
	public String clasificar(String lexema)
	{	
		if(esOperadorAritmetico(lexema)==true)
		{
			if(lexema.equalsIgnoreCase("++")||lexema.equalsIgnoreCase("--"))
			{
				return "operadorAritmeticoUnario";
			}
			else
			{
				return "operadorAritmetico";
			}
		}
		else if(esOperadorAsignacion(lexema)==true)
		{
			System.out.println("Si es igual");
			return "operadorAsignacion";
		}
		
		else if(esPalabraReservada(lexema)==true)
		{
			if(lexema.equals("void")||lexema.equals("char")||lexema.equals("int")||lexema.equals("short")||lexema.equals("long")||lexema.equals("float")||lexema.equals("double"))
			{
				return "tipoDeDato";
			}
			else if(lexema.equals("if")||lexema.equals("else")||lexema.equals("else if")||lexema.equals("swtich")||lexema.equals("for")||lexema.equals("while")||lexema.equals("do"))
			{
				return "estructuraDeControl";
			}
			else
			{
				return "palabraReservada";
			}
		}
		
		else if(esIdentificador(lexema)==true)
		{
			return "identificador";
		}
		
		else if(esUnNumero(lexema)==true)
		{
			return "numero";
		}
		
		else if(esAgrupador(lexema)==true)
		{
			return "agrupador";
		}
		
		else if(esOperadorSecuencia(lexema)==true)
		{
			return "operadorSecuencia";
		}

		else if(esOperadorLogico(lexema)==true)
		{
			return "operadorLogico";
		}
		
		else if(esOperadorRelacional(lexema)==true)
		{
			return "operadorRelacional";
		}
		
		else if(esOperadorPuntero(lexema)==true)
		{
			return "operadorPuntero";
		}
		
		else if(esCadena(lexema)==true)
		{
			return "String";
		}
		
		
	/*	else if(esOperadorMatriz(lexema)==true)
		{
			return "operadorMatriz";
		}
		*/
		else
		{
			return "error";
		}
	}
	
	public static boolean esOperadorAritmetico(String lexema)
	{
		int contador=0;
		while((contador<operadoresAritmeticos.length)&&!(lexema.equals(operadoresAritmeticos[contador])))
		{
			contador++;
		}
		if(contador<operadoresAritmeticos.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean esOperadorAsignacion(String lexema)
	{
		int contador=0;
		while((contador<operadorAsignacion.length)&&!(lexema.equals(operadorAsignacion[contador])))
		{
			contador++;
		}
		if(contador<operadorAsignacion.length)
		{
			//System.out.println("Ingresoo a =");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean esPalabraReservada(String lexema)
	{
		int contador=0;
		System.out.println("entro palab res");
		while((contador<palabrasReservadas.length)&&!(lexema.equals(palabrasReservadas[contador])))
		{
			contador++;
		}
		if(contador<palabrasReservadas.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean esIdentificador(String lexema)
	{
		boolean ok=lexema.matches("[a-z|A-Z]\\w.+");
		if(ok==true)
		{
			return true;
			//System.out.println("Correctoooooo");
		}
		else
		{
			return false;
			//System.out.println("Errorrrrrrrrr");
		}
	}
	
	public static boolean esUnNumero(String lexema)
	{
		boolean ok=lexema.matches("[0-9]*");
		return ok;
	}
	
	public static boolean esAgrupador(String lexema)
	{
		int contador=0;
		while((contador<agrupadores.length)&&!(lexema.equals(agrupadores[contador])))
		{
			contador++;
		}
		if(contador<agrupadores.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean esOperadorSecuencia(String lexema)
	{
		int contador=0;
		while((contador<operadoresSecuencia.length)&&!(lexema.equals(operadoresSecuencia[contador])))
		{
			contador++;
		}
		if(contador<operadoresSecuencia.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean esOperadorLogico(String lexema)
	{
		int contador=0;
		while((contador<operadoresLogicos.length)&&!(lexema.equals(operadoresLogicos[contador])))
		{
			contador++;
		}
		if(contador<operadoresLogicos.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean esOperadorRelacional(String lexema)
	{
		int contador=0;
		while((contador<operadoresRelacionales.length)&&!(lexema.equals(operadoresRelacionales[contador])))
		{
			contador++;
		}
		if(contador<operadoresRelacionales.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean esOperadorPuntero(String lexema)
	{
		int contador=0;
		while((contador<operadoresPunteros.length)&&!(lexema.equals(operadoresPunteros[contador])))
		{
			contador++;
		}
		if(contador<operadoresPunteros.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean esCadena(String lexema)
	{
		System.out.println("Analizar cadeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeena");
		if(lexema.substring(0, 1).equals("\"")&&lexema.substring(lexema.length()-1,lexema.length() ).equals("\""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/*public static boolean esOperadorMatriz(String lexema)
	{
		int contador=0;
		while((contador<otros.length)&&!(lexema.equals(otros[contador])))
		{
			contador++;
		}
		if(contador<otros.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}*/	
}
