package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cliente extends JInternalFrame implements ActionListener {

	private JTextField txtnombre, txtcedula, txtmunicipio, txtdni, txtayuntamiento,txtcliente,txtdato1,txtdato2,txtdato3;
	private JLabel lnombre, lcedula, lmunicipio, ldni, layuntamiento,lcliente, ldato1,ldato2,ldato3;
	private JButton guardar, cerrar;
	private Parametros pr;
	
	public Cliente(String nombre, String cedula, String municipio,String dato1, String dato2, String dato3, Parametros pr,String valor) {
		
		this.pr=pr;
		txtnombre = new JTextField(10);
		txtcedula= new JTextField(10);
		txtmunicipio= new JTextField(10);
		
		txtdni= new JTextField(10);
		txtayuntamiento= new JTextField(10);
		txtcliente= new JTextField(10);
		txtdato1 = new JTextField(10);
		txtdato2 = new JTextField(10);
		txtdato3 = new JTextField(10);
		
		lnombre = new JLabel(" Nombre ");
		lcedula = new JLabel(" Cedula ");
		lmunicipio = new JLabel(" Municipio");
		
		ldato1= new JLabel(dato1);
		ldato2= new JLabel(dato2);
		ldato3= new JLabel(dato3);
		
		ldni= new JLabel(" DNI ");
		layuntamiento= new JLabel(" Ayuntamiento ");
		lcliente= new JLabel(" Cliente ");
		
		
		guardar= new JButton("Guardar");
		cerrar= new JButton("Cerrar");
		
		guardar.addActionListener(this);
		guardar.setActionCommand("guardar");
		
		cerrar.addActionListener(this);
		cerrar.setActionCommand("cerrar");
		
		if (nombre=="nombre" || cedula=="cedula" || municipio=="municipio" || cedula=="dni" || municipio=="ayuntamiento" || nombre=="cliente") {
						
			if (nombre == "nombre" && cedula == "cedula" && municipio == "municipio") {
				setTitle("Cliente");
				setSize(300, 200);

				JPanel pan = new JPanel();

				Container cp1 = getContentPane();

				pan.setLayout(new GridBagLayout());
				GridBagConstraints cp2 = new GridBagConstraints();

				cp2.gridx = 0;
				cp2.gridy = 0;
				pan.add(lcedula, cp2);
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 0;
				pan.add(txtcedula, cp2);

				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 1;
				pan.add(lnombre, cp2);

				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 1;
				pan.add(txtnombre, cp2);

				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 2;
				pan.add(lmunicipio, cp2);

				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 2;
				pan.add(txtmunicipio, cp2);

				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 4;
				pan.add(guardar, cp2);

				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 4;
				pan.add(cerrar, cp2);

				cp1.add(pan, BorderLayout.CENTER);
			}
			if (nombre == "nombre" && cedula == "" && municipio == "") {
				setTitle("Cliente");
				setSize(300, 100);

				JPanel pan = new JPanel();

				Container cp1 = getContentPane();

				pan.setLayout(new GridBagLayout());
				GridBagConstraints cp2 = new GridBagConstraints();

				cp2.gridx = 1;
				cp2.gridy = 0;
				pan.add(lnombre, cp2);
				cp2 = new GridBagConstraints();
				cp2.gridx = 2;
				cp2.gridy = 0;
				pan.add(txtnombre, cp2);
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 2;
				pan.add(guardar, cp2);

				cp2 = new GridBagConstraints();
				cp2.gridx = 2;
				cp2.gridy = 2;
				pan.add(cerrar, cp2);

				cp1.add(pan, BorderLayout.CENTER);
			}else{
				if(nombre=="cliente" && cedula=="" && municipio=="") {
					setTitle("Cliente");
					setSize(300, 100);

					JPanel pan = new JPanel();

					Container cp1 = getContentPane();

					pan.setLayout(new GridBagLayout());
					GridBagConstraints cp2 = new GridBagConstraints();

					cp2.gridx = 1;
					cp2.gridy = 0;
					pan.add(lcliente, cp2);
					cp2 = new GridBagConstraints();
					cp2.gridx = 2;
					cp2.gridy = 0;
					pan.add(txtcliente, cp2);
					cp2 = new GridBagConstraints();
					cp2.gridx = 1;
					cp2.gridy = 2;
					pan.add(guardar, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 2;
					cp2.gridy = 2;
					pan.add(cerrar, cp2);

					cp1.add(pan, BorderLayout.CENTER);
				}
			}
			if (cedula == "cedula" && nombre == "" && municipio == "") {
				setTitle("Cliente");
				setSize(300, 100);
				if (cedula == "cedula") {
					JPanel pan = new JPanel();

					Container cp1 = getContentPane();

					pan.setLayout(new GridBagLayout());
					GridBagConstraints cp2 = new GridBagConstraints();

					cp2.gridx = 1;
					cp2.gridy = 0;
					pan.add(lcedula, cp2);
					cp2 = new GridBagConstraints();
					cp2.gridx = 2;
					cp2.gridy = 0;
					pan.add(txtcedula, cp2);
					cp2 = new GridBagConstraints();
					cp2.gridx = 0;
					cp2.gridy = 2;
					pan.add(guardar, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 1;
					cp2.gridy = 2;
					pan.add(cerrar, cp2);

					cp1.add(pan, BorderLayout.CENTER);
				}
			} else {
//				
				if (cedula == "dni" && nombre == "" && municipio == "") {
					System.out.println("label");
					setTitle("Cliente");
					setSize(300, 100);
					JPanel pan = new JPanel();

					Container cp1 = getContentPane();

					pan.setLayout(new GridBagLayout());
					GridBagConstraints cp2 = new GridBagConstraints();

					cp2.gridx = 1;
					cp2.gridy = 0;
					pan.add(ldni, cp2);
					cp2 = new GridBagConstraints();
					cp2.gridx = 2;
					cp2.gridy = 0;
					pan.add(txtdni, cp2);
					cp2 = new GridBagConstraints();
					cp2.gridx = 1;
					cp2.gridy = 2;
					pan.add(guardar, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 2;
					cp2.gridy = 2;
					pan.add(cerrar, cp2);

					cp1.add(pan, BorderLayout.CENTER);
				}
			}
				
				if(municipio=="municipio" && nombre=="" && cedula=="") {
					setTitle("Cliente");
					setSize(300,100);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(lmunicipio
								, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 2;
						cp2.gridy = 0;
						pan.add(txtnombre, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 3;
						cp2.gridy = 2;
						pan.add(cerrar, cp2);

			
						cp1.add(pan, BorderLayout.CENTER);
				}else {
					System.out.println("no");
					if(municipio=="ayuntamiento" && nombre=="" && cedula=="") {
						
						setTitle("Cliente");
						setSize(300,100);
						
						 JPanel pan = new JPanel();

							Container cp1 = getContentPane();
							
							pan.setLayout(new GridBagLayout());
							GridBagConstraints cp2 = new GridBagConstraints();

							cp2.gridx = 1;
							cp2.gridy = 0;
							pan.add(layuntamiento, cp2);
							cp2 = new GridBagConstraints();
							cp2.gridx = 2;
							cp2.gridy = 0;
							pan.add(txtayuntamiento, cp2);
							cp2 = new GridBagConstraints();
							cp2.gridx = 1;
							cp2.gridy = 1;
							pan.add(guardar, cp2);
							
							cp2 = new GridBagConstraints();
							cp2.gridx = 2;
							cp2.gridy = 1;
							pan.add(cerrar, cp2);
							cp1.add(pan, BorderLayout.CENTER);
					}
				}
				if(nombre=="nombre" && cedula=="cedula" && municipio=="") {
					setTitle("Cliente");
					setSize(300,200);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 0;
						cp2.gridy = 0;
						pan.add(lnombre, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(txtnombre, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(lcedula, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 2;
						pan.add(txtcedula, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 3;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 3;
						pan.add(cerrar, cp2);

			
						cp1.add(pan, BorderLayout.CENTER);
			} else {
				if (nombre == "nombre" && cedula == "dni" && municipio == "") {
					setTitle("Cliente");
					setSize(300, 200);

					JPanel pan = new JPanel();

					Container cp1 = getContentPane();

					pan.setLayout(new GridBagLayout());
					GridBagConstraints cp2 = new GridBagConstraints();

					cp2.gridx = 0;
					cp2.gridy = 0;
					pan.add(lnombre, cp2);
					cp2 = new GridBagConstraints();
					cp2.gridx = 1;
					cp2.gridy = 0;
					pan.add(txtnombre, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 0;
					cp2.gridy = 2;
					pan.add(ldni, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 1;
					cp2.gridy = 2;
					pan.add(txtdni, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 0;
					cp2.gridy = 3;
					pan.add(guardar, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 1;
					cp2.gridy = 3;
					pan.add(cerrar, cp2);

					cp1.add(pan, BorderLayout.CENTER);
				}
			}

				if(nombre=="nombre" && cedula=="" && municipio=="municipio") {
					setTitle("Cliente");
					setSize(300,200);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 0;
						cp2.gridy = 0;
						pan.add(lnombre, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(txtnombre, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(lmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 2;
						pan.add(txtmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 3;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 3;
						pan.add(cerrar, cp2);

			
						cp1.add(pan, BorderLayout.CENTER);
				}else {
					if(nombre=="nombre" && cedula=="" && municipio =="ayuntamiento") {
						setTitle("Cliente");
						setSize(300,200);
						
						 JPanel pan = new JPanel();

							Container cp1 = getContentPane();
							
							pan.setLayout(new GridBagLayout());
							GridBagConstraints cp2 = new GridBagConstraints();

							cp2.gridx = 0;
							cp2.gridy = 0;
							pan.add(lnombre, cp2);
							cp2 = new GridBagConstraints();
							cp2.gridx = 1;
							cp2.gridy = 0;
							pan.add(txtnombre, cp2);
							
							cp2 = new GridBagConstraints();
							cp2.gridx = 0;
							cp2.gridy = 2;
							pan.add(layuntamiento, cp2);
							
							cp2 = new GridBagConstraints();
							cp2.gridx = 1;
							cp2.gridy = 2;
							pan.add(txtayuntamiento, cp2);
							
							cp2 = new GridBagConstraints();
							cp2.gridx = 0;
							cp2.gridy = 3;
							pan.add(guardar, cp2);
							
							cp2 = new GridBagConstraints();
							cp2.gridx = 1;
							cp2.gridy = 3;
							pan.add(cerrar, cp2);

				
							cp1.add(pan, BorderLayout.CENTER);
					}
				}
				
				if(nombre=="" && cedula=="cedula" && municipio=="municipio") {
					setTitle("Cliente");
					setSize(300,200);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 0;
						cp2.gridy = 0;
						pan.add(lcedula, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(txtcedula, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(lmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 2;
						pan.add(txtmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 3;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 3;
						pan.add(cerrar, cp2);

			
						cp1.add(pan, BorderLayout.CENTER);
					
				}else {
					if(nombre=="" && cedula=="cedula" && municipio=="ayuntamiento") {
						setTitle("Cliente");
						setSize(300,200);
						
						 JPanel pan = new JPanel();

							Container cp1 = getContentPane();
							
							pan.setLayout(new GridBagLayout());
							GridBagConstraints cp2 = new GridBagConstraints();

							cp2.gridx = 0;
							cp2.gridy = 0;
							pan.add(lcedula, cp2);
							cp2 = new GridBagConstraints();
							cp2.gridx = 1;
							cp2.gridy = 0;
							pan.add(txtcedula, cp2);
							
							cp2 = new GridBagConstraints();
							cp2.gridx = 0;
							cp2.gridy = 2;
							pan.add(layuntamiento, cp2);
							
							cp2 = new GridBagConstraints();
							cp2.gridx = 1;
							cp2.gridy = 2;
							pan.add(txtayuntamiento, cp2);
							
							cp2 = new GridBagConstraints();
							cp2.gridx = 0;
							cp2.gridy = 3;
							pan.add(guardar, cp2);
							
							cp2 = new GridBagConstraints();
							cp2.gridx = 1;
							cp2.gridy = 3;
							pan.add(cerrar, cp2);

				
							cp1.add(pan, BorderLayout.CENTER);
					}
				}
				if(nombre=="nombre" && cedula=="dni" && municipio=="ayuntamiento") {
					setTitle("Cliente");
					setSize(300, 200);

					JPanel pan = new JPanel();

					Container cp1 = getContentPane();

					pan.setLayout(new GridBagLayout());
					GridBagConstraints cp2 = new GridBagConstraints();

					cp2.gridx = 0;
					cp2.gridy = 0;
					pan.add(ldni, cp2);
					cp2 = new GridBagConstraints();
					cp2.gridx = 1;
					cp2.gridy = 0;
					pan.add(txtdni, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 0;
					cp2.gridy = 1;
					pan.add(lnombre, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 1;
					cp2.gridy = 1;
					pan.add(txtnombre, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 0;
					cp2.gridy = 2;
					pan.add(layuntamiento, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 1;
					cp2.gridy = 2;
					pan.add(txtayuntamiento, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 0;
					cp2.gridy = 4;
					pan.add(guardar, cp2);

					cp2 = new GridBagConstraints();
					cp2.gridx = 1;
					cp2.gridy = 4;
					pan.add(cerrar, cp2);

					cp1.add(pan, BorderLayout.CENTER);
				}
				
				if(nombre=="" && cedula=="dni" && municipio=="minicipio") {
					setTitle("Cliente");
					setSize(300,100);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 0;
						cp2.gridy = 0;
						pan.add(ldni, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(txtdni, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(lmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 2;
						pan.add(txtmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 3;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 3;
						pan.add(cerrar, cp2);

			
						cp1.add(pan, BorderLayout.CENTER);
				}
				
				if(nombre=="" && cedula=="dni" && municipio=="ayuntamiento") {
					setTitle("Cliente");
					setSize(300,200);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 0;
						cp2.gridy = 0;
						pan.add(ldni, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(txtdni, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(layuntamiento, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 2;
						pan.add(txtayuntamiento, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 3;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 3;
						pan.add(cerrar, cp2);

			
						cp1.add(pan, BorderLayout.CENTER);
				}
				
				if(nombre=="nombre" && cedula=="cedula" && municipio=="ayuntamiento") {
					setTitle("Cliente");
					setSize(300,200);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 0;
						cp2.gridy = 0;
						pan.add(lcedula, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(txtcedula, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(lnombre, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 2;
						pan.add(txtnombre, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 3;
						pan.add(layuntamiento, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 3;
						pan.add(txtayuntamiento, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 4;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 4;
						pan.add(cerrar, cp2);

			
						cp1.add(pan, BorderLayout.CENTER);
				}
				
				if(nombre=="cliente" && cedula=="dni" && municipio=="ayuntamiento") {
					setTitle("Cliente");
					setSize(300,200);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 0;
						cp2.gridy = 0;
						pan.add(ldni, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(txtdni, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(lcliente, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 2;
						pan.add(txtcliente, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 3;
						pan.add(layuntamiento, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 3;
						pan.add(txtayuntamiento, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 4;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 4;
						pan.add(cerrar, cp2);

			
						cp1.add(pan, BorderLayout.CENTER);
				}
				
				if(nombre=="nombre" && cedula=="dni" && municipio=="municipio") {
					setTitle("Cliente");
					setSize(300,200);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 0;
						cp2.gridy = 0;
						pan.add(ldni, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(txtdni, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(lnombre, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 2;
						pan.add(txtnombre, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 3;
						pan.add(lmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 3;
						pan.add(txtmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 4;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 4;
						pan.add(cerrar, cp2);

			
						cp1.add(pan, BorderLayout.CENTER);
				}
				
				if(nombre=="cliente" && cedula=="cedula" && municipio=="ayuntamiento") {
					setTitle("Cliente");
					setSize(300,200);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 0;
						cp2.gridy = 0;
						pan.add(lcedula, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(txtcedula, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(lcliente, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 2;
						pan.add(txtcliente, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 3;
						pan.add(layuntamiento, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 3;
						pan.add(txtayuntamiento, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 4;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 4;
						pan.add(cerrar, cp2);

			
						cp1.add(pan, BorderLayout.CENTER);
				}
				if(nombre=="cliente" && cedula=="cedula" && municipio=="municipio") {
					setTitle("Cliente");
					setSize(300,200);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 0;
						cp2.gridy = 0;
						pan.add(lcedula, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(txtcedula, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(lcliente, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 2;
						pan.add(txtcliente, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 3;
						pan.add(lmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 3;
						pan.add(txtmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 4;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 4;
						pan.add(cerrar, cp2);
						
						cp1.add(pan, BorderLayout.CENTER);
				}
				if(nombre=="cliente" && cedula=="dni" && municipio=="municipio") {
					setTitle("Cliente");
					setSize(300,200);
					
					 JPanel pan = new JPanel();

						Container cp1 = getContentPane();
						
						pan.setLayout(new GridBagLayout());
						GridBagConstraints cp2 = new GridBagConstraints();

						cp2.gridx = 0;
						cp2.gridy = 0;
						pan.add(ldni, cp2);
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 0;
						pan.add(txtdni, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 2;
						pan.add(lcliente, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 2;
						pan.add(txtcliente, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 3;
						pan.add(lmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 3;
						pan.add(txtmunicipio, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 0;
						cp2.gridy = 4;
						pan.add(guardar, cp2);
						
						cp2 = new GridBagConstraints();
						cp2.gridx = 1;
						cp2.gridy = 4;
						pan.add(cerrar, cp2);
						
						cp1.add(pan, BorderLayout.CENTER);
				}
			}
		if(nombre=="cliente" && cedula=="dni" && municipio=="") {
			setTitle("Cliente");
			setSize(300,200);
			
			 JPanel pan = new JPanel();

				Container cp1 = getContentPane();
				
				pan.setLayout(new GridBagLayout());
				GridBagConstraints cp2 = new GridBagConstraints();

				cp2.gridx = 0;
				cp2.gridy = 0;
				pan.add(ldni, cp2);
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 0;
				pan.add(txtdni, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 2;
				pan.add(lcliente, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 2;
				pan.add(txtcliente, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 3;
				pan.add(guardar, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 3;
				pan.add(cerrar, cp2);

	
				cp1.add(pan, BorderLayout.CENTER);
		}
		
		if(nombre=="cliente" && cedula=="" && municipio=="municipio") {
			setTitle("Cliente");
			setSize(300,200);
			
			 JPanel pan = new JPanel();

				Container cp1 = getContentPane();
				
				pan.setLayout(new GridBagLayout());
				GridBagConstraints cp2 = new GridBagConstraints();

				cp2.gridx = 0;
				cp2.gridy = 0;
				pan.add(lcliente, cp2);
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 0;
				pan.add(txtcliente, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 2;
				pan.add(lmunicipio, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 2;
				pan.add(txtmunicipio, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 3;
				pan.add(guardar, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 3;
				pan.add(cerrar, cp2);

	
				cp1.add(pan, BorderLayout.CENTER);
		}
		
		if(nombre=="cliente" && cedula=="" && municipio=="ayuntamiento") {
			setTitle("Cliente");
			setSize(300,200);
			
			 JPanel pan = new JPanel();

				Container cp1 = getContentPane();
				
				pan.setLayout(new GridBagLayout());
				GridBagConstraints cp2 = new GridBagConstraints();

				cp2.gridx = 0;
				cp2.gridy = 0;
				pan.add(lcliente, cp2);
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 0;
				pan.add(txtcliente, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 2;
				pan.add(layuntamiento, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 2;
				pan.add(txtayuntamiento, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 3;
				pan.add(guardar, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 3;
				pan.add(cerrar, cp2);

	
				cp1.add(pan, BorderLayout.CENTER);
		}
		if(nombre=="cliente" && cedula=="cedula" && municipio=="") {
			setTitle("Cliente");
			setSize(300,200);
			
			 JPanel pan = new JPanel();

				Container cp1 = getContentPane();
				
				pan.setLayout(new GridBagLayout());
				GridBagConstraints cp2 = new GridBagConstraints();

				cp2.gridx = 0;
				cp2.gridy = 0;
				pan.add(lcedula, cp2);
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 0;
				pan.add(txtcedula, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 2;
				pan.add(lcliente, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 2;
				pan.add(txtcliente, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 3;
				pan.add(guardar, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 3;
				pan.add(cerrar, cp2);

	
				cp1.add(pan, BorderLayout.CENTER);
		}
		if(nombre=="" && cedula=="dni" && municipio=="municipio") {
			setTitle("Cliente");
			setSize(300,200);
			
			 JPanel pan = new JPanel();

				Container cp1 = getContentPane();
				
				pan.setLayout(new GridBagLayout());
				GridBagConstraints cp2 = new GridBagConstraints();

				cp2.gridx = 0;
				cp2.gridy = 0;
				pan.add(ldni, cp2);
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 0;
				pan.add(txtdni, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 2;
				pan.add(lmunicipio, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 2;
				pan.add(txtmunicipio, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 3;
				pan.add(guardar, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 3;
				pan.add(cerrar, cp2);

	
				cp1.add(pan, BorderLayout.CENTER);
		}
		
		if(valor == "valor") {
			System.out.println("datos");
		if(dato1.length()!=0 || dato2.length()!=0 || dato3.length()!=0   ) {
			System.out.println("vacio");
			setTitle("Cliente");
			setSize(300,200);
			
			 JPanel pan = new JPanel();

				Container cp1 = getContentPane();
				
				pan.setLayout(new GridBagLayout());
				GridBagConstraints cp2 = new GridBagConstraints();
			if (dato1.length() != 0) {
				cp2.gridx = 0;
				cp2.gridy = 0;
				pan.add(ldato1, cp2);
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 0;
				pan.add(txtdato1, cp2);
				System.out.println("entra2");
			} else {
//
//				System.out.println("1");
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 0;
				pan.add(ldato2, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 0;
				pan.add(txtdato2, cp2);
			}
			if(dato2.length()!=0) {
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 2;
				pan.add(ldato2, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 2;
				pan.add(txtdato2, cp2);
			}else {
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 2;
				pan.add(ldato3, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 2;
				pan.add(txtdato3, cp2);
			}
			if(dato3.length()!=0) {
				cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 3;
				pan.add(ldato3, cp2);
				
				cp2 = new GridBagConstraints();
				cp2.gridx = 1;
				cp2.gridy = 3;
				pan.add(txtdato3, cp2);
			}else {
				
			}
			cp2 = new GridBagConstraints();
			cp2.gridx = 0;
			cp2.gridy = 4;
			pan.add(guardar, cp2);
			
			cp2 = new GridBagConstraints();
			cp2.gridx = 1;
			cp2.gridy = 4;
			pan.add(cerrar, cp2);
			
			cp1.add(pan, BorderLayout.CENTER);
			
		}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void dattos() {
		
	}

}
