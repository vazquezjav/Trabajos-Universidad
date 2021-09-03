package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.POA;

import Controlador.Gestion;
import Modelo.Aspirante;

public class BuscarAspirante extends JInternalFrame implements ActionListener{
	private JTextField txtnombre, txtapellido;
	private JLabel nombre, apellido;
	private JButton buscar;
	private JTextArea listado;
	private Gestion gd;
	private Aspirante aspirante;
	
	public void initComponents(){
		setTitle("BuscarParticipante");
		setSize(300,400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}
	public BuscarAspirante(Gestion gd){
		this.gd=gd;
		Locale localizacion=VentanaPrincipal.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("Vista.mensajes", localizacion);
		setSize(400,300);
		setTitle(lang.getString("aspirante"));
		txtnombre= new JTextField(10);
		txtapellido= new JTextField(10);
		nombre= new JLabel(lang.getString("nombre"));
		apellido= new JLabel(lang.getString("apellido"));
		listado= new JTextArea(3,15);
		buscar=new JButton(lang.getString("buscar"));
		
		
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
		pan.add(buscar,cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 3;
		pan.add(listado,cp2);
		
		buscar.addActionListener(this);
		buscar.setActionCommand("buscar");
		
		cp1.add(pan,BorderLayout.CENTER);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando=e.getActionCommand();
		switch(comando){
		case "buscar":
			buscarA();
			break;
				
		}
	}
	
	
	public void buscarA(){
		String a=txtapellido.getText().concat(txtnombre.getText());
		List<Aspirante> aspirantes= gd.getAspirantes();
		for(Aspirante aspirante: aspirantes){
			if(aspirante.getApellido().concat(aspirante.getNombre()).equals(a)){
				System.out.println("Encontrado");
				JOptionPane.showMessageDialog(this, "Participante Encontrado", "Info!!!",
						JOptionPane.INFORMATION_MESSAGE);
				listado.append("Carrera= "+aspirante.getCarrera()+"\n");
				
			}else{
				System.out.println("Estudiante no encontrado");
				JOptionPane.showMessageDialog(this, "Estudiante no Inscrito", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
