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

import Controlador.Conexion;
import Controlador.Consulta;

public class Insertar extends JInternalFrame implements ActionListener {

	private JTextField txtregion, txtregion_name;
	private JLabel lblregion, lblregion_name;

	private JTextField txtcountry, txtcountry_name, txtCregion_id;
	private JLabel lblcountry, lblcountry_name, lblCregion_id;

	private JTextField txtlocation, txtstreet_address, txtpostal_code, txtcity, txtstate_province, txtLcountr_id;
	private JLabel lbllocation, lblstreet_address, lblpostal_code, lblcity, lblstate_province, lblLcountry_id;

	// departments
	private JTextField txtDepartamentId, txtDepartmentName, txtManagerId, txtLocationId;
	private JLabel lblDepartamentId, lblDepartmentName, lblManagerId, lblLocationId;

	// employees
	private JTextField txtEmployeeId, txtFirstName, txtLastName, txtEmail, txtPhoneNumber, txtHireDate, txtJobId,
			txtSalary, txtCommission, txtManId, txtDeparId;
	private JLabel lblEmployeeId, lblFirstName, lblLastName, lblEmail, lblPhoneNumber, lblHireDate, lblJobId, lblSalary,
			lblCommission, lblManId, lblDeparId;

	// jobhistory
	private JTextField txtEmId, txtStartDate, txtEndDate, txtJoId, txtDeId;
	private JLabel lblEmId, lblStartDate, lblEndDate, lblJoId, lblDeId;

	// jobs
	private JTextField txtJId, txtJobTitle, txtMinSal, txtMaxSal;
	private JLabel lblJId, lblJobTitle, lblMinSal, lblMaxSal;

	private JButton insertarRegion, insertarPais, insertarLocalidad;

	private Consulta con;
	private Conexion co;

	public void initComponents() {

		setTitle(" INSERTAR ");
		setSize(700, 500);

	}

	public Insertar(Consulta con, Conexion co) {
		this.co = co;
		this.con = con;
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// departments
		txtDepartamentId = new JTextField(10);
		txtDepartmentName = new JTextField(10);
		txtManagerId = new JTextField(10);
		txtLocationId = new JTextField(10);
		lblDepartamentId = new JLabel("Codigo");
		lblDepartmentName = new JLabel("NombreDepartamento");
		lblManagerId = new JLabel("CodigoManager");
		lblLocationId = new JLabel("Codigolocalizacion");

		// employees
		txtEmployeeId = new JTextField(10);
		txtFirstName = new JTextField(10);
		txtLastName = new JTextField(10);
		txtEmail = new JTextField(10);
		txtPhoneNumber = new JTextField(10);
		txtHireDate = new JTextField(10);
		txtJobId = new JTextField(10);
		txtSalary = new JTextField(10);
		txtCommission = new JTextField(10);
		txtManId = new JTextField(10);
		txtDeparId = new JTextField(10);

		lblEmployeeId = new JLabel("CodEmpleado");
		lblFirstName = new JLabel("Nombre");
		lblLastName = new JLabel("Apellido");
		lblEmail = new JLabel("Correo");
		lblPhoneNumber = new JLabel("Numero");
		lblHireDate = new JLabel("Contratacion");
		lblJobId = new JLabel("CodTrabajo");
		lblSalary = new JLabel("Salario");
		lblCommission = new JLabel("Comision");
		lblManId = new JLabel("CodManager");
		lblDeparId = new JLabel("CodDepartamento");

		// jobhistory
		txtEmId = new JTextField(10);
		txtStartDate = new JTextField(10);
		txtEndDate = new JTextField(10);
		txtJoId = new JTextField(10);
		txtDeId = new JTextField(10);

		lblEmId = new JLabel("CodEmpleado");
		lblStartDate = new JLabel("Inicio");
		lblEndDate = new JLabel("Fin");
		lblJoId = new JLabel("CodTrabajo");
		lblDeId = new JLabel("CodDep");

		// jobs
		txtJId = new JTextField(10);
		txtJobTitle = new JTextField(10);
		txtMinSal = new JTextField(10);
		txtMaxSal = new JTextField(10);

		lblJId = new JLabel("CodEmpleado");
		lblJobTitle = new JLabel("Titulo");
		lblMinSal = new JLabel("Minsalario");
		lblMaxSal = new JLabel("MaxSalario");

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
		default:
			break;

		}
	}

	private void insertarLocalidad() {
		// TODO Auto-generated method stub
		con.insertarLocalidad(co, Integer.parseInt(txtlocation.getText()), txtstreet_address.getText(),
				txtpostal_code.getText(), txtcity.getText(), txtstate_province.getText(), txtLcountr_id.getText());
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
		txtlocation.setText("");
		txtstreet_address.setText("");
		txtpostal_code.setText("");
		txtcity.setText("");
		txtstate_province.setText("");
		txtLcountr_id.setText("");
	}

	private void insertarDepartamento() {
		// TODO Auto-generated method stub
		con.insertarDepartamento(co, Integer.parseInt(txtDepartamentId.getText()), txtDepartmentName.getText(),
				Integer.parseInt(txtManagerId.getText()), Integer.parseInt(txtLocationId.getText()));
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");

		txtDepartamentId.setText("");
		txtDepartmentName.setText("");
		txtManagerId.setText("");
		txtLocationId.setText("");
	}

	private void insertarEmpleado() {
		// TODO Auto-generated method stub
		con.insertarEmpleado(co, Integer.parseInt(txtEmployeeId.getText()), txtFirstName.getText(),
				txtLastName.getText(), txtEmail.getText(), txtPhoneNumber.getText(), txtHireDate.getText(),
				txtJobId.getText(), Integer.parseInt(txtSalary.getText()), Integer.parseInt(txtCommission.getText()),
				Integer.parseInt(txtManId.getText()), Integer.parseInt(txtDeparId.getText()));
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");

		txtEmployeeId.setText("");
		txtFirstName.setText("");
		txtLastName.setText("");
		txtEmail.setText("");
		txtPhoneNumber.setText("");
		txtHireDate.setText("");
		txtJobId.setText("");
		txtSalary.setText("");
		txtCommission.setText("");
		txtManId.setText("");
		txtDeparId.setText("");
	}
	
	private void insertarTrabajo() {
		// TODO Auto-generated method stub
		con.insertarTrabajo(co,txtJId.getText(),txtJobTitle.getText(),Integer.parseInt(txtMinSal.getText()),Integer.parseInt(txtMaxSal.getText()) );
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");

		txtJId.setText("");
		txtJobTitle.setText("");
		txtMinSal.setText("");
		txtMaxSal.setText("");
	}

	private void insertarHistoriaTrabajo() {
		// TODO Auto-generated method stub
		con.insertarHistoriaTrabajo(co,Integer.parseInt(txtEmId.getText()),txtStartDate.getText(),txtEndDate.getText(),txtJoId.getText(),Integer.parseInt(txtDeId.getText()));
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");

		txtEmId.setText("");
		txtStartDate.setText("");
		txtEndDate.setText("");
		txtJoId.setText("");
		txtDeId.setText("");
	}


	private void insertarPais() {
		// TODO Auto-generated method stub
		con.insertarPais(co, txtcountry.getText(), txtcountry_name.getText(),
				Integer.parseInt(txtCregion_id.getText()));
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
		txtcountry.setText("");
		txtcountry_name.setText("");
		txtCregion_id.setText("");
	}

	private void insertarRegion() {
		// TODO Auto-generated method stub

		con.insertarRegion(co, Integer.parseInt(txtregion.getText()), txtregion_name.getText());
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
		txtregion.setText("");
		txtregion_name.setText("");
	}

}
