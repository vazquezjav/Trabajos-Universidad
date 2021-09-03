package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Conexion.Conexion;
import Logica.Consulta;
import Logica.Localidad;
/*
 * Esta clasecreara la interfaz grafica que nos permitira actualizar los datos 
 * de la tabla de locations
 * Esta interfaz lo que primero realiza es buscar las datos del codigo respecto
 * al codigo ingresado por el usuario, despues estos datos se muestran en pantalla 
 * pudiendo asi observar todos sus datos y poder asi realizar los cambios 
 * necesarios 
 */
public class Actualizar extends JInternalFrame  implements ActionListener {


	private JTextField txtlocalidad;
	private JTextField street,province,city,postal,country;
	private JLabel codigoLocalidad,calle,provincia,copostal,ciudad,pais;
	private JButton consultarLocalidad,actualizar;
	private Consulta con;
	private Conexion co;
	
	public void initComponents(){

		setTitle("Actualizar");
		setSize(800,500);

	}
	public Actualizar(Consulta con, Conexion co) {
		// TODO Auto-generated constructor stub
		this.co=co;
		this.con=con;
initComponents();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtlocalidad = new JTextField(10);
		street = new JTextField(10);
		province = new JTextField(10);
		city= new JTextField(10);
		postal = new JTextField(10);
		country= new JTextField(10);
				
		codigoLocalidad = new JLabel("Codigo Localidad");
		calle = new JLabel("Street");
		provincia = new JLabel("Province");
		copostal= new JLabel("Postal");
		ciudad= new JLabel("City");
		pais= new JLabel("Country");
		
		consultarLocalidad = new JButton(" Buscar  ");
		actualizar = new JButton("Actualizar");
		
		 JPanel pan = new JPanel();

			Container cp1 = getContentPane();
			pan.setLayout(new GridBagLayout());
			GridBagConstraints cp2 = new GridBagConstraints();

			cp2.gridx = 0;
			cp2.gridy = 0;
			pan.add(codigoLocalidad, cp2);
			cp2 = new GridBagConstraints();
			cp2.gridx = 1;
			cp2.gridy = 0;
			pan.add(txtlocalidad, cp2);

			cp2 = new GridBagConstraints();
			cp2.gridx = 2;
			cp2.gridy = 0;
			pan.add(consultarLocalidad, cp2);
			
			
			 JPanel pan2 = new JPanel();

			 pan2.setLayout(new GridBagLayout());
			 GridBagConstraints cp3 = new GridBagConstraints();
			 cp3.gridx = 0;
			 cp3.gridy = 0;
			 pan2.add(calle, cp3);
			 cp3 = new GridBagConstraints();
			 cp3.gridx = 1;
			 cp3.gridy = 0;
			 pan2.add(street, cp3);

			 cp3 = new GridBagConstraints();
			 cp3.gridx = 2;
			 cp3.gridy = 0;
			 pan2.add(copostal, cp3);
			 
			 cp3 = new GridBagConstraints();
			 cp3.gridx = 3;
			 cp3.gridy = 0;
			 pan2.add(postal, cp3);

			 cp3 = new GridBagConstraints();
			 cp3.gridx = 0;
			 cp3.gridy = 1;
			 pan2.add(ciudad, cp3);
			 
			 cp3 = new GridBagConstraints();
			 cp3.gridx = 1;
			 cp3.gridy = 1;
			 pan2.add(city, cp3);

			 cp3 = new GridBagConstraints();
			 cp3.gridx = 2;
			 cp3.gridy = 1;
			 pan2.add(provincia, cp3);
			 
			 cp3 = new GridBagConstraints();
			 cp3.gridx = 3;
			 cp3.gridy = 1;
			 pan2.add(province, cp3);

			 cp3 = new GridBagConstraints();
			 cp3.gridx = 0;
			 cp3.gridy = 2;
			 pan2.add(pais, cp3);
			 
			 cp3 = new GridBagConstraints();
			 cp3.gridx = 1;
			 cp3.gridy = 2;
			 pan2.add(country, cp3);

			 cp3 = new GridBagConstraints();
			 cp3.gridx = 1;
			 cp3.gridy = 3;
			 pan2.add(actualizar, cp3);
			 


			 cp1.add(pan, BorderLayout.NORTH);
			 cp1.add(pan2, BorderLayout.CENTER);
				
			consultarLocalidad.addActionListener(this);
			consultarLocalidad.setActionCommand("buscar");
			
			actualizar.addActionListener(this);
			actualizar.setActionCommand("actualizar");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando= evt.getActionCommand();
		switch(comando){
		case "buscar":
			buscar();
			break;
		case "actualizar":
			actualizar();
			break;
		default:
			break;
		}
	}
	private void actualizar() {
		// TODO Auto-generated method stub
		con.actualizarLocalidad(co, Integer.parseInt(txtlocalidad.getText()), street.getText(), postal.getText(), city.getText(), 
				province.getText(), country.getText());
		 JOptionPane.showMessageDialog(this, " Actualizado Correctamente ");
		 txtlocalidad.setText("");
		 street.setText("");
		 postal.setText("");
		 city.setText("");
		 province.setText("");
		 country.setText("");
		
		
	}
	private void buscar() {
		// TODO Auto-generated method stub
		con.ConsultarLacalidades(co, txtlocalidad.getText());
		List<Localidad> localidades= con.getLocalidades();
		for (int i = 0; i < localidades.size(); i++) {
			Localidad loc=localidades.get(i);
			street.setText(loc.getStreet_address());
			province.setText(loc.getState_province());
			city.setText(loc.getCity());
			postal.setText(loc.getPostal_code());
			country.setText(loc.getCountry_id());
		}
		
		
	}
	

}
