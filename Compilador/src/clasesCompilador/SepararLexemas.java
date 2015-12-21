package clasesCompilador;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SepararLexemas {
	
	public Object separar(String cadena)
	{
		String espacios="";
		ArrayList<String> cadenaLexema= new ArrayList();
		StringTokenizer st=new StringTokenizer(cadena," ;/=,<>(){}[]+-*/%!&|\n\t\"",true);
		
		while (st.hasMoreTokens())
		{	
			cadenaLexema.add(st.nextToken());
		}
		return cadenaLexema;
	}
}
