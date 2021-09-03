package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.Gestion;

import Modelo.Rector;

public class DatoRector extends JInternalFrame implements ActionListener {

	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtcedula;
	private JLabel nombre;
	private JLabel apellido;
	private JLabel cedula;
	private JButton guardar;
	private JButton limpiar;
	
	private Gestion gd;
	
	public void initComponents(){
		
		setTitle("Competenciaa");
		setSize(300,400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
		
	}
	
	
	public DatoRector(Gestion gd){
		this.gd=gd;
		initComponents();
		Locale localizacion=VentanaPrincipal.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("Vista.mensajes", localizacion);
		
		setSize(400,300);
		setTitle(lang.getString("rector"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txtnombre= new JTextField(10);
		txtapellido= new JTextField(10);
		txtcedula= new JTextField(10);
		cedula= new JLabel(lang.getString("cedula"));
		nombre= new JLabel(lang.getString("nombre"));
		apellido= new JLabel(lang.getString("apellido"));
		guardar= new JButton(lang.getString("guardar"));
		limpiar=new JButton(lang.getString("limpiar"));
		

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
			pan.add(guardar,cp2);
			
			cp2 = new GridBagConstraints();
			cp2.gridx = 1;
			cp2.gridy = 3;
			pan.add(limpiar,cp2);
		
			cp1.add(pan, BorderLayout.CENTER);
			
			
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
			guardar();
			break;
		case "btnLimpiar":
			limpiar();
			break;
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
	public void guardar(){
//		try{
//			if(gd.validarNewRector(txtnombre.getText(), txtapellido.getText(), txtcedula.getText())){
//				gd.agregarRector(txtnombre.getText(), txtapellido.getText(), txtcedula.getText());
//				
//			}
//			
//		}catch(Exception e){
//			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
//			e.printStackTrace();
//		}
		try{
			if(gd.validarCedula(txtcedula.getText())){
				//gd.agregarRector(txtnombre.getText(), txtapellido.getText(), txtcedula.getText());
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		}
		try{
			if(gd.validarCedula(txtcedula.getText())){
				gd.agregarRector(txtnombre.getText(), txtapellido.getText(), txtcedula.getText());
//				JOptionPane.showMessageDialog(this, "Mensaje de error", title, JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(this, "Guardado Corectamente ");
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		}
		
		listar();
		
	}
	public void listar(){
		   List<Rector> rectores = gd.getRectores();
		   
		   for(int i=0;i<rectores.size();i++){
			   Rector rec= rectores.get(i);
			   System.out.println(rec.getApellido()+" "+rec.getCedula()+" "+rec.getNombre());
			  
		   }
		
	}
	public void limpiar(){
		txtnombre.setText("");
		txtcedula.setText("");
		txtapellido.setText("");
	}

}