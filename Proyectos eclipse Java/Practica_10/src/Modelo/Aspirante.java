package Modelo;

import java.util.List;



public class Aspirante  extends Persona{
	private Carrera carrera;

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public String toString (){
		return nombre;
	}
	



}
