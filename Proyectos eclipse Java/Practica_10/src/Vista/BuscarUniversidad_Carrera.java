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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controlador.Gestion;
import Modelo.Aspirante;
import Modelo.Carrera;
import Modelo.Inscripcion;
import Modelo.Persona;
import Modelo.Universidad;

public class BuscarUniversidad_Carrera extends JInternalFrame implements ActionListener {

	private JTextField txtuniversidad, txtcarrera;
	private JLabel universidad, carrera;
	private JButton buscar;
	private JTextArea listado;
	private Gestion gd;
	
	public void initComponents(){
		setTitle("BuscarParticipante");
		setSize(300,400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}
	public BuscarUniversidad_Carrera(Gestion gd){
		this.gd=gd;
		Locale localizacion=VentanaPrincipal.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("Vista.mensajes", localizacion);
		setSize(400,300);
		setTitle(lang.getString("buscar"));
		txtuniversidad= new JTextField(10);
		txtcarrera= new JTextField(10);
		universidad=new JLabel(lang.getString("universidad"));
		carrera= new JLabel(lang.getString("carrera"));
		buscar= new JButton(lang.getString("buscar"));
		listado= new JTextArea(3,15);
		

		JPanel pan = new JPanel();

		Container cp1 = getContentPane();

		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(universidad, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;

		pan.add(txtuniversidad, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 1;
		pan.add(carrera,cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 1;
		pan.add(txtcarrera,cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 2;
		pan.add(buscar,cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 3;
		pan.add(listado,cp2);
		
		buscar.addActionListener(this);
		buscar.setActionCommand("buscar1");
		
		cp1.add(pan,BorderLayout.CENTER);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando=e.getActionCommand();
		switch(comando){
		case "buscar1":
			System.out.println("entra");
			buscar();
			break;
				
		}
	}
	public void buscar(){
		String a= txtuniversidad.getText().concat(txtcarrera.getText());
		List<Inscripcion> inscripciones= gd.getInscripciones();
		for(Inscripcion inscripcion: inscripciones){
			if(inscripcion.getUniversidad().getNombre().equals(txtuniversidad)&&inscripcion.getCarrera().getNombre().equals(txtcarrera)){
				
					listado.append("Nombre= "+inscripcion.getAspirante()+"\n");
				
			}else{
				listado.append("No existe");
			}
		}

		
		
		
		gd.buscarUniversidad(txtuniversidad.getText(), txtcarrera.getText());
	listado.append("Aspirantes= ");
	}
	public void Buscar() {
		//Carrera carrera = (Carrera) listaCarrerasUni.getSelectedItem();

		List<Inscripcion> inscripcioness = gd.getInscripciones();

		for (int i = 0; i < inscripcioness.size(); i++) {
			Inscripcion incripciones = inscripcioness.get(i);

			if ((incripciones.getCarrera().equals(txtcarrera.getText()))) {

				listado.append("Apellidos y Nombres:" + incripciones.getAspirante().getApellido() + " "
						+ incripciones.getAspirante().getNombre() + "\n");

			} else {
				System.out.println("Estudiante no registrado");
				JOptionPane.showMessageDialog(this, "Estudiante no Inscrito", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
