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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.Gestion;
import Modelo.Aspirante;
import Modelo.Carrera;
import Modelo.Universidad;

public class DatoInscripcion extends JInternalFrame implements ActionListener{

	private JTextField txtnombre, txtapellido,txtcedula;
	private JLabel nombre, apellido,cedula, universidad, carrera;
	private JButton guardar, limpiar;
	private JComboBox escojerC, escojerU;
	private Gestion gd;
	
	public void initComponents(){
		setTitle("Inscripcion");
		setSize(300,400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}
	public DatoInscripcion(Gestion gd){
		this.gd=gd;
		Locale localizacion=VentanaPrincipal.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("Vista.mensajes", localizacion);
		
		setSize(400,300);
		setTitle("Aspirante");
		
		initComponents();
		txtnombre= new JTextField(10);
		txtapellido= new JTextField(10);
		nombre= new JLabel(lang.getString("nombre"));
		apellido= new JLabel(lang.getString("apellido"));
		universidad= new JLabel(lang.getString("universidad"));
		carrera=new JLabel(lang.getString("carrera"));
		txtcedula= new JTextField(10);
		cedula= new JLabel(lang.getString("cedula"));
		
		guardar= new JButton(lang.getString("guardar"));
		limpiar=new JButton(lang.getString("limpiar"));
		carrera=new JLabel(lang.getString("carrera"));
		escojerC= new JComboBox();
		buscarC();
		escojerU= new JComboBox();
		buscarU();
		
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
		pan.add(apellido,cp2);
		

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 1;
		pan.add(txtapellido,cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 2;
		pan.add(cedula,cp2);
		

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 2;
		pan.add(txtcedula,cp2);

		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 3;
		pan.add(universidad,cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 3;
		pan.add(escojerU,cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 4;
		pan.add(carrera,cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 4;
		pan.add(escojerC,cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 5;
		pan.add(guardar,cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 5;
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
			try {
				guardar();
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	public void guardar() throws HeadlessException, Exception{
		
		try{
			if(gd.validarCedula(txtcedula.getText())){
				//gd.agregarRector(txtnombre.getText(), txtapellido.getText(), txtcedula.getText());
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		}
		
		try{
			if(gd.buscarA(txtnombre.getText(), txtapellido.getText(), txtcedula.getText(),(Carrera)escojerC.getSelectedItem())){
				gd.agregarInscripcion(txtnombre.getText(), txtapellido.getText(),txtcedula.getText(), (Carrera)escojerC.getSelectedItem(), (Universidad)escojerU.getSelectedItem());
				JOptionPane.showMessageDialog(this, "Inscripcion Creada", 
						"Mensaje de información", JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(this, "Estudiante ya se encuentra inscrito en una carrera", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		}
		
		
	}
	public void listar(){
		List<Aspirante> aspirantes = gd.getAspirantes();
		
		for (int i = 0; i < aspirantes.size(); i++) {
			Aspirante as = aspirantes.get(i);
			System.out.println("Nombre= " + as.getNombre() + " " + "Apellido= " + as.getApellido() + " " + "Cedula= "
					+ as.getCedula() + " " + "Carrera:= " + as.getCarrera() + " ");

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

	
	public void buscarC(){
		Vector mo = new Vector();
		List<Carrera> carreras =gd.getCarreras();
		for(int i=0; i<carreras.size(); i++) {
			Carrera carrera = carreras.get(i);
			mo.addElement(carrera);			
		}
		escojerC = new JComboBox(mo);
	
	}
	public void limpiar(){
		txtnombre.setText("");
		txtapellido.setText("");
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
	
}
