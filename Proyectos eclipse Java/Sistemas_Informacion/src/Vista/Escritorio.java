package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Modelo.Datos;

public class Escritorio extends JFrame implements ActionListener {

	
	private JDesktopPane escritorio;
	private JMenu menu;
	private JMenuItem parametro, cliente;
	private Datos dt;
	private Parametros pr;
	
	public  Escritorio(Datos dt) {
		this.dt=dt;
		setSize(800,600);
		setTitle(" Parametrizacion ");
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();		
		getContentPane().add(escritorio, BorderLayout.CENTER);
		
		JMenuBar barra = new JMenuBar();
		menu = new JMenu(" Menu ");
		
		parametro = new JMenuItem(" Parametros ");
		parametro.addActionListener(this);
		parametro.setActionCommand("parametro");
		menu.add(parametro);
		
		cliente = new JMenuItem(" Cliente ");
		cliente.addActionListener(this);
		cliente.setActionCommand("cliente");
		menu.add(cliente);
		
		
		barra.add(menu);
		
		setJMenuBar(barra);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		switch (comando) {
		case "parametro":
			parametro();
			break;
		case "cliente":
			cliente();
			break;
		default :
			break;
		}
	}

	private void parametro() {
		// TODO Auto-generated method stub
		Parametros pr = new Parametros(dt);
		pr.setVisible(true);
		escritorio.add(pr);
		try {
			pr.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		this.pr=pr;
	}
	private void cliente() {
		// TODO Auto-generated method stub
		Cliente cl = new Cliente(dt.getNombre(),dt.getCedula(),dt.getMunicipio(),dt.getDato1(),dt.getDato2(),dt.getDato3(),pr,dt.getComprobar());
		cl.setVisible(true); 
		escritorio.add(cl);
		try {
			cl.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
