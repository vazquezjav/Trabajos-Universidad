package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Collections;

import Controlador.Gestion;

import Modelo.Rector;
import Modelo.Universidad;

public class DatoUniversidad extends JInternalFrame implements ActionListener {

	private JTextField txtnombre;
	private JTextField txtdireccion;
	private JTextField txtsede;
	private JLabel nombre;
	private JLabel direccion;
	private JLabel rector1;
	private JLabel sede;
	private JButton guardar;
	private JButton limpiar;
	private JComboBox escojerR;
	private Rector rector;
	
	private Gestion gd;
	
	public void initComponents(){

		setTitle("Competenciaa");
		setSize(300,400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
	
	}
	
	public  DatoUniversidad(Gestion gd){
		this.gd=gd;
		initComponents();

		Locale localizacion=VentanaPrincipal.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("Vista.mensajes", localizacion);
		
		
		setSize(400,300);
		setTitle(lang.getString("universidad"));
	
		txtnombre= new JTextField(10);
		txtdireccion= new JTextField(10);
	
		txtsede= new JTextField(10);
		sede= new JLabel(lang.getString("sede"));
		nombre= new JLabel(lang.getString("nombre"));
		direccion= new JLabel(lang.getString("direccion"));
		rector1= new JLabel(lang.getString("nombreRector"));
		guardar= new JButton(lang.getString("guardar"));
		limpiar=new JButton(lang.getString("limpiar"));
		
		escojerR=new JComboBox();
		buscarR();
		
		  JPanel pan = new JPanel();

			Container cp1 = getContentPane();

			pan.setLayout(new GridBagLayout());
			GridBagConstraints cp2 = new GridBagConstraints();
			cp2.gridx = 0;
			cp2.gridy = 0;
			pan.add(nombre, cp2);
			cp2 = new GridBagConstraints();
			cp2.gridx = 1;
			cp2.gridy = 0;

			pan.add(txtnombre, cp2);
			
			cp2 = new GridBagConstraints();
			cp2.gridx = 0;
			cp2.gridy = 1;
			pan.add(direccion,cp2);
			

			cp2 = new GridBagConstraints();
			cp2.gridx = 1;
			cp2.gridy = 1;
			pan.add(txtdireccion,cp2);

			cp2 = new GridBagConstraints();
			cp2.gridx = 0;
			cp2.gridy = 2;
			pan.add(rector1,cp2);

			cp2 = new GridBagConstraints();
			cp2.gridx = 1;
			cp2.gridy = 2;
			pan.add(escojerR,cp2);
			
			cp2 = new GridBagConstraints();
			cp2.gridx = 0;
			cp2.gridy = 3;
			pan.add(sede,cp2);
			
			cp2 = new GridBagConstraints();
			cp2.gridx = 1;
			cp2.gridy = 3;
			pan.add(txtsede,cp2);
			
			cp2 = new GridBagConstraints();
			cp2.gridx = 0;
			cp2.gridy = 4;
			pan.add(guardar,cp2);
			
			cp2 = new GridBagConstraints();
			cp2.gridx = 1;
			cp2.gridy = 4;
			pan.add(limpiar,cp2);
			
			cp1.add(pan,BorderLayout.CENTER);
			
			guardar.addActionListener(this);
			guardar.setActionCommand("btnGuardar");
			
			limpiar.addActionListener(this);
			limpiar.setActionCommand("btnLimpiar");
	
	}

	public void buscarR() {
		Vector mo = new Vector();
		List<Rector> rectores =gd.getRectores();
		for(int i=0; i<rectores.size(); i++) {
			Rector rector = rectores.get(i);
			mo.addElement(rector);			
		}
		escojerR = new JComboBox(mo);
		
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando= evt.getActionCommand();
		
		System.out.println("evento boton"+comando);
		switch(comando){
		case "btnSalir":
			salir();
			break;
		case "btnGuardar":
			try {
				guardar();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "btnLimpiar":
			limpiar();
			break;
		}
		
	}
	public void salir() {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea salir", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
		if(opcion==JOptionPane.YES_OPTION){
			System.exit(0);
		}
		if(opcion== JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(this, "Siga Trabajando","MSJ", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	public void guardar() throws  Exception {
		try{
				if(gd.validarUniversidad2(txtnombre.getText())){
					gd.agregarUniversidad(txtnombre.getText(), txtdireccion.getText(),(Rector)escojerR.getSelectedItem(), txtsede.getText());
					JOptionPane.showMessageDialog(this, "Datos guardados", 
							"Mensaje de información", JOptionPane.INFORMATION_MESSAGE);
				}
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(this, e.getMessage(), 
					"Mensaje de error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	public void limpiar() {
		txtnombre.setText("");
		txtdireccion.setText("");
		//txtrector.setText("");
		txtsede.setText("");
		
	}
	public void listar(){
		List<Universidad> universidades = gd.getUniversidades();
		  
		   for(int i=0;i<universidades.size();i++){
			  Universidad u= universidades.get(i);
			   System.out.println("Nombre: "+u.getNombre()+" "+"Direccion: "+u.getDireccion()+"Sede: "+u.getSede()+" "+"Rector: "+u.getRector());
			  
		   }
	}

}
