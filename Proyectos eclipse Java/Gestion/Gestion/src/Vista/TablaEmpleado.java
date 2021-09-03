package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controlador.Conexion;
import Controlador.Consulta;

public class TablaEmpleado extends JFrame {

	private Consulta con;
	private Conexion co;
	private JTable tblEmpleados;

	public TablaEmpleado(Consulta con, Conexion co) {
		this.con = con;
		this.co = co;
		setSize(150, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		JPanel pnlTitulo = new JPanel(new FlowLayout());
		JLabel lblTitulo = new JLabel("Consulta Empleados");
		pnlTitulo.add(lblTitulo);
		tblEmpleados = new JTable();
		tblEmpleados.setModel(new ModeloRegion());
		JScrollPane scrollPaneTabla = new JScrollPane(tblEmpleados);
		getContentPane().add(pnlTitulo, BorderLayout.NORTH);
		getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);

		tblEmpleados.setModel(new ModeloEmpleado(con.getEmpleados()));

	}
}