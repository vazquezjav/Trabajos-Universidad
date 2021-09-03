package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controlador.Gestion;

public class JTableUniversidad extends JInternalFrame implements ActionListener {

	private Gestion gd;
	private JTable tblUniversidades;
	
	public JTableUniversidad(Gestion gd){
		this.gd=gd;
		setSize(300,400);        
        getContentPane().setLayout(new BorderLayout());

        Locale localizacion=VentanaPrincipal.localizacion;
		ResourceBundle lang= ResourceBundle.getBundle("Vista.mensajes",localizacion);
		

        JPanel pnlTitulo = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel(lang.getString("listasUniversidad"));
        pnlTitulo.add(lblTitulo);
        
        tblUniversidades=new JTable();
        tblUniversidades.setModel(new ModeloUniversidad());

		JScrollPane scrollPaneTabla = new JScrollPane(tblUniversidades);

		JPanel pnlBotones = new JPanel(new FlowLayout());
		JButton btnCargar = new JButton(lang.getString("cargar"));
        btnCargar.setActionCommand("btnCargar");
        btnCargar.addActionListener(this);
        pnlBotones.add(btnCargar);
        JButton btnSalir = new JButton(lang.getString("salir"));
        btnSalir.setActionCommand("btnSalir");
        btnSalir.addActionListener(this);
        pnlBotones.add(btnSalir);

        getContentPane().add(pnlTitulo, BorderLayout.NORTH);
        getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);
        getContentPane().add(pnlBotones, BorderLayout.SOUTH);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        String comando = e.getActionCommand();
        
        switch(comando){
            case "btnSalir":
                salir();
                break;                
            case "btnCargar":
                cargarDatos();
                break;
            default:
                break;
        }
	}
	public void salir(){
		System.exit(0);
	}
	public void cargarDatos(){
		tblUniversidades.setModel(new ModeloUniversidad(gd.getUniversidades()));
		
	}

}
