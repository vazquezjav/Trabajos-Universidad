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

import Controlador.Conexion;
import Controlador.Consulta;

public class Borrar extends JInternalFrame implements ActionListener {

	private JTextField txtregion;
	private JTextField txtpais;
	private JTextField txtlocalidad;
	private JTextField txtDepartamento;
	private JTextField txtTrabajo;
	private JTextField txtEmpleado;
	private JTextField txtHistoria;
	private JLabel codigoRegion;
	private JLabel codigoPais;
	private JLabel codigoLocalidad;
	private JLabel codigoDepartamento;
	private JLabel codigoTrabajo;
	private JLabel codigoEmpleado;
	private JLabel codigoHistoria;
	private JButton borrarRegion;
	private JButton borrarPais;
	private JButton borrarLocalidad;
	private JButton borrarDepartamento;
	private JButton borrarTrabajo;
	private JButton borrarEmpleado;
	private JButton borrarHistoria;
	private Consulta con;
	private Conexion co;

	public void initComponents() {

		setTitle(" Borrar");
		setSize(500, 500);

	}

	public Borrar(Consulta con, Conexion co) {
		this.co = co;
		// TODO Auto-generated constructor stub
		this.con = con;
		initComponents();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txtregion = new JTextField(10);
		codigoRegion = new JLabel(" Codigo Region ");
		borrarRegion = new JButton(" Borrar");

		txtpais = new JTextField(10);
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

		cp2.gridx = 0;
		cp2.gridy = 5;
		pan.add(codigoDepartamento, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 2;
		cp2.gridy = 5;
		pan.add(txtDepartamento, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 5;
		pan.add(borrarDepartamento, cp2);

		cp2.gridx = 0;
		cp2.gridy = 6;
		pan.add(codigoTrabajo, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 2;
		cp2.gridy = 6;
		pan.add(txtTrabajo, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 6;
		pan.add(borrarTrabajo, cp2);

		cp2.gridx = 0;
		cp2.gridy = 7;
		pan.add(codigoEmpleado, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 2;
		cp2.gridy = 7;
		pan.add(txtEmpleado, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 7;
		pan.add(borrarEmpleado, cp2);

		cp2.gridx = 0;
		cp2.gridy = 8;
		pan.add(codigoHistoria, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 2;
		cp2.gridy = 8;
		pan.add(txtHistoria, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 8;
		pan.add(borrarHistoria, cp2);

		cp1.add(pan, BorderLayout.CENTER);

		borrarRegion.addActionListener(this);
		borrarRegion.setActionCommand("borrarRegion");

		borrarPais.addActionListener(this);
		borrarPais.setActionCommand("borrarPais");

		borrarLocalidad.addActionListener(this);
		borrarLocalidad.setActionCommand("borrarLocalidad");

		borrarDepartamento.addActionListener(this);
		borrarDepartamento.setActionCommand("borrarDepar");

		borrarTrabajo.addActionListener(this);
		borrarTrabajo.setActionCommand("borrarTra");

		borrarEmpleado.addActionListener(this);
		borrarEmpleado.setActionCommand("borrarEmple");

		borrarHistoria.addActionListener(this);
		borrarHistoria.setActionCommand("borrarHis");
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando = evt.getActionCommand();
		switch (comando) {
		case "borrarRegion":
			borrarRegion();
			break;
		case "borrarPais":
			borrarPais();
			break;
		case "borrarLocalidad":
			borrarLocalidad();
			break;
		case "borrarDepar":
			borrarDepar();
			break;
		case "borrarTra":
			borrarTra();
			break;
		case "borrarEmple":
			borrarEmple();
			break;
		case "borrarHis":
			borrarHis();
			break;
		}

	}

	private void borrarHis() {
		con.borrarHistoriaTrabajo(co, Integer.parseInt(txtHistoria.getText()));
		JOptionPane.showMessageDialog(this, " Borrado Corectamente ");
		txtHistoria.setText("");

	}

	private void borrarEmple() {
		con.borrarEmpleado(co, Integer.parseInt(txtEmpleado.getText()));
		JOptionPane.showMessageDialog(this, " Borrado Corectamente ");
		txtEmpleado.setText("");

	}

	private void borrarTra() {
		con.borrarTrabajo(co, txtTrabajo.getText());
		JOptionPane.showMessageDialog(this, " Borrado Corectamente ");
		txtTrabajo.setText("");

	}

	private void borrarDepar() {
		con.borrarDepartamento(co, Integer.parseInt(txtTrabajo.getText()));
		JOptionPane.showMessageDialog(this, " Borrado Corectamente ");
		txtTrabajo.setText("");
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
