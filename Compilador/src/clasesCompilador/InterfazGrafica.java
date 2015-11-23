package clasesCompilador;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class InterfazGrafica extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private JLabel lblTitulo, lblDireccion;
	private JTextField txtDireccion;
	private JButton btmAnalizar, btmNuevo;
	private JTextArea areaSalida;
	JPanel panelSalida, panelIngresar, panelBotonModificar;
	//ArbolB<String, String> st = new ArbolB<String, String>();
	
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
		//panelSalida.setSize(480, 340);
		//areaSalida.setSize(480, 240);
		
		JFrame frame=new JFrame("Analisis Lexico");
      frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
      frame.add(panelTitulo);
      frame.add(panelIngresar);
      frame.add(panelBotones);
      frame.add(panelSalida);
      frame.pack();
      frame.setSize(480, 120);
      frame.setVisible(true);  
      
	} // FIN constructor PrimeraInterfase

	// programa principal para poder ejecutar como aplicación java
	public static void main( String args[] )
	{ 
		InterfazGrafica application = new InterfazGrafica();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}


	// método que escucha los eventos que suceden en la GUI
	public void actionPerformed(ActionEvent e)
	{
		
		String a = e.getActionCommand();
		String cadenaTexto;
		LeerArchivo leer =new LeerArchivo();
		ArrayList<String> lexemasSeparados=new ArrayList();
		SepararLexemas separar=new SepararLexemas();
		
		if(a.equals("analizar"))
		{
			cadenaTexto=leer.leer(txtDireccion.getText());
			areaSalida.append(cadenaTexto);
			lexemasSeparados=(ArrayList<String>) separar.separar(cadenaTexto);
			ClasificarLexemas clasifica=new ClasificarLexemas();
			Lexema lexemas =new Lexema();
			ArrayList<Lexema> lex=new ArrayList();
			//areaSalida.append("\nCadenas separadas\n");
			for(int i=0;i<lexemasSeparados.size();i++)
			{
				//lexemaIdentificado.setLexema(lexema);
				if(!(lexemasSeparados.get(i).equals(" ")))
				{
					lexemas.setLexema(lexemasSeparados.get(i));
					lexemas.setTokenClass(clasifica.clasificar(lexemasSeparados.get(i)));
					lex.add(lexemas);
				}
				System.out.println(lexemasSeparados.get(i));
			}
		}
		
		if(a.equals("nuevo"))
		{   
			
		}	
		

	}// fin del método actionPerformed

} // FIN CLASE PrimeraInterfase


