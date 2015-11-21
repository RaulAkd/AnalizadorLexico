package clasesCompilador;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SepararLexemas {
	
	public Object separar(String cadena)
	{
		int i=0;
		String espacios="";
		ArrayList<String> cadenaLexema= new ArrayList();
		StringTokenizer st=new StringTokenizer(cadena," ;//,<>(){}=",true);
		
		while (st.hasMoreTokens())
		{	
			cadenaLexema.add(st.nextToken());
			//cadenaLexemas.substring(i,i+1)=st.nextToken();
			//System.out.println(cadena.substring(i,i+1));
			//i++;
		}
		for(i=0;i<cadenaLexema.size();i++)
		{
			if(cadenaLexema.equals(" "))
			{
				cadenaLexema.remove(i);
			}
		}
		
		return cadenaLexema;
	}
}
