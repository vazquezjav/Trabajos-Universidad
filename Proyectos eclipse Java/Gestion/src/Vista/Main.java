package Vista;

import Controlador.Conexion;
import Controlador.Consulta;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consulta con = new Consulta();
		Conexion co= new Conexion();
		 co.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	        co.setUsername("hr");
	        co.setPassword("hr");
	        
	        co.Conectar();
	        if(co.getConexion() != null){
	            System.out.println("La base se ha conectado exitosamente!");
	    		System.out.println("s");
	    		VentanaPrincipal vp = new VentanaPrincipal(con, co);
	    		vp.setVisible(true);   		
	        }
		
				
		
	}

}
