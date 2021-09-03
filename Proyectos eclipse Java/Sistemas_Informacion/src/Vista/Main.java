package Vista;

import Modelo.Datos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Parametros pr = new Parametros();
//		pr.setVisible(true);
		Datos dt =new Datos();
//		Parametros pr = new Parametros(dt);
		Escritorio es = new Escritorio(dt);
		es.setVisible(true);
	}

}
