package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Conexion.Conexion;
import Logica.Consulta;
/**
 * Esta clase nos permitira insertar nuevos datos a las diferentes tablas 
 * @author TOSHIBA
 *
 */
public class Insertar extends JInternalFrame implements ActionListener  {
	/**
	 * Creamos todos los respectivos etiquetas, cajas de texto 
	 * y botones que utilizaremos en nuestra interfaz grafica
	 */
	private JTextField txtregion, txtregion_name;
	private JLabel lblregion, lblregion_name;
	
	private JTextField txtcountry, txtcountry_name, txtCregion_id;
	private JLabel lblcountry, lblcountry_name, lblCregion_id;
	
	private JTextField txtlocation, txtstreet_address,txtpostal_code,txtcity,txtstate_province,txtLcountr_id;
	private JLabel lbllocation, lblstreet_address,lblpostal_code,lblcity,lblstate_province,lblLcountry_id;
	
	private JButton insertarRegion, insertarPais, insertarLocalidad;
	

	private Consulta con;
	private Conexion co;
	
	public void initComponents(){
		
		setTitle(" INSERTAR ");
		setSize(700,500);
		
	}
	/**
	 * Generamos un constructor al cual le pasamos una conexion y el controlodor donde se encuentran todos los metodos a utilizar 
	 * @param con
	 * @param co
	 */
	public Insertar(Consulta con, Conexion co) {
		this.co=co;
		this.con=con;
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtregion = new JTextField(10);
		txtregion_name = new JTextField(10);
		lblregion = new JLabel(" Codigo ");
		lblregion_name = new JLabel(" Nombre ");
		
		txtcountry = new JTextField(10);
		txtcountry_name = new JTextField(10);
		txtCregion_id = new JTextField(10);
		lblcountry = new JLabel(" Codigo ");
		lblcountry_name = new JLabel(" Nombre ");
		lblCregion_id = new JLabel(" Codigo Region");
		
		
		txtlocation = new JTextField(10);
		txtstreet_address = new JTextField(10);
		txtpostal_code = new JTextField(10);
		txtcity = new JTextField(10);
		txtstate_province = new JTextField(10);
		txtLcountr_id = new JTextField(10);
		lbllocation = new JLabel(" Codigo ");
		lblstreet_address = new JLabel(" Street ");
		lblpostal_code = new JLabel(" Postal Code ");
		lblcity = new JLabel(" City ");
		lblstate_province = new JLabel(" Pronvince ");
		lblLcountry_id = new JLabel(" Country ");
		
		
		insertarRegion = new JButton(" Insertar ");
		insertarPais = new JButton(" Insertar ");
		insertarLocalidad = new JButton(" Insertar ");
		
		JPanel pan = new JPanel();
		
		Container cp1 = getContentPane();
		
		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(lblregion, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;
		pan.add(txtregion, cp2);
		
		cp2.gridx = 2;
		cp2.gridy = 0;
		pan.add(lblregion_name, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 0;
		pan.add(txtregion_name, cp2);
		
		cp2.gridx = 4;
		cp2.gridy = 0;
		pan.add(insertarRegion, cp2);
		pan.setBorder(BorderFactory.createTitledBorder(" Insertar Region "));
		cp1.add(pan, BorderLayout.NORTH);
		
		JPanel pan2 = new JPanel();
		
		pan2.setLayout(new GridBagLayout());
		GridBagConstraints cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 0;
		pan2.add(lblcountry, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 0;
		pan2.add(txtcountry, cp3);
		
		cp3.gridx = 2;
		cp3.gridy = 0;
		pan2.add(lblcountry_name, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 3;
		cp3.gridy = 0;
		pan2.add(txtcountry_name, cp3);
		
		cp3.gridx = 4;
		cp3.gridy = 0;
		pan2.add(lblCregion_id, cp3);
		cp3.gridx = 5;
		cp3.gridy = 0;
		pan2.add(txtCregion_id, cp3);
		
		cp3.gridx = 6;
		cp3.gridy = 0;
		pan2.add(insertarPais, cp3);
		
		pan2.setBorder(BorderFactory.createTitledBorder(" Insertar Pais "));
		cp1.add(pan2, BorderLayout.CENTER);
		
		JPanel pan3 = new JPanel();
		pan3.setLayout(new GridBagLayout());
		GridBagConstraints cp4 = new GridBagConstraints();
		cp4.gridx = 0;
		cp4.gridy = 0;
		pan3.add(lbllocation, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 1;
		cp4.gridy = 0;
		pan3.add(txtlocation, cp4);
		cp4.gridx = 2;
		cp4.gridy = 0;
		pan3.add(lblstreet_address, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 3;
		cp4.gridy = 0;
		pan3.add(txtstreet_address, cp4);
		cp4.gridx = 4;
		cp4.gridy = 0;
		pan3.add(lblpostal_code, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 5;
		cp4.gridy = 0;
		pan3.add(txtpostal_code, cp4);
		cp4.gridx = 0;
		cp4.gridy = 1;
		pan3.add(lblcity, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 1;
		cp4.gridy = 1;
		pan3.add(txtcity, cp4);
		cp4.gridx = 2;
		cp4.gridy = 1;
		pan3.add(lblstate_province, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 3;
		cp4.gridy = 1;
		pan3.add(txtstate_province, cp4);
		cp4.gridx = 4;
		cp4.gridy = 1;
		pan3.add(lblLcountry_id, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 5;
		cp4.gridy = 1;
		pan3.add(txtLcountr_id, cp4);
		cp4.gridx = 3;
		cp4.gridy = 2;
		pan3.add(insertarLocalidad, cp4);
		
		pan3.setBorder(BorderFactory.createTitledBorder(" Insertar Localidad "));
		cp1.add(pan3, BorderLayout.SOUTH);
		
		insertarRegion.addActionListener(this);
		insertarRegion.setActionCommand("region");
		
		insertarPais.addActionListener(this);
		insertarPais.setActionCommand("pais");
		
		insertarLocalidad.addActionListener(this);
		insertarLocalidad.setActionCommand("localidad");
		
		
		
			
	}

	/**
	 * Depende a las acciones de los botones, accede a diferentes metodos 
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando = evt.getActionCommand();
		
		switch (comando) {
		case "region":
			insertarRegion();
			break;
		case "pais":
			insertarPais();
			break;
		case "localidad":
			insertarLocalidad();
			break;
		default:
			break;
			
		}
	}

	/**
	 * Metodo que nos permite realizar la inserccion en la tabla de locations
	 * para eso tengo que obtener los datos que se agregaron en las diferentes cajas 
	 * de texto y realizamos una llamada al metodo insertarLocalidad() de la clase Consulta
	 * Despues de relizar la inserccion limpiamos las cajas de texto, para poder realizar 
	 * una nueva inserccion y que non se sobremonten los datos  
	 */
	private void insertarLocalidad() {
		// TODO Auto-generated method stub
		 con.insertarLocalidad(co, Integer.parseInt(txtlocation.getText()), txtstreet_address.getText(), txtpostal_code.getText(), txtcity.getText(),
				 txtstate_province.getText(), txtLcountr_id.getText());
		 JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
		 txtlocation.setText("");
		 txtstreet_address.setText("");
		 txtpostal_code.setText("");
		 txtcity.setText("");
		 txtstate_province.setText("");
		 txtLcountr_id.setText("");
	}

	/**
	 * Metodo nos permite realizar la inserccion en la tabla de countries 
	 * para eso tengo que obtener los datos que se agregaron en las diferentes cajas 
	 * de texto y realizamos una llamada al metodo insertarPais() de la clase Consulta
	 * Despues de relizar la inserccion limpiamos las cajas de texto, para poder realizar 
	 * una nueva inserccion y que non se sobremonten los datos  
	 * 
	 */
	private void insertarPais() {
		// TODO Auto-generated method stub
		con.insertarPais(co, txtcountry.getText(), txtcountry_name.getText(), Integer.parseInt(txtCregion_id.getText()));
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
		txtcountry.setText("");
		txtcountry_name.setText("");
		txtCregion_id.setText("");
	}
	
	/**
	 * Metodo que nos permite realizar la inserccion en la tabla de regions
	 * para eso tengo que obtener los datos que se agregaron en las diferentes cajas 
	 * de texto y realizamos una llamada al metodo insertarRegion() de la clase Consulta
	 * Despues de relizar la inserccion limpiamos las cajas de texto, para poder realizar 
	 * una nueva inserccion y que non se sobremonten los datos  
	 */

	private void insertarRegion() {
		// TODO Auto-generated method stub
				 
			con.insertarRegion(co, Integer.parseInt(txtregion.getText()), txtregion_name.getText());
			JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
			txtregion.setText("");
			txtregion_name.setText("");
	}
	
}
