import javax.swing.JFrame;
import javax.xml.transform.Source;
import net.sourceforge.jFuzzyLogic.FIS;
public class InferenciaDifusa extends JFrame {

	//private net.sourceforge.jFuzzyLogic.FIS FIS;
	
	
	
	public InferenciaDifusa(){
		FIS fis = FIS.load("",true);
		setTitle("Inferencia Difusa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		
		//FIS = new net.sourceforge.jFuzzyLogic.FIS.load("ruta",true);
		
		FIS.setVariable("temperatura", 17.5);
		FIS.evaluate();
		
		double res = FIS.getVariable("velocidad").getLatestDefuzzifiedValue();
		System.out.println("Valor: "+res);
		initComponents();
	}
	
	public void initComponents() {
		javax.swing.JSlider sldTemp = new javax.swing.JSlider();
		sldTemp.setMaximum(400);
		sldTemp.setMinimum(0);
		sldTemp.setPaintTicks(true);
		sldTemp.setPaintLabels(true);
		sldTemp.setMajorTickSpacing(30);
		sldTemp.setMinorTickSpacing(10);
		
		sldTemp.addChangeListener(new javax.swing.event.ChangeEvent(arg0));;
	}
		
}
