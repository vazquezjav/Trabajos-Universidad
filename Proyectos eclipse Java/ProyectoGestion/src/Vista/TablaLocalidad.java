package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Conexion.Conexion;
import Logica.Consulta;
/**
 * /**
 * Aqui generamos la interfaz grafica para las tablas que dan respuesta a la 
 * consulta realizada, devolviendo los datos de la base en forma de talbas 
 * Esta tabla es respcto a la tabla de locations en oracle 
 * 
 * @author TOSHIBA
 *
 */

public class TablaLocalidad extends JFrame {

	private Consulta con;
	private Conexion co;
	private JTable tblLocalidades;
	
	public TablaLocalidad(Consulta con, Conexion co) {
		this.con=con;
		this.co=co;
		setSize(150,200); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        
        JPanel pnlTitulo = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("Consulta Localidades");
        pnlTitulo.add(lblTitulo);
        tblLocalidades=new JTable();
        tblLocalidades.setModel(new ModeloRegion());
        JScrollPane scrollPaneTabla = new JScrollPane(tblLocalidades);
        getContentPane().add(pnlTitulo, BorderLayout.NORTH);
        getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);
        
        tblLocalidades.setModel(new ModeloLocalidad(con.getLocalidades()));
    	
        
	}
}
