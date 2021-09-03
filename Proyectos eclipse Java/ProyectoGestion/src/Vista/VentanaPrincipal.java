package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Conexion.Conexion;
import Conexion.Conexion2;
import Logica.Consulta;
import Logica.ConsultaJob;
/**
 * En esta clase nos sirve para poder generar la inetrfaz grafica 
 * en la cual tendremoss los metodos insertar, consultar, borrar 
 * y la aplicacion de conexion con la otrra maquina 
 * @author TOSHIBA
 *
 */
public class VentanaPrincipal extends JFrame implements ActionListener  {
	private JDesktopPane escritorio;
	private Consulta con;
	private JMenu App1, App2;
	private JMenuItem consultas,insertar,borrar, app2,actualizar;
	private Conexion co;
	private ConsultaJob con2;
	private Conexion2 co2;
	
	public  VentanaPrincipal(Consulta con, Conexion co, ConsultaJob con2, Conexion2 co2) {
		this.con=con;
		this.co=co;
		
		this.con2=con2;
		this.co2=co2;
		
		initComponents();
	}
	

	
	private void initComponents() {
		// TODO Auto-generated method stub
		setSize(800,600);
		setTitle("Gestion Base Datos");
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();		
		getContentPane().add(escritorio, BorderLayout.CENTER);
		
		JMenuBar barra = new JMenuBar();
		App1 = new JMenu("App1");
//		App2 = new JMenu("App2");
		
		consultas = new JMenuItem("Consultar");
		consultas.addActionListener(this);
		consultas.setActionCommand("consultar");
		App1.add(consultas);
		
		insertar = new JMenuItem(" Insertar ");
		insertar.addActionListener(this);
		insertar.setActionCommand("insertar");
		App1.add(insertar);
		
		borrar = new JMenuItem(" Borrar ");
		borrar.addActionListener(this);
		borrar.setActionCommand("borrar");
		App1.add(borrar);
		
		actualizar = new JMenuItem("Actualizar");
		actualizar.addActionListener(this);
		actualizar.setActionCommand("actualizar");
		App1.add(actualizar);
		
		app2 = new JMenuItem("Ap2");
		app2.addActionListener(this);
		app2.setActionCommand("ap2");
		App1.add(app2);
		
		barra.add(App1);
//		barra.add(App2);
		
		
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
		case "ap2":
			consultarJob();
			break;
		case "actualizar":
			actualizar();
			break;
		default :
			break;
		}
		
		
	}



	private void actualizar() {
		// TODO Auto-generated method stub
		Actualizar ac = new Actualizar(con, co);
		ac.setVisible(true);
		escritorio.add(ac);
		try {
			ac.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
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
		 ConsultaVen cr= new ConsultaVen(con,co);
 		cr.setVisible(true);
 		escritorio.add(cr);
 		try {
			cr.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void consultarJob() {
		OperacionesJob op = new OperacionesJob(con2, co2);
		op.setVisible(true);
		escritorio.add(op);
		
		try {
			op.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
}
