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
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.Conexion;
import Controlador.Consulta;

public class ConsultaVen extends JInternalFrame implements ActionListener {

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
	private JButton consultarRegion;
	private JButton consultarPais;
	private JButton consultarLocalidad;
	private JButton consultarDepartamento;
	private JButton consultarTrabajo;
	private JButton consultarEmpleado;
	private JButton consultarHistoria;
	private Consulta con;
	private Conexion co;

	public void initComponents() {

		setTitle("Consultas");
		setSize(500, 500);

	}

	public ConsultaVen(Consulta con, Conexion co) {
		this.co = co;
		// TODO Auto-generated constructor stub
		this.con = con;
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtregion = new JTextField(10);
		codigoRegion = new JLabel(" Codigo Region ");
		consultarRegion = new JButton(" Consultar");

		txtpais = new JTextField(10);
		codigoPais = new JLabel(" Codigo Pais");
		consultarPais = new JButton("Consultar");

		txtlocalidad = new JTextField(10);
		codigoLocalidad = new JLabel("Codigo Localidad");
		consultarLocalidad = new JButton("Consultar ");

		txtDepartamento = new JTextField(10);
		codigoDepartamento = new JLabel(" Codigo Departamento ");
		consultarDepartamento = new JButton(" Consultar");

		txtTrabajo = new JTextField(10);
		codigoTrabajo = new JLabel(" Codigo Trabajo");
		consultarTrabajo = new JButton("Consultar");

		txtEmpleado = new JTextField(10);
		codigoEmpleado = new JLabel("Codigo Empleado");
		consultarEmpleado = new JButton("Consultar ");

		txtHistoria = new JTextField(10);
		codigoHistoria = new JLabel("Codigo Historia");
		consultarHistoria = new JButton("Consultar ");

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

		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridBagLayout());
		GridBagConstraints cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 0;
		pan2.add(codigoDepartamento, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 0;
		pan2.add(txtDepartamento, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 2;
		cp3.gridy = 0;
		pan2.add(consultarDepartamento, cp3);

		cp3.gridx = 3;
		cp3.gridy = 0;
		pan2.add(codigoTrabajo, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 4;
		cp3.gridy = 0;
		pan2.add(txtTrabajo, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 5;
		cp3.gridy = 0;
		pan2.add(consultarTrabajo, cp3);

		cp3.gridx = 6;
		cp3.gridy = 0;
		pan2.add(codigoEmpleado, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 1;
		pan2.add(txtEmpleado, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 1;
		pan2.add(consultarEmpleado, cp3);

		cp3.gridx = 2;
		cp3.gridy = 1;
		pan2.add(codigoHistoria, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 3;
		cp3.gridy = 1;
		pan2.add(txtHistoria, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 4;
		cp3.gridy = 1;
		pan2.add(consultarHistoria, cp3);
		
		cp1.add(pan, BorderLayout.NORTH);
		
		pan2.setBorder(BorderFactory.createTitledBorder(" Consultas "));
		cp1.add(pan2, BorderLayout.CENTER);

		consultarRegion.addActionListener(this);
		consultarRegion.setActionCommand("consulta");

		consultarPais.addActionListener(this);
		consultarPais.setActionCommand("consultaPais");

		consultarLocalidad.addActionListener(this);
		consultarLocalidad.setActionCommand("consultaLocalidad");

		consultarDepartamento.addActionListener(this);
		consultarDepartamento.setActionCommand("consultaDepar");

		consultarTrabajo.addActionListener(this);
		consultarTrabajo.setActionCommand("consultaTra");

		consultarEmpleado.addActionListener(this);
		consultarEmpleado.setActionCommand("consultaEmple");

		consultarHistoria.addActionListener(this);
		consultarHistoria.setActionCommand("consultaHis");

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

		String comando = evt.getActionCommand();
		switch (comando) {
		case "consulta":
			consultar();
			break;
		case "consultaPais":
			consultarPais();
			break;
		case "consultaLocalidad":
			consultarLocalidad();
			break;
		case "consultaDepar":
			consultarDepar();
			break;
		case "consultaTra":
			consultarTra();
			break;
		case "consultaEmple":
			consultarEmple();
			break;
		case "consultaHis":
			consultarHis();
			break;

		}
	}

	private void consultarHis() {
		con.ConsultarRegion(co, txtHistoria.getText());
		TablaHistoriaTrabajo ti = new TablaHistoriaTrabajo(con, co);
		ti.setVisible(true);

	}

	private void consultarEmple() {
		con.ConsultarRegion(co, txtEmpleado.getText());
		TablaEmpleado te = new TablaEmpleado(con, co);
		te.setVisible(true);

	}

	private void consultarTra() {
		con.ConsultarRegion(co, txtTrabajo.getText());
		TablaTrabajo ttr = new TablaTrabajo(con, co);
		ttr.setVisible(true);
	}

	private void consultarDepar() {
		con.ConsultarRegion(co, txtDepartamento.getText());
		TablaDepartamento td = new TablaDepartamento(con, co);
		td.setVisible(true);
	}

	public void consultar() {
		con.ConsultarRegion(co, txtregion.getText());
		TablaRegion tr = new TablaRegion(con, co);
		tr.setVisible(true);
	}

	public void consultarPais() {
		con.ConsultarPaises(co, txtpais.getText());
		TablaPais tp = new TablaPais(con, co);
		tp.setVisible(true);

	}

	public void consultarLocalidad() {
		con.ConsultarLacalidades(co, txtlocalidad.getText());
		TablaLocalidad tl = new TablaLocalidad(con, co);
		tl.setVisible(true);
	}
}