import java.util.Scanner;
public class Dinero {
	
	double a;
	void leer(){
	    Scanner sc=new Scanner(System.in);
	    System.out.print("Ingresa valor en $ a desglosar");
        a=sc.nextDouble();
	}
	int c,c1,v,d,c2,u,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
	void calcular(){
		//calculamos los billetes de 100$
		c=(int)a/100;
		//calculamos los billetes de 50$
		c1=(int)(a-(c*100))/50;
		//calculamos los billetes de 20$
		v=(int)(a-(c*100+c1*50))/20;
		//calculamos los billetes de 10$
		d=(int)(a-(c*100+c1*50+v*20))/10;
		//calculamos los billestes de 5$
		c2=(int)(a-(c*100+c1*50+v*20+d*10))/5;
		//calculamos los billestes de 1$
		u=(int)(a-(c*100+c1*50+v*20+d*10+c2*5))/1;
		//monedas de 50 cntvs
		double c3;
		c3=(double)(a-(c*100+c1*50+v*20+d*10+c2*5+u*1))*100;
		c4=(int)c3/50;
		//monedas de 25 cntvs
		float c11;
		c11=(float)(a-(c*100+c1*50+v*20+d*10+c2*5+u*1+c4*0.50))*100;
		c12=(int)c11/25;
		//monedas de 10 cntvs
		float c5;
		c5=(float)(a-(c*100+c1*50+v*20+d*10+c2*5+u*1+c4*0.50+c12*0.25))*100;
		c6=(int)c5/10;
		//monedas de 5 cntvs
		float c7;
		c7=(float)(a-(c*100+c1*50+v*20+d*10+c2*5+u*1+c4*0.5+c12*0.25+c6*0.10))*100;
		c8=(int)c7/5;
		//monedas de 1 cntv
		float c9;
		c9=(float)(a-(c*100+c1*50+v*20+d*10+c2*5+u*1+c4*0.5+c12*0.25+c6*0.10+c8*0.05))*100;
		c10=(int)c9/1;
		
		System.out.println("Hay"+" "  +c  +" "+"Billetes de 100$");
		System.out.println("Hay"+" "  +c1 +" "+ "Billetes de 50$");
		System.out.println("Hay"+" "  +v  +" "+ "Billetes de 20$");
		System.out.println("Hay"+" "  +d  +" "+ "Billetes de 10$");
		System.out.println("Hay"+" "  +c2  +" "+ "Billetes de 5$");
		System.out.println("Hay"+" "  +u  +" "+ "Billetes de 1$");
		System.out.println("Hay"+" "  +c4  +" "+ "monedas de 0.50$");
		System.out.println("Hay"+" "  +c12 +" "+ "monedas de 0.25$");
		System.out.println("Hay"+" "  +c6  +" "+ "monedas de 0.10$");
		System.out.println("Hay"+" "  +c8  +" "+ "monedas de 0.05$");
		System.out.println("Hay"+ " " +c10  +" "+ "monedas de 0.01$");

	}
}
	
	
	
 




