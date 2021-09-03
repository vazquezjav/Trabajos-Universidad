/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_clips;

//import CLIPSJNI.Environment;
import net.sf.clipsrules.jni.Environment;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.management.Query.value;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import net.sf.clipsrules.jni.FactAddressValue;
import net.sf.clipsrules.jni.MultifieldValue;

/**
 *
 * @author TOSHIBA
 */
public class Nuv extends JFrame implements ActionListener {

    private JTextField nombre,genero;
    private JLabel pr1,pr2,pr3,pr4,pr5,pr6,pr7,pr8,pr9,pr10,lnombre,lgenero;
    private JButton guardar, cerrar;
    private JRadioButton pr1v,pr1f,pr2v,pr2f,pr3v,pr3f,pr4v,pr4f,pr5v,pr5f,
            pr6v,pr6f,pr7v,pr7f,pr8v,pr8f,pr9v,pr9f,pr10v,pr10f;
    private ButtonGroup gr1,gr2,gr3,gr4,gr5,gr6,gr7,gr8,gr9,gr10;
    
    
    private String resp1,resp2,resp3,resp4,resp5,resp6,resp7,resp8,resp9,resp10;
    
    private Environment clips;
    
    public Nuv(){
        initComponents();
        clips = new Environment();
        clips.load("reglas");
    }
    public void initComponents() {
		
		setTitle("Regresion Lineal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
                
                pr1v = new JRadioButton("Verdadero");
                pr1f = new JRadioButton("Falso");
                pr2v = new JRadioButton("Verdadero ");
                pr2f = new JRadioButton("Falso ");
                pr3v = new JRadioButton("Verdadero ");
                pr3f = new JRadioButton("Falso ");
                pr4v = new JRadioButton("Verdadero ");
                pr4f = new JRadioButton("Falso ");
                pr5v = new JRadioButton("Verdadero ");
                pr5f = new JRadioButton("Falso ");
                pr6v = new JRadioButton("Verdadero ");
                pr6f = new JRadioButton("Falso ");
                pr7v = new JRadioButton("Verdadero ");
                pr7f = new JRadioButton("Falso ");
                pr8v = new JRadioButton("Verdadero ");
                pr8f = new JRadioButton("Falso ");
                pr9v = new JRadioButton("Verdadero ");
                pr9f = new JRadioButton("Falso ");
                pr10v = new JRadioButton("Verdadero ");
                pr10f = new JRadioButton("Falso ");
                
                gr1=new ButtonGroup();
                gr2 = new ButtonGroup();
                gr3 = new ButtonGroup();
                gr4 = new ButtonGroup();
                gr5 = new ButtonGroup();
                gr6=new ButtonGroup();
                gr7 = new ButtonGroup();
                gr8 = new ButtonGroup();
                gr9 = new ButtonGroup();
                gr10 = new ButtonGroup();
                
                gr1.add(pr1v);
                gr1.add(pr1f);
                gr2.add(pr2v);
                gr2.add(pr2f);
                gr3.add(pr3v);
                gr3.add(pr3f);
                gr4.add(pr4v);
                gr4.add(pr4f);
                gr5.add(pr5v);
                gr5.add(pr5f);
                gr6.add(pr6v);
                gr6.add(pr6f);
                gr7.add(pr7v);
                gr7.add(pr7f);
                gr8.add(pr8v);
                gr8.add(pr8f);
                gr9.add(pr9v);
                gr9.add(pr9f);
                gr10.add(pr10v);
                gr10.add(pr10f);
		
		pr1 = new JLabel("1. ¿Cree que el día no tiene bastantes horas para todas las cosas que debería hacer?");
                pr2 = new JLabel("2. ¿Siempre se mueve, camina o come con rapidez?");
                pr3 = new JLabel("3. ¿Suele sentirse impaciente por el ritmo con el que se manejan los demás?");;
                pr4 = new JLabel("4. ¿Suele decir “ajá”, “bien, bien” o frases así para apremiar a una persona a que acabe de decir lo que le está contando?");
                pr5 = new JLabel("5. ¿Tiene tendencia a terminar las frases de otra persona cuando ella duda?");
                pr6 = new JLabel("6. ¿Le irrita que el coche que circula delante suyo vaya a una velocidad que usted considera demasiado lenta?");
                pr7 = new JLabel("7. ¿Considera molesto tener que hacer cola o esperar turno para conseguir una mesa en un restaurante?");
                pr8 = new JLabel("8. ¿Le resulta intolerable observar cómo otras personas realizan tareas que usted sabe que puede hacer más rápido?");
                pr9 = new JLabel("9. ¿Le impacienta verse obligado a realizar tareas repetitivas, como firmar papeles o lavar platos, que son necesarias pero que le impiden hacer las cosas que realmente le interesan?");
                pr10 = new JLabel("10. ¿Lee a toda prisa?");
                
                lnombre = new JLabel("Nombre");
                lgenero = new JLabel("Genero");
                
                nombre = new JTextField(10);
                genero = new JTextField(10);
                  
                
		guardar = new JButton("Calcular");
		
		guardar.addActionListener(this);
		guardar.setActionCommand("guardar");
		
		

		JPanel pan = new JPanel();

		Container cp1 = getContentPane();

		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(pr1, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 1;
		pan.add(pr1v, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 1;
		pan.add(pr1f, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 2;
		pan.add(pr2, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 3;
		pan.add(pr2v, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 3;
		pan.add(pr2f, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 4;
		pan.add(pr3, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 5;
		pan.add(pr3v, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 5;
		pan.add(pr3f, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 6;
		pan.add(pr4, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 7;
		pan.add(pr4v, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 7;
		pan.add(pr4f, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 8;
		pan.add(pr5, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 9;
		pan.add(pr5v, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 9;
		pan.add(pr5f, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 10;
		pan.add(pr6, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 11;
		pan.add(pr6v, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 11;
		pan.add(pr6f, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 12;
		pan.add(pr7, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 13;
		pan.add(pr7v, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 13;
		pan.add(pr7f, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 14;
		pan.add(pr8, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 15;
		pan.add(pr8v, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 15;
		pan.add(pr8f, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 16;
		pan.add(pr9, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 17;
		pan.add(pr9v, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 17;
		pan.add(pr9f, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 18;
		pan.add(pr10, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 19;
		pan.add(pr10v, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 19;
		pan.add(pr10f, cp2);
                cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 21;
		pan.add(guardar, cp2);
                
                
                JPanel pan3 = new JPanel();
			 pan3.setLayout(new GridBagLayout());
				GridBagConstraints cp4 = new GridBagConstraints();
				cp4.gridx = 0;
				cp4.gridy = 0;
				pan3.add(lnombre, cp4);
				cp4 = new GridBagConstraints();
				cp4.gridx = 1;
				cp4.gridy = 0;
				pan3.add(nombre, cp4);
				cp4 = new GridBagConstraints();
				cp4.gridx = 0;
				cp4.gridy = 1;
				pan3.add(lgenero, cp4);
				cp4 = new GridBagConstraints();
				cp4.gridx = 1;
				cp4.gridy = 1;
				pan3.add(genero, cp4);
			
			
			cp1.add(pan3, BorderLayout.NORTH);
                
                
		cp1.add(pan, BorderLayout.WEST);

	}
    @Override
	public void actionPerformed(ActionEvent evt) {
            String comando= evt.getActionCommand();
		switch(comando){
                    case "guardar":
                        calcular();
                        break;
                    default:
                        break;
                                
                }
        }

    
    public void calcular(){
        String nom = nombre.getText();
        String gen = genero.getText();
        clips.reset();
//        clips.eval("(bind ?*nombre* (str-cat ?*nombre* ped))");
//        clips.eval("(bind ?*genero* (str-cat ?*genero* gen))");
        if(pr1v.isSelected()){
            resp1="v";
        }else{
            if(pr1f.isSelected()){
                resp1="f";
            }
        }
        
        if(pr2v.isSelected()){
            resp2="v";
        }else{
            if(pr2f.isSelected()){
                resp2="f";
            }
        }
        
        if(pr3v.isSelected()){
            resp3="v";
        }else{
            if(pr3f.isSelected()){
                resp3="f";
            }
        }
        if(pr4v.isSelected()){
            resp4="v";
        }else{
            if(pr4f.isSelected()){
            resp4="f";
            }
        }
        if(pr5v.isSelected()){
            resp5="v";
        }else{
            if(pr5v.isSelected()){
                resp5="f";
            }
        }
        if(pr6v.isSelected()){
            resp6="v";
        }else{
            if(pr6f.isSelected()){
                resp6="f";
            }
        }
        if(pr7v.isSelected()){
            resp7="v";
        }else{
            if(pr7f.isSelected()){
                resp7="f";
            }
        }
        if(pr8v.isSelected()){
            resp8="v";
        }else{
            if(pr8f.isSelected()){
                resp8="f";
            }
        }
        if(pr9v.isSelected()){
            resp9="v";
        }else{
            if(pr9f.isSelected()){
                resp9="f";
            }
        }
        if(pr10v.isSelected()){
            resp10="v";
        }else{
            if(pr10f.isSelected()){
                resp10="f";
            }
        }
        //clips.assertString("(respuesta (nombre "+nom+") (genero "+gen+") (opcion "+resp1+resp2+resp3+resp4+resp5+resp6+resp7+resp8+resp9+resp10+")");
        String hecho = "(assert "
                + "(respuesta (nombre "+'"'+nom+'"'+")"
                + "(genero "+'"'+gen+'"'+")"
                + "(opcion "+resp1+" "+resp2+" "+resp3+" "+resp4+" "+resp5+" "+resp6+" "+resp7+" "+resp8+" "+resp9+" "+resp10 +")))";
        clips.eval(hecho);
        
        //clips.assertString("(persona (nombre "+nom+") (genero "+gen+"))");
        clips.run();
        String resp = clips.getInputBuffer();
        System.out.println(""+resp);
        String salto = System.getProperty("line.separator");
        //JOptionPane.showConfirmDialog(this, resp, "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(rootPane, resp);
        
        String resultado = "(find-all-facts((?v resultado)) TRUE)";
        FactAddressValue fv = (FactAddressValue) ((MultifieldValue) clips.eval(resultado)).get(0);
        try {
            String nombre = fv.getFactSlot("nombre").toString();
            String puntaje = fv.getFactSlot("puntaje").toString();
            String personalidad = fv.getFactSlot("personalidad").toString();
            
            JOptionPane.showMessageDialog(null,"Nombre: "+nombre+"\n"+"Puntaje: "+puntaje+"\n"+"Personalida: "+personalidad, "Resultados Personalidad",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
        }
        clips.destroy();
		
        //System.out.println(""+nom+gen+resp1+resp2+resp3+resp4+resp5);
    }
}
