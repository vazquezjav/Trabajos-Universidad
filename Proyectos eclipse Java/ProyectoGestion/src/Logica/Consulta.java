package Logica;
import java.util.List;

import Conexion.Conexion;
import Logica.Localidad;
import Logica.Pais;
import Logica.Region;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
/**
 * En esta clase realizamos los correspondientes metodos que nos permitiran
 * realizar las diferentes operaciones con la conexion que accedera a las 
 * tablas locations, regions, countries 
 * @author TOSHIBA
 *
 */
public class Consulta {
/**
 * Creamos listas de tipo objetos , estas nos permitiran guardar la informacion
 * que despues utilizaremos para mostrarlas en la interfaz 
 */
	private List<Region> regiones;
	private List<Pais> paises;
	private List<Localidad> localidades;
	
/**
 * Para la conexion creamos variables que sean de tipo JDBC las cuales mediante 
 * esta libreria podran acceder a los datos de las tablas 
 */
	private PreparedStatement sentencia = null;
	private ResultSet resultado = null;

/**
 * Creamos un constructor donde inicializamos todas las variables 
 */
	public Consulta() {
		regiones = new ArrayList<Region>();
		paises = new ArrayList<Pais>();
		localidades =  new ArrayList<Localidad>();
	}
	/**
	 * Este metodo nos permitira consultar una region, para dicho procesos este metodo recibe como parametro
	 * la conexion con la base de datos y el codigo digitado por el cliente 
	 * @param con conexion con oracle 
	 * @param codigo codigo con el cual realizamos el quiery
	 */
	    public void ConsultarRegion(Conexion con, String codigo) {
	    	
	    	Region reg =  new Region();
	    	try {
	    		/**
	    		 * Realizamos el query que nos permitira obtener la inforamcion necesaria de la base 
	    		 */
				sentencia = con.getConexion().prepareStatement("SELECT * "
						+ "FROM hr.regions ");
				
//				sentencia.setString(1, codigo);
				resultado = sentencia.executeQuery();
				while(resultado.next()) {
					/**
					 * si no existe ningun inconvenieente con la conexion a la base
					 * los resultados obtenidos los guardamos en una lista 
					 */
					reg.setRegion_id(Integer.parseInt(resultado.getString("region_id")));
					reg.setRegion_name(resultado.getString("region_name"));
					
					regiones.add(reg);
				}
				} catch (SQLException e) {
				// TODO: handle exception
					e.printStackTrace();
			}
//	    	regiones.clear();
	    }
	    
	    
	    /**
	     * Este metodo nos permitira consultar los datos de la tabla countries,  para dicho procesos este metodo recibe como parametro
	     * la conexion con la base de datos y el codigo digitado por el cliente 
	     * @param con conexion con oracle 
	     * @param codigo codigo codigo con el cual realizamos el quiery
	     */
	    
	    public void ConsultarPaises(Conexion con, String codigo) {
	    	Pais pais= new Pais();
	    	try {
				sentencia = con.getConexion().prepareStatement("SELECT country_id, country_name, region_id "
						+"FROM hr.countries "
						+"WHERE country_id = ? ");
				sentencia.setString(1, codigo);
				resultado = sentencia.executeQuery();
				while(resultado.next()) {
					
					pais.setCountry_id(resultado.getString("country_id"));
					pais.setCountry_name(resultado.getString("country_name"));
					pais.setRegion_id(Integer.parseInt(resultado.getString("region_id")));
					
					paises.add(pais);
					
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	    /**
	     * Este metodo nos permitira consultar los datos de la tabla locations,  para dicho procesos este metodo recibe como parametro
	     * la conexion con la base de datos y el codigo digitado por el cliente 
	     * @param con conexion con oracle 
	     * @param codigo codigo codigo con el cual realizamos el quiery
	     */
	    public void ConsultarLacalidades(Conexion con, String codigo) {
	    	Localidad loc =  new Localidad();
	    	try {
	    		/**
	    		 * Realizamos el query que nos permitira obtener la inforamcion necesaria de la base 
	    		 */
				sentencia = con.getConexion().prepareStatement("SELECT location_id, city, state_province,street_address,postal_code, country_id "
						+"FROM hr.locations "
						+"WHERE location_id = ? ");
				sentencia.setString(1, codigo);
				resultado = sentencia.executeQuery();
				while(resultado.next()) {
					
					
					loc.setLocation_id(Integer.parseInt(resultado.getString("location_id")));
					loc.setStreet_address(resultado.getString("street_address"));
					loc.setPostal_code(resultado.getString("postal_code"));
					loc.setState_province(resultado.getString("state_province"));
					loc.setCity(resultado.getString("city"));
					loc.setCountry_id(resultado.getString("country_id"));
					
					localidades.add(loc);
					
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	    /**
	     * Este metodo nos permitira insertar nuevos datos en la tabla, los mismos  que recibiran los nuevos datos 
	     * agregados por el cliente, el codigo que recibira sera de tipo numerico y el nombre un texto 
	     * @param con
	     * @param codigo codigo codigo con el cual realizamos el quiery
	     */
	    public void insertarRegion(Conexion con, int codigo, String nombre) {
	    	try {
	    		/**
	    		 * Realizamos el query que nos permitira obtener la inforamcion necesaria de la base 
	    		 */
	    		sentencia = con.getConexion().prepareStatement("INSERT INTO regions(region_id, region_name)"
	    				+"VALUES(?,?)");
	    		sentencia.setInt(1, codigo);
	    		sentencia.setString(2, nombre);
	    		/**
	    		 * permite ralizar la actualizacion de la tabla, con las nuavas modificaciones hechas
	    		 */
	    		sentencia.executeUpdate();
	    		System.out.println("insertado");
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	
	    }
	    /**
	     * Este metodo nos permitira los nuevos datos en la tabla countries, este metodo cambia al recibir los parametros 
	     * por que el codigo es de tipo texto y el nombre tambien, este inserccion necesita un parametro de conexion 
	     * con la tabla de tabla de riogions
	     * @param con
	     * @param codigo codigo codigo con el cual realizamos el quiery
	     */
	    public void insertarPais(Conexion con, String codigo, String nombre, int codigoR) {
	    	try {
	    		/**
	    		 * Realizamos el query que nos permitira obtener la inforamcion necesaria de la base 
	    		 */
	    		sentencia = con.getConexion().prepareStatement("INSERT INTO countries(country_id, country_name, region_id)"
	    				+"VALUES(?,?,?)");
	    		sentencia.setString(1, codigo);
	    		sentencia.setString(2, nombre);
	    		sentencia.setInt(3, codigoR);
	    		/**
	    		 * permite ralizar la actualizacion de la tabla, con las nuavas modificaciones hechas
	    		 */
	    		sentencia.executeUpdate();
	    		System.out.println("insertado");
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	    /**
	     * Este metodo nos permitira los nuevos datos en la tabla locations, recibe de parametros el codigo numerico 
	     * y los demas parametros las calle, el codigo postal, la ciudad, la provincia y el codigo del pais 
	     * son de tipo texto, este metodo necesita un codigo que permita relacionarce con la tabla de countries 
	     * 
	     * @param con
	     * @param codigo codigo codigo con el cual realizamos el quiery
	     */
	    public void insertarLocalidad(Conexion con, int location_id, String street_address, String postal_code, String city, String state_province, String country_id) {
	    	try {
	    		/**
	    		 * Realizamos el query que nos permitira obtener la inforamcion necesaria de la base 
	    		 */
	    		sentencia = con.getConexion().prepareStatement("INSERT INTO locations(location_id,  street_address, postal_code, city, state_province, country_id)"
	    				+"VALUES(?,?,?,?,?,?)");
	    		sentencia.setInt(1, location_id);
	    		sentencia.setString(2, street_address);
	    		sentencia.setString(3, postal_code);
	    		sentencia.setString(4, city);
	    		sentencia.setString(5, state_province);
	    		sentencia.setString(6, country_id);/**
	    		 * permite ralizar la actualizacion de la tabla, con las nuavas modificaciones hechas
	    		 */
	    		sentencia.executeUpdate();
	    		System.out.println("insertado");
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	   
	    /**
	     * Este metodo nos ayuda a borrar los datos que se encuentran en la tabla de regions
	     * con el codigo que ingresa el usuario permitira realizar el metodo 
	     * @param con
	     * @param codigo codigo codigo con el cual realizamos el quiery
	     */
	    public void borrarRegion(Conexion con, int codigo) {
	    	try {
	    		/**
	    		 * Realizamos el query que nos permitira obtener la inforamcion necesaria de la base 
	    		 */
	    		sentencia = con.getConexion().prepareStatement("DELETE FROM regions WHERE region_id = ? ");
	    		
	    		sentencia.setInt(1, codigo);
	    		
	    		/**
	    		 * permite ralizar la actualizacion de la tabla, con las nuavas modificaciones hechas
	    		 */
	    		sentencia.executeUpdate();
	    		System.out.println("borrado");
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	
	    }
	    
	    public void borrarPais(Conexion con, String codigo) {
	    	try {
	    		/**
	    		 * Realizamos el query que nos permitira obtener la inforamcion necesaria de la base 
	    		 */
	    		sentencia = con.getConexion().prepareStatement("DELETE FROM countries WHERE country_id = ? ");
	    		
	    		sentencia.setString(1, codigo);
	    		sentencia.executeUpdate();
	    		System.out.println("borrado");
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	    
	    public void borrarLocalidad(Conexion con, int codigo) {
	    	try {
	    		/**
	    		 * Realizamos el query que nos permitira obtener la inforamcion necesaria de la base 
	    		 */
	    		sentencia = con.getConexion().prepareStatement("DELETE FROM locations WHERE location_id = ? ");
	    		
	    		sentencia.setInt(1, codigo);
	    		sentencia.executeUpdate();
	    		System.out.println("borrado");
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	    
	    /**
	     * Este metodo nos permite actualizar los datos de la tabla locations, reciben como prametro una variable conexion de tipo Conexion 
	     * que nos permite ralizar la conexion a la base la cual nos permitira la operacion de actualizar, recibie tambien el codigo a consultar y los diferentes 
	     * parametros 
	     * @param con  conexion con oracle 
	     * @param location_id  codigo de locations 
	     * @param street_address calle de la localidad
	     * @param postal_code codigo postal 
	     * @param city ciudad a la que pertenece
	     * @param state_province provincia a la que pertenece 
	     * @param country_id codigo  codigo el cual se enlaza con los paises 
	     */
	    public void actualizarLocalidad(Conexion con,int location_id, String street_address, String postal_code, String city, String state_province, String country_id) {
	    	
	    	try {
	    		/**
	    		 * Realizamos el query que nos permitira obtener la inforamcion necesaria de la base 
	    		 */
	    		sentencia = con.getConexion().prepareStatement("UPDATE locations SET street_address= ?, postal_code= ?, city= ?, state_province= ?,  country_id= ?"
	    				+ "WHERE location_id = ?");
	    		sentencia.setString(1, street_address);
	    		sentencia.setString(2, postal_code);
	    		sentencia.setString(3, city);
	    		sentencia.setString(4, state_province);
	    		sentencia.setString(5, country_id);
	    		sentencia.setInt(6,location_id);
	    		
	    		/**
	    		 * permite ralizar la actualizacion de la tabla, con las nuavas modificaciones hechas
	    		 */
	    		sentencia.executeUpdate();
	    		
	    		System.out.println("actualizado");
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	    

	    /**
	     * Creamos los respectivos getters y setters que desde otras clases nos permitiran acceder 
	     * e insertar nueva informacion en las listas 
	     * @return
	     */
		public List<Region> getRegiones() {
			return regiones;
		}

		public List<Pais> getPaises() {
			return paises;
		}

		public List<Localidad> getLocalidades() {
			return localidades;
		}

		public void setRegiones(List<Region> regiones) {
			this.regiones = regiones;
		}

		public void setPaises(List<Pais> paises) {
			this.paises = paises;
		}

		public void setLocalidades(List<Localidad> localidades) {
			this.localidades = localidades;
		}
		
		


	    
	    
}
