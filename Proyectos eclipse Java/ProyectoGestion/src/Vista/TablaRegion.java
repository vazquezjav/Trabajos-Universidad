package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Conexion.Conexion;
import Logica.Consulta;
/**
 * Esta clase utilizamos para mostrar en una interfaz grafica los resultados 
 * de la consulta paara los datos de la region
 * @author TOSHIBA
 *
 */
public class TablaRegion extends JFrame {
/**
 * 
 */
	private Consulta con;
	private Conexion co;
	private JTable tblRegiones;
	/**
	 * Recibe como parametros una conexion con la base de datos 
	 * y un valor de tipo Consulta el cual nos permite acceder a los
	 * metodos de la clase Consulta 
	 * @param con
	 * @param co
	 */
	public TablaRegion(Consulta con, Conexion co) {
		
		this.con=con;
		this.co=co;
		/**
		 * Creamos la interfaz grafica con un JFrame 
		 */
		setSize(150,200); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        
        
        JPanel pnlTitulo = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("Consulta Region");
        pnlTitulo.add(lblTitulo);
        tblRegiones=new JTable();
        tblRegiones.setModel(new ModeloRegion());
        
        JScrollPane scrollPaneTabla = new JScrollPane(tblRegiones);

        getContentPane().add(pnlTitulo, BorderLayout.NORTH);
        getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);
    	
    		tblRegiones.setModel(new ModeloRegion(con.getRegiones()));
    		
//    		con.getRegiones().clear();
    		
    		
    		
	}
	

	
}
