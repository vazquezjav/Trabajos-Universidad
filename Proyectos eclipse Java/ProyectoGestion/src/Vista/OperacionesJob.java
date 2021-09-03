package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Conexion.Conexion;
import Conexion.Conexion2;
import Logica.ConsultaJob;
import Logica.Localidad;
import Logica.Trabajo;

/**
 * En esta clase se desarrollara las interfaces del programa(JInternalFrame).
 * 
 * @author danie
 *
 */

public class OperacionesJob extends JInternalFrame implements ActionListener {

	/**
	 * Creamos las etiquetas cuadros de texto.
	 */
	private JTextField txtJob, txtJob1;
	// jobs
	private JTextField txtJId, txtJobTitle, txtMinSal, txtMaxSal, txtJId1, txtJobTitle1, txtMinSal1, txtMaxSal1;
	private JLabel lblJId, lblJobTitle, lblMinSal, lblMaxSal, lblJId1, lblJobTitle1, lblMinSal1, lblMaxSal1;
	private JLabel lblJob, lblJob1;
	private JButton consultarJob, insertarJob, borrarJob, buscarJob, actualizarJob;
	private ConsultaJob con;
	private Conexion2 co;

	public void initComponents() {

		setTitle("Operaciones");
		setSize(1000, 500);

	}

	public OperacionesJob(ConsultaJob con, Conexion2 co) {
		this.co = co;
		// TODO Auto-generated constructor stub
		this.con = con;
		initComponents();

		/**
		 * Damos tamano a cada cuadro creado.
		 */

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * Consultar
		 */
		txtJob = new JTextField(10);
		lblJob = new JLabel(" Codigo Job ");
		consultarJob = new JButton(" ConsultarJob ");
		/**
		 * Insertar
		 */
		txtJId = new JTextField(10);
		txtJobTitle = new JTextField(10);
		txtMinSal = new JTextField(10);
		txtMaxSal = new JTextField(10);
		lblJId = new JLabel("CodigoJob");
		lblJobTitle = new JLabel("Titulo");
		lblMinSal = new JLabel("SalarioMinimo");
		lblMaxSal = new JLabel("SalarioMaximo");
		insertarJob = new JButton("InsertarJob");
		/**
		 * Borrar
		 */
		txtJob1 = new JTextField(10);
		lblJob1 = new JLabel(" CodigoJob ");
		borrarJob = new JButton(" BorrarJob ");
		/**
		 * Actualizar
		 */
		txtJId1 = new JTextField(10);
		txtJobTitle1 = new JTextField(10);
		txtMinSal1 = new JTextField(10);
		txtMaxSal1 = new JTextField(10);
		lblJId1 = new JLabel("CodigoJob");
		lblJobTitle1 = new JLabel("Titulo");
		lblMinSal1 = new JLabel("SalarioMinimo");
		lblMaxSal1 = new JLabel("SalarioMaximo");
		buscarJob = new JButton("BuscarJob");
		actualizarJob = new JButton("ActualizarJob");
		/**
		 * Creamos los paneles de la ventana.
		 */
		JPanel pan = new JPanel();
		Container cp1 = getContentPane();
		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();

		/**
		 * Definimos donde va ir ubicado cada panel.
		 */
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(lblJob, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 2;
		cp2.gridy = 0;
		pan.add(txtJob, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 0;

		pan.add(consultarJob, cp2);
		pan.setBorder(BorderFactory.createTitledBorder("Consultar Job "));
		cp1.add(pan, BorderLayout.NORTH);

		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridBagLayout());
		GridBagConstraints cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 0;
		pan2.add(lblJId, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 0;
		pan2.add(txtJId, cp3);

		cp3.gridx = 2;
		cp3.gridy = 0;
		pan2.add(lblJobTitle, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 3;
		cp3.gridy = 0;
		pan2.add(txtJobTitle, cp3);

		cp3.gridx = 4;
		cp3.gridy = 0;
		pan2.add(lblMinSal, cp3);
		cp3.gridx = 5;
		cp3.gridy = 0;
		pan2.add(txtMinSal, cp3);

		cp3.gridx = 6;
		cp3.gridy = 0;
		pan2.add(lblMaxSal, cp3);
		cp3.gridx = 7;
		cp3.gridy = 0;
		pan2.add(txtMaxSal, cp3);

		cp3.gridx = 8;
		cp3.gridy = 0;
		pan2.add(insertarJob, cp3);

		pan2.setBorder(BorderFactory.createTitledBorder(" Insertar Job "));
		cp1.add(pan2, BorderLayout.CENTER);

		JPanel pan3 = new JPanel();
		pan3.setLayout(new GridBagLayout());
		GridBagConstraints cp4 = new GridBagConstraints();
		cp4.gridx = 0;
		cp4.gridy = 0;
		pan3.add(lblJob1, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 1;
		cp4.gridy = 0;
		pan3.add(txtJob1, cp4);
		cp4.gridx = 2;
		cp4.gridy = 0;

		pan3.add(borrarJob, cp4);
		pan3.setBorder(BorderFactory.createTitledBorder(" BorrarJob "));
		cp1.add(pan3, BorderLayout.SOUTH);

		JPanel pan4 = new JPanel();
		pan4.setLayout(new GridBagLayout());
		GridBagConstraints cp5 = new GridBagConstraints();
		cp5.gridx = 0;
		cp5.gridy = 0;
		pan4.add(lblJId1, cp5);
		cp5 = new GridBagConstraints();
		cp5.gridx = 1;
		cp5.gridy = 0;
		pan4.add(txtJId1, cp5);
		cp5.gridx = 2;
		cp5.gridy = 0;
		pan4.add(buscarJob, cp5);

		cp5.gridx = 3;
		cp5.gridy = 0;
		pan4.add(lblJobTitle1, cp5);
		cp5 = new GridBagConstraints();
		cp5.gridx = 4;
		cp5.gridy = 0;
		pan4.add(txtJobTitle1, cp5);

		cp5.gridx = 5;
		cp5.gridy = 0;
		pan4.add(lblMinSal1, cp5);
		cp5.gridx = 6;
		cp5.gridy = 0;
		pan4.add(txtMinSal1, cp5);

		cp5.gridx = 7;
		cp5.gridy = 0;
		pan4.add(lblMaxSal1, cp5);
		cp5.gridx = 8;
		cp5.gridy = 0;
		pan4.add(txtMaxSal1, cp5);

		cp5.gridx = 9;
		cp5.gridy = 0;
		pan4.add(actualizarJob, cp5);

		pan4.setBorder(BorderFactory.createTitledBorder(" ActualizarJob "));
		cp1.add(pan4, BorderLayout.PAGE_END);

		consultarJob.addActionListener(this);
		consultarJob.setActionCommand("consultarJob");

		insertarJob.addActionListener(this);
		insertarJob.setActionCommand("insertarJob");

		borrarJob.addActionListener(this);
		borrarJob.setActionCommand("borrarJob");

		buscarJob.addActionListener(this);
		buscarJob.setActionCommand("buscarJob");

		actualizarJob.addActionListener(this);
		actualizarJob.setActionCommand("actualizarJob");

	}

	/**
	 * Creamos un switch para que llames a los metodos ya creados.
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando = evt.getActionCommand();
		switch (comando) {
		case "consultarJob":
			consultarJob();
			break;
		case "insertarJob":
			insertarJob();
			break;
		case "borrarJob":
			borrarJob();
			break;
		case "buscarJob":
			buscarJob();
			break;
		case "actualizarJob":
			actualizarJob();
			break;

		}
	}

	/**
	 * Llamamos a los metodos creados.
	 */

	private void actualizarJob() {
		con.actualizarTrabajo(co, txtJId1.getText(), txtJobTitle1.getText(), Integer.parseInt(txtMinSal1.getText()),
				Integer.parseInt(txtMaxSal1.getText()));
		JOptionPane.showMessageDialog(this, " Actualizado Correctamente ");
		txtJId1.setText("");
		txtJobTitle1.setText("");
		txtMinSal1.setText("");
		txtMaxSal1.setText("");
	}

	private void buscarJob() {
		con.ConsultarTrabajo(co, txtJId1.getText());
		List<Trabajo> trabajos = con.getTrabajos();
		for (int i = 0; i < trabajos.size(); i++) {
			Trabajo tra = trabajos.get(i);
			txtJobTitle1.setText(tra.getJob_title());
			txtMinSal1.setText(String.valueOf(tra.getMin_salary()));
			txtMaxSal1.setText(String.valueOf(tra.getMax_salary()));

		}

	}

	private void borrarJob() {
		// TODO Auto-generated method stub
		con.borrarTrabajo(co, txtJob1.getText());
		JOptionPane.showMessageDialog(this, " Borrado Corectamente ");
		txtJob1.setText("");

	}

	private void insertarJob() {
		// TODO Auto-generated method stub
		con.insertarTrabajo(co, txtJId.getText(), txtJobTitle.getText(), Integer.parseInt(txtMinSal.getText()),
				Integer.parseInt(txtMaxSal.getText()));
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");

		txtJId.setText("");
		txtJobTitle.setText("");
		txtMinSal.setText("");
		txtMaxSal.setText("");
	}

	private void consultarJob() {
		con.ConsultarTrabajo(co, txtJob.getText());
		TablaTrabajo ttr = new TablaTrabajo(con, co);
		ttr.setVisible(true);
	}

}
