package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

import Modelo.Datos;

public class Parametros extends JInternalFrame implements ActionListener{

	private JCheckBox cedula, nombre, municipio,dni,ayuntamiento;
	private JButton guardar, cerrar,guardarP;
	private JButton primero;
	private JRadioButton lcedula, ldni,lmunicipio, layuntamiento,lnombre,lcliente;
	private ButtonGroup  grupo,grupo3;
	private ButtonGroup grupo1;
	private JLabel parametro1, parametro2, parametro3;
	private JTextField txtparametro1, txtparametro2, txtparametro3,blanco;
	private Datos dt;
	private Container cp1;

	public void initComponents(){
		
		setTitle("Parametros");
		setSize(400,300);
		
	}
	
	public Parametros(Datos dt) {
		initComponents();
		this.dt=dt;
		
		grupo = new ButtonGroup();
		grupo1 = new ButtonGroup();
		grupo3= new ButtonGroup();
		
		nombre = new JCheckBox(" Nombre ", false);		
		municipio = new JCheckBox(" Municipio ", false);
		cedula = new JCheckBox(" Cedula ", false);
		
		lcedula = new JRadioButton(" Cedula ");
		ldni= new JRadioButton(" DNI ");
		layuntamiento = new JRadioButton(" Ayuntamiento ");
		lmunicipio = new JRadioButton(" Municipio");
		lnombre = new JRadioButton(" Nombre ");
		lcliente= new JRadioButton(" Cliente ");
		
		dni= new JCheckBox("DNI");
		ayuntamiento= new JCheckBox("Atuntamiento");
		
		
		parametro1 = new JLabel(" Parametro 1");
		parametro2 = new JLabel(" Parametro 2");
		parametro3 = new JLabel(" Parametro 3");
		
		txtparametro1 = new JTextField(10);
		txtparametro2 = new JTextField(10);
		txtparametro3 = new JTextField(10);
		blanco = new JTextField(10);
		
		guardar = new JButton(" Guardar Dato");
		cerrar = new JButton(" Cerrar ");
		primero= new JButton(" Guardar ");
		guardarP = new JButton(" Guardar");
		
		
		grupo.add(lcedula);
		grupo.add(ldni);
		
		grupo1.add(lmunicipio);
		grupo1.add(layuntamiento);
		
		grupo3.add(lnombre);
		grupo3.add(lcliente);
		guardarP.addActionListener(this);
		guardarP.setActionCommand("parametro");
		
		 JPanel pan2 = new JPanel();
		 
			 cp1 = getContentPane();
			 
			pan2.setLayout(new GridBagLayout());
			GridBagConstraints cp3 = new GridBagConstraints();
			cp3.gridx = 0;
			cp3.gridy = 0;
			pan2.add(lcedula, cp3);
			cp3 = new GridBagConstraints();
			cp3.gridx = 1;
			cp3.gridy = 0;
			pan2.add(ldni, cp3);
			
			cp3 = new GridBagConstraints();
			cp3.gridx = 0;
			cp3.gridy = 1;
			pan2.add(lmunicipio, cp3);
			
			cp3 = new GridBagConstraints();
			cp3.gridx = 1;
			cp3.gridy = 1;
			pan2.add(layuntamiento, cp3);
			
			cp3 = new GridBagConstraints();
			cp3.gridx = 0;
			cp3.gridy = 2;
			pan2.add(lnombre, cp3);
			
			cp3 = new GridBagConstraints();
			cp3.gridx = 1;
			cp3.gridy = 2;
			pan2.add(lcliente, cp3);
			
			cp3 = new GridBagConstraints();
			cp3.gridx = 0;
			cp3.gridy = 3;
			pan2.add(guardar, cp3);
			
		
			 JPanel pan3 = new JPanel();
			 pan3.setLayout(new GridBagLayout());
				GridBagConstraints cp4 = new GridBagConstraints();
				cp4.gridx = 0;
				cp4.gridy = 0;
				pan3.add(parametro1, cp4);
				cp4 = new GridBagConstraints();
				cp4.gridx = 1;
				cp4.gridy = 0;
				pan3.add(txtparametro1, cp4);
				cp4 = new GridBagConstraints();
				cp4.gridx = 0;
				cp4.gridy = 1;
				pan3.add(parametro2, cp4);
				cp4 = new GridBagConstraints();
				cp4.gridx = 1;
				cp4.gridy = 1;
				pan3.add(txtparametro2, cp4);
				cp4 = new GridBagConstraints();
				cp4.gridx = 0;
				cp4.gridy = 2;
				pan3.add(parametro3, cp4);
				cp4 = new GridBagConstraints();
				cp4.gridx = 1;
				cp4.gridy = 2;
				pan3.add(txtparametro3, cp4);
				cp4 = new GridBagConstraints();
				cp4.gridx = 0;
				cp4.gridy = 3;
				pan3.add(guardarP, cp4);
			
			
			
			cp1.add(pan2, BorderLayout.NORTH);
			cp1.add(pan3,BorderLayout.SOUTH);
//		componentes();
			
			guardar.addActionListener(this);
			guardar.setActionCommand("guardar");
			
			cerrar.addActionListener(this);
			cerrar.setActionCommand("cerrar");
			
			primero.addActionListener(this);
			primero.setActionCommand("primero");
			
			
			
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando= evt.getActionCommand();
		switch(comando){
		case "guardar":
			lcedula.setEnabled(false);
			ldni.setEnabled(false);
			lmunicipio.setEnabled(false);
			layuntamiento.setEnabled(false);
			guardar.setEnabled(false);
			lnombre.setEnabled(false);
			lcliente.setEnabled(false);

			if (lcedula.isSelected()) {
				dt.setCedula("cedula");
				System.out.println("Cedula");
			} else {
				if (ldni.isSelected()) {
					dt.setCedula("dni");
					System.out.println(" DNI ");
				}else {
				dt.setCedula("");
				}
			}

			if (lmunicipio.isSelected()) {
				dt.setMunicipio("municipio");
				System.out.println(" Municipio ");
			} else {
				if (layuntamiento.isSelected()) {
					dt.setMunicipio("ayuntamiento");
					System.out.println(" Ayuntamiento ");
				}else{
				dt.setMunicipio("");
			
				}
			}

			if (lnombre.isSelected()) {
				dt.setNombre("nombre");
				System.out.println(" Nombre ");
			} else {
				if (lcliente.isSelected()) {
					dt.setNombre("cliente");
					System.out.println(" Cliente ");
				} else {
					dt.setNombre("");
				}
			}
			if(lcliente.isSelected() || lnombre.isSelected() || lcedula.isSelected() || ldni.isSelected() || lmunicipio.isSelected() || layuntamiento.isSelected()) {
			dt.setComprobar("vacio");
			}else {
			}
			
			break;
		case "parametro":
			panel();
			break;
		case "cerrar":
			break;
			
		}
		
	}
	
	public void panel() {
		if(guardar.isSelected() ==false) {
			dt.setComprobar("valor");
		}
		dt.setDato1(txtparametro1.getText());
		dt.setDato2(txtparametro2.getText());
		dt.setDato3(txtparametro3.getText());
		txtparametro1.setEnabled(false);
		txtparametro2.setEnabled(false);
		txtparametro3.setEnabled(false);
		guardarP.setEnabled(false);
	}

	public JButton getGuardarP() {
		return guardarP;
	}

	public void setGuardarP(JButton guardarP) {
		this.guardarP = guardarP;
	}
	
	

}
