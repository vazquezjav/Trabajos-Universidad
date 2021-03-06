import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import Conexion_Oracle;
public class Consultas {
	 
    private PreparedStatement sentencia = null;
    private ResultSet resultado = null;
    
    
    public void ConsultarEmployees(Conexion_Oracle con, String codigo){
        try{
            sentencia = con.getConexion().prepareStatement("SELECT first_name, last_name, email "
                    + "FROM hr.employees "
                    + "WHERE employee_id = "+codigo);
            sentencia.setString(1, codigo);
            sentencia.setString(2, codigo);
            resultado = sentencia.executeQuery();
            
            //presento el resultado
            
            while (resultado.next()){
                System.out.println("Empleado");
                System.out.println("First name: "+resultado.getString("first_name"));
                System.out.println("Last name: "+resultado.getString("last_name"));
                System.out.println("Email: "+resultado.getString("email"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            
        }
    }
    
}
