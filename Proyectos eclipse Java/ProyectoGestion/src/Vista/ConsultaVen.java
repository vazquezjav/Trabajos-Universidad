
package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Conexion.Conexion;
import Logica.Consulta;
/** 
 * Esta clase genra la interfaz grafica la cual nos
 * permite realizar las consultas a las tablas de regions, countries y locations
 * @author TOSHIBA
 *
 */
public class ConsultaVen  extends JInternalFrame  implements ActionListener{

	private JTextField txtregion;
	private JTextField txtpais;
	private JTextField txtlocalidad;
	private JLabel codigoRegion;
	private JLabel codigoPais;
	private JLabel codigoLocalidad;
	private JButton consultarRegion;
	private JButton consultarPais;
	private JButton consultarLocalidad;
	private Consulta con;
	private Conexion co;
	

	public void initComponents(){
		
		setTitle("Regiones");
		setSize(500,500);
		
	}
	/**
	 * Generamos un constructor al cual le pasamos una conexion y el controlodor donde se encuentran todos los metodos a utilizar 
	 * @param con
	 * @param co
	 */
	public  ConsultaVen(Consulta con, Conexion co) {
		 this.co=co;
		// TODO Auto-generated constructor stub
		this.con=con;
		initComponents();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txtregion= new JTextField(10);
		codigoRegion = new JLabel(" Codigo Region ");
		consultarRegion = new JButton(" Consultar"	);
		
		txtpais =  new JTextField(10);
		codigoPais = new JLabel(" Codigo Pais");
		consultarPais = new JButton("Consultar");
		
		txtlocalidad = new JTextField(10);
		codigoLocalidad = new JLabel("Codigo Localidad");
		consultarLocalidad = new JButton("Consultar ");
		
		 JPanel pan = new JPanel();

			Container cp1 = getContentPane();
			

			pan.setLayout(new GridBagLayout());
			GridBagConstraints cp2 = new GridBagConstraints();
			cp2.gridx = 0;
			cp2.gridy = 0;
			pan.add(codigoRegion, cp2);
			cp2 = new GridBagConstraints();
			cp2.gridx = 2;
			cp2.gridy = 0;
			pan.add(txtregion, cp2);

			cp2 = new GridBagConstraints();
			cp2.gridx = 3;
			cp2.gridy = 0;
			pan.add(consultarRegion, cp2);
			


			cp2.gridx = 0;
			cp2.gridy = 3;
			pan.add(codigoPais, cp2);
			cp2 = new GridBagConstraints();
			cp2.gridx = 2;
			cp2.gridy = 3;
			pan.add(txtpais, cp2);

			cp2 = new GridBagConstraints();
			cp2.gridx = 3;
			cp2.gridy = 3;
			pan.add(consultarPais, cp2);
			
			
			cp2.gridx = 0;
			cp2.gridy = 4;
			pan.add(codigoLocalidad, cp2);
			cp2 = new GridBagConstraints();
			cp2.gridx = 2;
			cp2.gridy = 4;
			pan.add(txtlocalidad, cp2);

			cp2 = new GridBagConstraints();
			cp2.gridx = 3;
			cp2.gridy = 4;
			pan.add(consultarLocalidad, cp2);
			
			
			
			cp1.add(pan, BorderLayout.CENTER);
			
			consultarRegion.addActionListener(this);
			consultarRegion.setActionCommand("consulta");
			
			consultarPais.addActionListener(this);
			consultarPais.setActionCommand("consultaPais");
			
			consultarLocalidad.addActionListener(this);
			consultarLocalidad.setActionCommand("consultaLocalidad");
		
	}
	/**
	 * Depende a las acciones de los botones, accede a diferentes metodos 
	 */
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		String comando= evt.getActionCommand();
		switch(comando){
		case "consulta":
			consultar();
			break;
		case "consultaPais":
			consultarPais();
			break;
		case "consultaLocalidad":
			consultarLocalidad();
			break;
		}
	}
	
	/**
	 * Consulta a la tabla de regions, mismo metodo que realiza una llamada 
	 * a la clase TablaRegion la que nos mostrara los resultados de nuestra consulta
	 * en tablas 
	 */
	public void consultar() {
		con.ConsultarRegion(co, txtregion.getText());
		TablaRegion tr= new TablaRegion(con, co);
		tr.setVisible(true);
	}
	/**
	 * Consulta a la tabla de countries, el metodo realiza una llamada
	 * a la clase TablaPais la que nos mostrara los resultados de nuestra consulta
	 * en tablas  
	 */
	public void consultarPais() {
		con.ConsultarPaises(co, txtpais.getText());
		TablaPais  tp= new TablaPais(con, co);
		tp.setVisible(true);
		
	}
	/**
	 * Consulta a la tabla de locations, el metodo realiza una llamada
	 * a la clase TablaLocalidad la que nos mostrara los resultados de nuestra consulta
	 * en tablas
	 */
	public void consultarLocalidad() {
		con.ConsultarLacalidades(co, txtlocalidad.getText());
		TablaLocalidad tl= new TablaLocalidad(con, co);
		tl.setVisible(true);
	}
	
	

}