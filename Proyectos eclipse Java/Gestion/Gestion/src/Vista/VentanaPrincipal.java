package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controlador.Conexion;
import Controlador.Consulta;

public class VentanaPrincipal extends JFrame implements ActionListener {
	private JDesktopPane escritorio;
	private Consulta con;
	private JMenu archivo;
	private JMenuItem consultas, insertar, borrar;
	private Conexion co;

	public VentanaPrincipal(Consulta con, Conexion co) {
		this.con = con;
		this.co = co;
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setSize(800, 600);
		setTitle("Gestion Base Datos");
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();
		getContentPane().add(escritorio, BorderLayout.CENTER);

		JMenuBar barra = new JMenuBar();
		archivo = new JMenu("Archivo");

		consultas = new JMenuItem("Consultar");
		consultas.addActionListener(this);
		consultas.setActionCommand("consultar");
		archivo.add(consultas);

		insertar = new JMenuItem(" Insertar ");
		insertar.addActionListener(this);
		insertar.setActionCommand("insertar");
		archivo.add(insertar);

		borrar = new JMenuItem(" Borrar ");
		borrar.addActionListener(this);
		borrar.setActionCommand("borrar");
		archivo.add(borrar);

		barra.add(archivo);

		setJMenuBar(barra);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String comando = e.getActionCommand();
		switch (comando) {
		case "consultar":
			consultar();
			break;
		case "insertar":
			insertar();
			break;
		case "borrar":
			borrar();
			break;
		default:
			break;
		}

	}

	private void borrar() {
		// TODO Auto-generated method stub
		Borrar br = new Borrar(con, co);
		br.setVisible(true);
		escritorio.add(br);
		try {
			br.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertar() {
		// TODO Auto-generated method stub
		Insertar in = new Insertar(con, co);
		in.setVisible(true);
		escritorio.add(in);
		try {
			in.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void consultar() {
		// TODO Auto-generated method stub
		ConsultaVen cr = new ConsultaVen(con, co);
		cr.setVisible(true);
		escritorio.add(cr);
		try {
			cr.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
