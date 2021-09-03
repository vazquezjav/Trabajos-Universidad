package Vista;

import Conexion.Conexion;
import Conexion.Conexion2;
import Logica.Consulta;
import Logica.ConsultaJob;

/**
 * Esta clase nos permite ccorrer el programa java
 * 
 * @author TOSHIBA
 *
 */
public class Main {

	/**
	 * En este metodo mandamos a llamar a las conexiones, con la maquina host y la
	 * conexion con la otra maquina mediante un ping ingresado y previamente
	 * configurado
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consulta con = new Consulta();
		Conexion co = new Conexion();

		Conexion2 con2 = new Conexion2();
		ConsultaJob cj = new ConsultaJob();
		co.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		co.setUsername("hr");
		co.setPassword("hr");

//	        
		con2.setUrl("jdbc:oracle:thin:@192.168.1.11:1521:XE");
		con2.setUsername("hr");
		con2.setPassword("hr");

		co.Conectar();
		con2.Conectar();

		if (co.getConexion() != null ) {
			System.out.println("La base de ha conectado exitosamente!");
			System.out.println("s");
			VentanaPrincipal vp = new VentanaPrincipal(con, co, cj, con2);
			vp.setVisible(true);

		}

	}

}
