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

public class TablaPais extends JFrame {

	private Consulta con;
	private Conexion co;
	private JTable tblPaises;
	
	public TablaPais(Consulta con, Conexion co) {
		this.con=con;
		this.co=co;
		setSize(300,200);  
        getContentPane().setLayout(new BorderLayout());
        JPanel pnlTitulo = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("Consulta Region");
        pnlTitulo.add(lblTitulo);
        tblPaises=new JTable();
        tblPaises.setModel(new ModeloRegion());
        
        JScrollPane scrollPaneTabla = new JScrollPane(tblPaises);

        getContentPane().add(pnlTitulo, BorderLayout.NORTH);
        getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);
        
      
        tblPaises.setModel(new ModeloPais(con.getPaises()));
        
	}
}
