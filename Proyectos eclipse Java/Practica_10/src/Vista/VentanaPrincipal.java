package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controlador.Gestion;



public class VentanaPrincipal extends JFrame implements ActionListener {

	private JDesktopPane escritorio;
	private Gestion gd;
	public static Locale localizacion;
	private JMenu mnu2, mnuVentanas,listados, buscar;
	private JMenuItem mnuVentana1,mnuVentana2,mnuVentana3,mnuVentana4,mnuVentana5,listadoU,listadoI,listadoA,buscarA,buscarU;
	public VentanaPrincipal(){
		gd=new Gestion();
		initComponents();
	}
	public void initComponents(){
		
		localizacion=new Locale("es","EC");
		ResourceBundle lang= ResourceBundle.getBundle("Vista.mensajes",localizacion);
		
		setSize(800,600);
		setTitle("MisVentanas");
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();		
		getContentPane().add(escritorio, BorderLayout.CENTER);
		
		JMenuBar barra = new JMenuBar();

		 mnuVentanas = new JMenu(lang.getString("Archivo"));
		 
	     mnuVentana1 = new JMenuItem(lang.getString("DatoRector"));
		mnuVentana1.addActionListener(this);
		mnuVentana1.setActionCommand("mnuVentana1");
		mnuVentanas.add(mnuVentana1);

		 mnuVentana2 = new JMenuItem(lang.getString("DatoUniversidad"));
		mnuVentana2.addActionListener(this);
		mnuVentana2.setActionCommand("mnuVentana2");
		mnuVentanas.add(mnuVentana2);
		
		 mnuVentana3 = new JMenuItem(lang.getString("DatoCarrera"));
		mnuVentana3.addActionListener(this);
		mnuVentana3.setActionCommand("mnuVentana3");
		mnuVentanas.add(mnuVentana3);
		
		mnuVentana5= new JMenuItem(lang.getString("inscripcion"));
		mnuVentana5.addActionListener(this);
		mnuVentana5.setActionCommand("inscripcion");
		mnuVentanas.add(mnuVentana5);
		
		barra.add(mnuVentanas);
		
		listados= new JMenu(lang.getString("Listas"));
		listadoU= new JMenuItem(lang.getString("listasUniversidad"));
		listadoU.addActionListener(this);
		listadoU.setActionCommand("listado");
		listados.add(listadoU);

		listadoA=new JMenuItem(lang.getString("listasAspirante"));
		listadoA.addActionListener(this);
		listadoA.setActionCommand("listadoA");
		listados.add(listadoA);
		
		listadoI= new JMenuItem(lang.getString("listaInscripcion"));
		listadoI.addActionListener(this);
		listadoI.setActionCommand("listaI");
		listados.add(listadoI);
		
		barra.add(listados);
		
		buscar=new JMenu(lang.getString("buscar"));
		buscarA= new JMenuItem(lang.getString("buscarAspirante"));
		buscarA.addActionListener(this);
		buscarA.setActionCommand("buscarA");
		buscar.add(buscarA);
		
		buscarU= new JMenuItem(lang.getString("buscarUniversidad"));
		buscarU.addActionListener(this);
		buscarU.setActionCommand("buscarU");
		buscar.add(buscarU);
		
		barra.add(buscar);
		
		
		mnu2=new JMenu(lang.getString("Idiomas"));
		JMenuItem mnuEN= new JMenuItem("EN");
		mnuEN.addActionListener(this);
		mnuEN.setActionCommand("mnuEN");
		mnu2.add(mnuEN);
		
		JMenuItem mnuES= new JMenuItem("ES");
		mnuES.addActionListener(this);
		mnuES.setActionCommand("mnuES");
		mnu2.add(mnuES);
		
		barra.add(mnu2);
		
		///getContentPane().add(barra); error
		setJMenuBar(barra);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String comando = e.getActionCommand();
		System.out.println("Eventos  " + comando);
		
		switch (comando) {
		case "mnuVentana1":
			llamarDatoRector();
			break;
		case "mnuVentana2":
			llamarDatoUniversidad();
			break;
		case "mnuVentana3":
			llamarDatoCarrera();
			break;
		case "inscripcion":
			llamarInscripcion();
			break;
		case "mnuEN":
			cambiarIdioma("en","US");
			break;
		case "mnuES":
			cambiarIdioma("es","EC");
			break;
		case "listado":
			llamarListadoU();
			break;
		case "listadoA":
			llamarListadoA();
			break;
		case "listaI":
			listadoI();
			break;
		case "buscarA":
			llamarBuscarAspirante();
			break;
		case "buscarU":
			llamarBuscarU();
			break;
		case "mnuSalir":
			salir();
			break;
		default:
			break;
		}
	}

	private void cambiarIdioma(String lenguaje, String pais){
		localizacion=new Locale(lenguaje,pais);
		ResourceBundle lang= ResourceBundle.getBundle("Vista.mensajes",localizacion);
		setTitle(lang.getString("MisVentanas"));
		mnuVentanas.setText(lang.getString("Archivo"));
		mnu2.setText(lang.getString("Idiomas"));
		mnuVentana1.setText(lang.getString("DatoAspirante"));
		mnuVentana2.setText(lang.getString("DatoUniversidad"));
		mnuVentana3.setText(lang.getString("DatoCarrera"));
		mnuVentana5.setText(lang.getString("inscripcion"));
		listados.setText(lang.getString("Listas"));
		listadoU.setText(lang.getString("listasUniversidad"));
		listadoA.setText(lang.getString("listasAspirante"));
		listadoI.setText(lang.getString("listaInscripcion"));
		buscar.setText(lang.getString("buscar"));
		buscarA.setText(lang.getString("buscarAspirante"));
		buscarU.setText(lang.getString("buscarUniversidad"));
		
	}
	private void llamarDatoRector() {
		DatoRector dr= new DatoRector(gd);
		dr.setVisible(true);
		escritorio.add(dr);
		try {
			dr.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
	}
	public void llamarDatoUniversidad(){
		DatoUniversidad du= new DatoUniversidad(gd);
		du.setVisible(true);
		escritorio.add(du);
		try {
			du.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void llamarDatoCarrera(){
		DatoCarrera dc= new DatoCarrera(gd);
		dc.setVisible(true);
		escritorio.add(dc);
		try {
			dc.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	
	}
	public void llamarListadoU(){
		JTableUniversidad ju= new JTableUniversidad(gd);
		ju.setVisible(true);
		escritorio.add(ju);
		try {
			ju.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	public void llamarListadoA(){
		VentanaTablaASP ta= new VentanaTablaASP(gd);
		ta.setVisible(true);
		escritorio.add(ta);
		try {
			ta.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	public void llamarBuscarAspirante(){
		BuscarAspirante ba= new BuscarAspirante(gd);
		ba.setVisible(true);
		escritorio.add(ba);
		try {
			ba.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	public void llamarInscripcion(){
		DatoInscripcion in= new DatoInscripcion(gd);
		in.setVisible(true);
		escritorio.add(in);
		try {
			in.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	public void llamarBuscarU(){
		BuscarUniversidad_Carrera bu= new BuscarUniversidad_Carrera(gd);
		bu.setVisible(true);
		escritorio.add(bu);
		try {
			bu.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	public void listadoI(){
		VentanaTablaIns in= new VentanaTablaIns(gd);
		in.setVisible(true);
		escritorio.add(in);
		try {
			in.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	public void salir(){
		System.exit(0);
	}

}
