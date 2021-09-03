package estructura;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ordenamiento o= new ordenamiento();
		int p, inicio, fin,tiempo;
		String rep;
		Scanner l= new Scanner(System.in);
	do {
		System.out.println("Tamaña de del vector");
		int t=l.nextInt();
		int []vector= new int[t];
		o.leervector(vector);
		o.imprimirvector(vector);
		System.out.println(" ");
		System.out.println(" 1. Burbuja Ascendente");
		System.out.println("2. Burbuja Descendente");
		System.out.println("3. Inserccion Ascendente");
		System.out.println("4. Inserccion Descendente");
		System.out.println("5. Seleccion Ascendente");
		System.out.println("6. Seleccion Descendente");
		System.out.println("7. Salir");
		p=l.nextInt();
		switch (p) {
		case 1:
			System.out.println("Burbuja Ascendente");
			System.out.println("Vector original");
			o.imprimirvector(vector);
			System.out.println("");
			inicio=(int) System.currentTimeMillis();
			o.BurbujaAs(vector);
			fin=(int) System.currentTimeMillis();
			tiempo=fin-inicio;
			System.out.println("Tiempo en milesegundos: "+tiempo);
			break;
		case 2:
			System.out.println("Burbuja Descendente");
			System.out.println("Vector original");
			o.imprimirvector(vector);
			System.out.println(" ");
			inicio=(int) System.currentTimeMillis();
			o.BurbujaDes(vector);
			fin=(int) System.currentTimeMillis();
			tiempo=fin-inicio;
			System.out.println("Vector final");
			System.out.print(o.BurbujaDes(vector));
			System.out.println("Tiempo en milesegundos: "+tiempo);
			break;
		case 3:
			System.out.println("Insercion Ascendente");
			System.out.println("Vector original");
			o.imprimirvector(vector);
			inicio=(int) System.currentTimeMillis();
			o.InserccionAs(vector);
			fin=(int) System.currentTimeMillis();
			tiempo=fin-inicio;
			System.out.println("Tiempo en milesegundos: "+tiempo);
			break;
		case 4:
			System.out.println("Insercion Descendente");
			System.out.println("Vector original");
			o.imprimirvector(vector);
			inicio=(int) System.currentTimeMillis();
			o.InserccionDes(vector);
			fin=(int) System.currentTimeMillis();
			tiempo=fin-inicio;
			System.out.println("Tiempo en milesegundos : "+tiempo);
			break;
		case 5:
			System.out.println("Seleccion Ascendente");
			System.out.println("Vector original");
			o.imprimirvector(vector);
			System.out.println();
			inicio=(int) System.currentTimeMillis();
			o.seleccionAs(vector);
			break;
		case 6: 
		    System.out.println("Seleccion Descendente");
		    System.out.println("Vector original");
		    o.imprimirvector(vector);
		    System.out.println();
		    inicio=(int) System.currentTimeMillis();
		    o.seleccionDes(vector);
		    fin=(int) System.currentTimeMillis();
		    tiempo=fin-inicio;
		    System.out.println("Tiempo en milesegundos : "+tiempo);
		    break;
		case 7:
			  System.exit(0);
		    
		default:
			   System.out.println("\n Error digite solo del 1 al 7");
		}
		 System.out.println(" Desea repetir presione R ");
	rep=l.next();
	}while(rep.equals("R"));
	
	}

}
