package clasesCompilador;

import java.awt.*;

import javax.swing.JFileChooser;

import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InterfazGrafica extends JFrame implements ActionListener{

	private JLabel lblTitulo, lblDireccion;
	private JTextField txtDireccion;
	private JButton btmAnalizar, btmNuevo;
	private JTextArea areaSalida;
	JPanel panelSalida, panelIngresar, panelBotonModificar;
	
	public InterfazGrafica()
	{
		JPanel panelTitulo=new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		panelTitulo.setBackground(Color.LIGHT_GRAY);
		
		JPanel panelBotones=new JPanel();
		panelBotones.setLayout(new GridLayout(1,3,15,15));
		panelBotones.setBackground(Color.white);
		
		JPanel panelIngresar=new JPanel();
		panelIngresar.setLayout(new FlowLayout());
		panelIngresar.setBackground(Color.white);
		
		txtDireccion = new JTextField(15);
		
		panelSalida=new JPanel();
		panelSalida.setLayout(new FlowLayout());
		panelSalida.setBackground(Color.white);

		areaSalida=new JTextArea();
		areaSalida.setText("Resultados");

		lblTitulo = new JLabel( "Analizador Lexico");
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setToolTipText("ingrese ubicacion del archivo");
		//boton de comandos
		btmAnalizar= new JButton();
		btmAnalizar.setText("Analizar");
		btmAnalizar.setActionCommand("analizar");
		btmAnalizar.addActionListener(this);

		//boton de comandos
		btmNuevo= new JButton();
		btmNuevo.setText("Nuevo");      
		btmNuevo.setActionCommand("nuevo");
		btmNuevo.addActionListener(this);
		
		panelTitulo.add(lblTitulo);
		panelIngresar.add(lblDireccion);
		panelIngresar.add(txtDireccion);
		panelBotones.add(btmAnalizar);
		panelBotones.add(btmNuevo);
		panelSalida.add(areaSalida);
		panelSalida.setVisible(true);
		
		JFrame frame=new JFrame("Analisis Lexico");
      frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
      frame.add(panelTitulo);
      frame.add(panelIngresar);
      frame.add(panelBotones);
      frame.add(panelSalida);
      frame.pack();
      frame.setSize(480, 120);
      frame.setVisible(true);  
      
	} 

	public static void main( String args[] )
	{ 
		InterfazGrafica application = new InterfazGrafica();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public void actionPerformed(ActionEvent e)
	{
		
		String a = e.getActionCommand();
		String cadenaTexto;
		LeerArchivo leer =new LeerArchivo();
		ArrayList<String> lexemasSeparados=new ArrayList();
		SepararLexemas separar=new SepararLexemas();
		boolean analisisLexicoCorrecto=true;
		int contadorLineas=1;
		ArrayList<Integer> lineasError=new ArrayList();
		if(a.equals("analizar"))
		{
			int j=0;
			cadenaTexto=leer.leer(txtDireccion.getText());
			//areaSalida.append(cadenaTexto);
			lexemasSeparados=(ArrayList<String>) separar.separar(cadenaTexto);
			ClasificarLexemas clasifica=new ClasificarLexemas();
			GenerarArchivo nuevo = new GenerarArchivo();
			ArrayList<String> lexem=new ArrayList();
			ArrayList<String> tokenClass=new ArrayList();
			String auxiliar="";
			String operadores[]={"++","--","&&","||",">=","<=","==","!=","//","/*","*/"};
			int m=0;
			for(int i=0;i<lexemasSeparados.size();i++)
			{
				if(!(lexemasSeparados.get(i).equals(" ")||lexemasSeparados.get(i).equals("\t")||lexemasSeparados.get(i).equals("\n")))
				{
					System.out.println("Diferente de vacio");
					lexem.add(lexemasSeparados.get(i));
					auxiliar=lexemasSeparados.get(i);
					
					if(lexemasSeparados.get(i).equals("\""))
					{
						System.out.println("cadenaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
						i++;
						while(!(lexemasSeparados.get(i).equals("\"")))//||!(lexemasSeparados.get(i).equals("\n")))
						{
							System.out.println("Comapracion:"+i);
							auxiliar+=lexemasSeparados.get(i);
							System.out.println(lexemasSeparados.get(i));
							i++;
							System.out.println(auxiliar);
						}
						auxiliar+=lexemasSeparados.get(i);
						lexem.remove(lexem.size()-1);
						lexem.add(auxiliar);
						//tokenClass.add(clasifica.clasificar(auxiliar));
						//i--;
						System.out.println(auxiliar);
					}
					
					else if(lexemasSeparados.get(i).equals("+")||lexemasSeparados.get(i).equals("-")||lexemasSeparados.get(i).equals("&")||lexemasSeparados.get(i).equals("|")||lexemasSeparados.get(i).equals(">")||lexemasSeparados.get(i).equals("<")||lexemasSeparados.get(i).equals("=")||lexemasSeparados.get(i).equals("!")||lexemasSeparados.get(i).equals("/")||lexemasSeparados.get(i).equals("*"))
					{
						auxiliar+=lexemasSeparados.get(i+1);
						System.out.println(auxiliar);
						while((j<operadores.length)&&!(auxiliar.equals(operadores[j])))
						{
							j++;
						}
						
						if(j>=operadores.length)
						{
							//System.out.println("no se encontro");
							auxiliar=lexemasSeparados.get(i);
						}
						
						else
						{
							//System.out.println("se encontro");
							i++;
							lexem.remove(lexem.size()-1);
							lexem.add(auxiliar);
						}
					}
										
					tokenClass.add(clasifica.clasificar(auxiliar));
				//	System.out.println("el token class es:"+tokenClass.get(m));
					j=0;
					//m++;
					if(tokenClass.get(tokenClass.size()-1).equals("error"))
					{
						System.out.println("Errorrrrrrrrrrrrrrr");
						tokenClass.remove(tokenClass.size()-1);
						lexem.remove(lexem.size()-1);
						analisisLexicoCorrecto=false;
						lineasError.add(contadorLineas);
						//tokenClass.remove(m);
						//lexem.remove(i);
						//m--;
						//i--;
					}
				}
				else if(lexemasSeparados.get(i).equals("\n"))
				{
					System.out.println("Nueva lineaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+lexemasSeparados.get(i)+"lo k esssssssssssssssss");
					contadorLineas++;
				}
			}
			
			/*for(int n=0;n<lineasError.size();n++)
			{
				if(lineasError.get(n+1).equals(lineasError.get(n)))
				{
					lineasError.remove(n+1);
				}
			}*/
			for(int n=0;n<lexem.size();n++)
			{
				System.out.println(lexem.get(n)+" "+tokenClass.get(n));
			}
			
			if(analisisLexicoCorrecto==true)
			{
				System.out.println("Analisis lexico correcto");
				nuevo.genera(lexem,tokenClass);
			}
			else
			{
				System.out.println("Errores lexicos");
				for(int n=0;n<lineasError.size();n++)
				{
					System.out.println("Error en la linea:"+lineasError.get(n));
				}
			}
		}
		
		if(a.equals("nuevo"))
		{   
			JFileChooser explorador = new JFileChooser();

			//Le cambiamos el titulo
			explorador.setDialogTitle("Abrir documento...");
			explorador.setFileFilter(new FileNameExtensionFilter("*.TXT", "txt"));
			int seleccion = explorador.showDialog(panelIngresar, "Abrir!");
			  
			//analizamos la respuesta
			switch(seleccion) {
			case JFileChooser.APPROVE_OPTION:
			 //seleccion� abrir
			 break;

			case JFileChooser.CANCEL_OPTION:
			 //dio click en cancelar o cerro la ventana
			 break;

			case JFileChooser.ERROR_OPTION:
			 //llega aqui si sucede un error
			 break;
			}
			
			//Podemos crear un File con lo seleccionado
			File archivo = explorador.getSelectedFile();

			//y guardar una ruta
			String ruta = archivo.getPath();
			txtDireccion.setText(ruta);
			//txtDireccion.setText("");
		}	
		

	}// fin del m�todo actionPerformed

} // FIN CLASE PrimeraInterfase


