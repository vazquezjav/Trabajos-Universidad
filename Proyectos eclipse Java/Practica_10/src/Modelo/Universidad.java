package Modelo;

public class Universidad {
	private String nombre;
	private String sede;
	private String direccion;
	private Rector rector;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Rector getRector() {
		return rector;
	}
	public void setRector(Rector rector) {
		this.rector = rector;
	}
	
	public String toString(){
		return nombre;
	}
		

}
