//import logica.Consultas;
  	import java.sql.DriverManager;
    	import java.sql.Connection;
    	import java.sql.SQLException;
    
public class Ges {

 
    public static void main(String[] args) {
        // TODO code application logic here
   
//        Conexion_Oracle co = new Conexion_Oracle();
//        Consultas con = new Consultas();
//        
//        co.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
//        co.setUsername("hr");
//        co.setPassword("hr");
//        co.Conectar();
//        
//        if(co.getConexion() != null){
//            System.out.println("La base de ha conectado");
//            con.ConsultarEmployees(co, "105");
//            co.CerrarConexion();
//        }
//    }
  
    		
    			// TODO Auto-generated method stub
    			System.out.println("-------- Oracle JDBC Connection Testing ------");

    	        try {

    	            Class.forName("oracle.jdbc.driver.OracleDriver");

    	        } catch (ClassNotFoundException e) {

    	            System.out.println("Where is your Oracle JDBC Driver?");
    	            e.printStackTrace();
    	            return;

    	        }

    	        System.out.println("Oracle JDBC Driver Registered!");

    	        Connection connection = null;

    	        try {

    	            connection = DriverManager.getConnection(
    	                    "jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");

    	        } catch (SQLException e) {

    	            System.out.println("Connection Failed! Check output console");
    	            e.printStackTrace();
    	            return;

    	        }

    	        if (connection != null) {
    	            System.out.println("You made it, take control your database now!");
    	        } else {
    	            System.out.println("Failed to make connection!");
    	        }
    		}

    	}


