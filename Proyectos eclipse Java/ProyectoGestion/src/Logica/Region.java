package Logica;
/**
 * Esta clase nos permitira guardar los datos de la tabla de regions
 * en un objeto nos facilitaran al momento de manejar la informacion 
 * @author TOSHIBA
 *
 */
public class Region {
	/**
	 * Creamos las variables con los tipos de datos correspondientes en la tabla
	 */
	private int region_id;
	private String region_name;
	

	/**
	 * Generamos getters y setters 
	 * @return
	 */
	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	
	
	

}
