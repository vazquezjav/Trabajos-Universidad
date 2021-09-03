import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import CLIPSJNI.*;
public class Conexion extends JFrame implements ActionListener {

    private JTextField pregunta;
    private JLabel pr1,pr2,pr3,pr4,pr5,pr6,pr7,pr8,pr9,pr10;
    private JButton guardar, cerrar;
    private JRadioButton pr1v,pr1f,pr2v,pr2f,pr3v,pr3f,pr4v,pr4f,pr5v,pr5f;
    private ButtonGroup gr1,gr2,gr3,gr4,gr5;
    
    private Environment clips;
    public Conexion(){
        initComponents();
        //clips = new Environment();
    }
    public void initComponents() {
		
		setTitle("Regresion Lineal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
                
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
                
                gr1=new ButtonGroup();
                gr2 = new ButtonGroup();
                gr3 = new ButtonGroup();
                gr4 = new ButtonGroup();
                gr5 = new ButtonGroup();
                
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
		
		pr1 = new JLabel("¿Cree que el día no tiene bastantes horas para todas las cosas que debería hacer?");
                pr2 = new JLabel("¿Siempre se mueve, camina o come con rapidez?");
                pr3 = new JLabel("¿Suele sentirse impaciente por el ritmo con el que se manejan los demás?");;
                pr4 = new JLabel("¿Suele decir “ajá”, “bien, bien” o frases así para apremiar a una persona a que acabe de decir lo que le está contando?");
                pr5 = new JLabel("¿Tiene tendencia a terminar las frases de otra persona cuando ella duda?");
                pr6 = new JLabel("¿Le irrita que el coche que circula delante suyo vaya a una velocidad que usted considera demasiado lenta?");
                pr7 = new JLabel("¿Considera molesto tener que hacer cola o esperar turno para conseguir una mesa en un restaurante?");
                pr8 = new JLabel("¿Le resulta intolerable observar cómo otras personas realizan tareas que usted sabe que puede hacer más rápido?");
                pr9 = new JLabel("¿Le impacienta verse obligado a realizar tareas repetitivas, como firmar papeles o lavar platos, que son necesarias pero que le impiden hacer las cosas que realmente le interesan?");
                pr10 = new JLabel(" ¿Lee a toda prisa?");
                
		guardar = new JButton("Continuar");
		
		guardar.addActionListener(this);
		guardar.setActionCommand("continuar");
		
		

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
		cp1.add(pan, BorderLayout.WEST);

	}
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	public void calcular() {
		
	}
}
