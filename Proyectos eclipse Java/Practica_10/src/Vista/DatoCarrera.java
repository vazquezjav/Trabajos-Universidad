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
import java.util.Collections;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.Gestion;
import Modelo.Aspirante;
import Modelo.Carrera;
import Modelo.Universidad;

public class DatoCarrera  extends JInternalFrame implements ActionListener{
	
	private JTextField txtnombre;
	private JTextField txtmodalidad;
	private JTextField txtcodigo;
	private JLabel nombre;
	private JLabel modalidad;
	private JLabel codigo;
	private JButton guardar;
	private JButton limpiar;
	private JLabel nombreU;
	private JComboBox escojerU;
	private Universidad universidad;
	private Gestion gd;
	
	
	public DatoCarrera(Gestion gd){
		this.gd=gd;
		initComponents();
	}
	public void initComponents(){
		Locale localizacion=VentanaPrincipal.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("Vista.mensajes", localizacion);
		
		setSize(400,300);
		setTitle(lang.getString("aspirante"));
		
		//getContentPane().setLayout(new FlowLayout());
		
		txtnombre= new JTextField(10);
		txtmodalidad= new JTextField(10);
		txtcodigo= new JTextField(10);
		codigo= new JLabel(lang.getString("codigo"));
		nombre= new JLabel(lang.getString("nombre"));
		modalidad= new JLabel(lang.getString("modalidad"));
		guardar= new JButton(lang.getString("guardar"));
		limpiar=new JButton(lang.getString("limpiar"));

		escojerU= new JComboBox();
		buscarU();
		nombreU= new JLabel(lang.getString("universidad"));
		 
		JPanel pan = new JPanel();

		Container cp1 = getContentPane();

		pan.setLayout(new GridBagLayout());
		
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(nombreU, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;
		pan.add(escojerU, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 1;
		pan.add(nombre, cp2);
		
		
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 1;

		pan.add(txtnombre, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 2;
		pan.add(codigo,cp2);
		

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 2;
		pan.add(txtcodigo,cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 3;
		pan.add(modalidad,cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 3;
		pan.add(txtmodalidad,cp2);
		
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
			//System.out.println("entra");
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
	
	
	public void buscarU() {
		Vector mo = new Vector();
		List<Universidad> universidades =gd.getUniversidades();
		
		for(int i=0; i<universidades.size(); i++) {
			Universidad universidad = universidades.get(i);
			mo.addElement(universidad);			
		}
		escojerU = new JComboBox(mo);
		
	}

	public void guardar() throws  Exception{
//		try{
//			if(gd.validarNewCarrera(txtnombre.getText(), txtcodigo.getText(), txtmodalidad.getText(), (Universidad)escojerU.getSelectedItem())){
//				
//			}
//		}catch(Exception e){
//			JOptionPane.showMessageDialog(this, e.getMessage(), "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
//			e.printStackTrace();
//		}
		try{
			if(gd.validarCarrera(txtnombre.getText(),(Universidad)escojerU.getSelectedItem())){
			gd.agregarCarrera(txtnombre.getText(), txtmodalidad.getText(), txtcodigo.getText(),(Universidad)escojerU.getSelectedItem());
			JOptionPane.showMessageDialog(this, "Datos guardadps", "Mensaje de información", JOptionPane.INFORMATION_MESSAGE);
		    listar();
			}
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		}
		
	}
	public void salir(){
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea salir", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
		if(opcion==JOptionPane.YES_OPTION){
			System.exit(0);
		}
		if(opcion== JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(this, "Siga Trabajando","MSJ", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void limpiar(){
		txtnombre.setText("");
		txtmodalidad.setText("");
		txtcodigo.setText("");
	}
	public void listar(){
		List<Carrera> carreras = gd.getCarreras();
		   for(int i=0;i<carreras.size();i++){
			   Carrera car= carreras.get(i);
			   System.out.println("Nombre= "+car.getNombre()+" "+"Codigo= "+car.getCodigo()+" "+"Modalidad= " +car.getModalidad()+" "+"Universidad= "+car.getUniversidad());
			  
		   }
	}

}
