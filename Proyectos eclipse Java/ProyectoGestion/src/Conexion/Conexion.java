package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase permite realizar la conexion
 * con la base de datos, esta conexion tendra
 * acceso a las tablas de regions, locations y countries 
 * 
 * 
 * @author TOSHIBA
 *
 */

public class Conexion {
	 private String username;
	    private String password;
	    private String url;
	    private Connection conexion = null;
	    
	    /**
	     * Este metodo realiza la conexion, mediante la libreria JDBC
	     */
	    public void Conectar(){
	        try{
	           this.setConexion(DriverManager.getConnection(this.getUrl(),this.getUsername(), this.getPassword()));
	        }
	        catch(SQLException e){
	            e.printStackTrace();
	        }
	    }
	    /**
	     * Generamos un metodo que nos permita cerrar la conexion con la base 
	     */
	    public void CerrarConexion(){
	        
	        try{
	            if(this.getConexion() != null && !this.getConexion().isClosed()){
	                this.getConexion().close();
	            }   
	        }
	        catch(SQLException e){
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Genramos los gettter y setter correspondientes 
	     * @return
	     */
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getUrl() {
	        return url;
	    }

	    public void setUrl(String url) {
	        this.url = url;
	    }

	    public Connection getConexion() {
	        return conexion;
	    }

	    public void setConexion(Connection conexion) {
	        this.conexion = conexion;
	    }
	        
}
