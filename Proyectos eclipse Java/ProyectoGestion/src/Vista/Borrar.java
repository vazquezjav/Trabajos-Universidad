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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Conexion.Conexion;
import Logica.Consulta;

public class Borrar extends JInternalFrame implements ActionListener {

	private JTextField txtregion;
	private JTextField txtpais;
	private JTextField txtlocalidad;
	private JLabel codigoRegion;
	private JLabel codigoPais;
	private JLabel codigoLocalidad;
	private JButton borrarRegion;
	private JButton borrarPais;
	private JButton borrarLocalidad;
	private Consulta con;
	private Conexion co;
	

	public void initComponents(){
		
		setTitle(" Borrar");
		setSize(500,500);
		
	}
	public Borrar(Consulta con, Conexion co) {
		 this.co=co;
			// TODO Auto-generated constructor stub
			this.con=con;
			initComponents();
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			txtregion= new JTextField(10);
			codigoRegion = new JLabel(" Codigo Region ");
			borrarRegion = new JButton(" Borrar"	);
			
			txtpais =  new JTextField(10);
			codigoPais = new JLabel(" Codigo Pais");
			borrarPais = new JButton(" Borrar");
			
			txtlocalidad = new JTextField(10);
			codigoLocalidad = new JLabel("Codigo Localidad");
			borrarLocalidad = new JButton(" Borrar ");
			
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
				pan.add(borrarRegion, cp2);
				


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
				pan.add(borrarPais, cp2);
				
				
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
				pan.add(borrarLocalidad, cp2);
				
				
				
				cp1.add(pan, BorderLayout.CENTER);
				
				borrarRegion.addActionListener(this);
				borrarRegion.setActionCommand("borrarRegion");
				
				borrarPais.addActionListener(this);
				borrarPais.setActionCommand("borrarPais");
				
				borrarLocalidad.addActionListener(this);
				borrarLocalidad.setActionCommand("borrarLocalidad");
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando= evt.getActionCommand();
		switch(comando){
		case "borrarRegion":
			borrarRegion();
			break;
		case "borrarPais":
			borrarPais();
			break;
		case "borrarLocalidad":
			borrarLocalidad();
			break;
		}
		
	}
	private void borrarRegion() {
		// TODO Auto-generated method stub
		con.borrarRegion(co, Integer.parseInt(txtregion.getText()));
		JOptionPane.showMessageDialog(this, " Borrado Corectamente ");
		txtregion.setText("");
		
	}
	private void borrarPais() {
		// TODO Auto-generated method stub
		con.borrarPais(co, txtpais.getText());

		JOptionPane.showMessageDialog(this, " Borrado Corectamente ");
		txtpais.setText("");
		
		
	}
	private void borrarLocalidad() {
		// TODO Auto-generated method stub
		con.borrarLocalidad(co, Integer.parseInt(txtlocalidad.getText()));

		JOptionPane.showMessageDialog(this, " Borrado Corectamente ");
		txtlocalidad.setText("");
	}
	
}
