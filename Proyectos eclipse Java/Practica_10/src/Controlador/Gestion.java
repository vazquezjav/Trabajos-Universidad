package Controlador;

import java.beans.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Modelo.Aspirante;
import Modelo.Carrera;
import Modelo.Inscripcion;
import Modelo.Persona;
import Modelo.Rector;
import Modelo.Universidad;

public class Gestion {
	private List<Aspirante> aspirantes;
	private List<Universidad> universidades;
	private List<Carrera> carreras;
	private List<Rector> rectores;
	private List<Inscripcion> inscripciones;

	public Gestion() {
		aspirantes = new ArrayList<Aspirante>();
		universidades = new ArrayList<Universidad>();
		carreras = new ArrayList<Carrera>();
		rectores= new ArrayList<Rector>();
		inscripciones= new ArrayList<Inscripcion>();
	}

	public void agregarUniversidad(String nombre, String direccion, Rector rector, String sede){
		Universidad un= new Universidad();
		un.setNombre(nombre);
		un.setDireccion(direccion);
		un.setRector(rector);
		un.setSede(sede);
		
		universidades.add(un);
		
	}
	public void agregarCarrera(String nombre, String modalidad, String codigo, Universidad universidad){
		Carrera car= new Carrera();
		car.setCodigo(codigo);
		car.setModalidad(modalidad);
		car.setNombre(nombre);
		car.setUniversidad(universidad);
		
		carreras.add(car);
		
		
		
	}
	
	public void agregarRector(String nombre, String apellido, String cedula){
		Rector rec= new Rector();
		rec.setApellido(apellido);
		rec.setNombre(nombre);
		rec.setCedula(cedula);
		
		rectores.add(rec);
	}

	public void agregarInscripcion(String nombre, String apellido,String cedula, Carrera carrera, Universidad universidad){
		Inscripcion in= new Inscripcion();
		in.setCarrera(carrera);
		in.setUniversidad(universidad);
		
		Aspirante as= new Aspirante();
		as.setApellido(apellido);
		as.setNombre(nombre);
		as.setCedula(cedula);
		as.setCarrera(carrera);
		aspirantes.add(as);
		
		in.setAspirante(as);
		
		inscripciones.add(in);
		
	}
	public List<Aspirante> getAspirantes() {
		return aspirantes;
	}

	public List<Universidad> getUniversidades() {
		return universidades;
	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public List<Rector> getRectores() {
		return rectores;

	}
	
	 public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}
	 
	 public boolean buscarA(String nombre,String apellido, String cedula, Carrera carrera)throws Exception{
			for (Aspirante as : aspirantes) {
			if (as.getApellido().equals(apellido) && as.getNombre().equals(nombre) && as.getCedula().equals(cedula)&&as.getCarrera().equals(carrera)) {
				return false;
			}
				try {
					if(false){
						throw new Exception("Estudiante ya esta inscrito ");
					}
				} catch (Exception e) {
					throw new Exception("no inscrito ");
				}
			}
		return true;
	}
//	 public boolean buscarA2(String nombre,String apellido, String cedula, Carrera carrera) throws Exception{
//		 try{
//			 
//		 }catch(Exception e){
//			 throw new Exception("Formato Incorrecto");
//		 }
////		 for (Aspirante as : aspirantes) {
////				if (as.getApellido().equals(apellido) && as.getNombre().equals(nombre) && as.getCedula().equals(cedula)&&as.getCarrera().equals(carrera)) {
////					return false;
////				}
////			}
//		 for(int i=0;i<aspirantes.size();i++){
//			 Aspirante as= aspirantes.get(i);
//			 if(as.getNombre().equals(nombre)&&as.getApellido().equals(apellido)&&as.getCedula().equals(cedula)&&as.getCarrera().equals(carrera)){
//				 return false;
//			 }
//			 
//		 }
//		 
//		 return true;
//	 }
//	public boolean validarUniversidad(String nombre) throws Exception{
//		int c=0;
//		if(universidades.size()>0){
//		for(int i=0;i<universidades.size();i++){
//			if(nombre.equals(universidades.get(i).getNombre())){
//				c++;
//			}
//		}
//		if(c>0){
//			throw new Exception("Esta universidad ya fue registrada");
//		}
//		}
//		return true;
//	}
	
	public boolean validarUniversidad2(String nombre) throws Exception{
		try{
			 
		 }catch(Exception e){
			 throw new Exception("Formato Incorrecto");
		 }
		for(int i=0;i<universidades.size();i++){
			if(nombre.equals(universidades.get(i).getNombre())){
				return false;
			}
		}
		return true;
		
	}
	
	
	public boolean validarCarrera(String nombre, Universidad nombreU) throws Exception{
		for(Carrera un: carreras){
			if(un.getNombre().equals(nombre)&&un.getUniversidad().equals(nombreU)){
				return false;
			}
			try{
				if(true){
					throw new Exception("Carrera ya se encuentra");
				}
				
			}catch(Exception e){
				throw new Exception("no inscrito");
				}
			}
		return true;
	}
//	public boolean validarCarrera2(String nombre, Universidad nombreU) throws Exception{
//		int g=0;
//		if(carreras.size()>=0){
//		for(int i=0;i<carreras.size();i++){
//		
//			if(nombre.equals(carreras.get(i).getNombre())&& nombreU.equals(carreras.get(i).getUniversidad())){
//				g++;
//			}
//			}
//		if(g>0){
//			throw new Exception("Esta carrera ya fue registrada");
//		}
//		}
//		return true;
//	}
	
	public Aspirante buscarUniversidad(String nombreU, String nombreC){
		for(int i=0;i<inscripciones.size();i++){
			if(nombreU.equals(inscripciones.get(i).getUniversidad().getNombre())&& nombreC.equals(inscripciones.get(i).getCarrera().getNombre())){
				return inscripciones.get(i).getAspirante();
			}
			
		}
		return null;
		
	}

	public boolean validarCedula(String cedula) throws Exception{
		try {
			int a = Integer.parseInt(cedula);
		}catch(NumberFormatException e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(cedula.length()!=10)
			throw new Exception("Debe ser de 10 dígitos");
		
		return true;
	}
	
	
	public Universidad UniversidadB(String nombre){
		for(int i=0;i<universidades.size();i++){
			if(nombre.equals(universidades.get(i).getNombre())){
				return universidades.get(i);
			}
		}
		return null;
		
	}
	
	public boolean validarNewRector(String nombre, String apellido, String cedula) throws Exception{
		try{
			
		}catch(Exception e){
			throw new Exception("Formato Incorrecto");
		}
		if(nombre.equals("")||apellido.equals("")||cedula.equals("")){
                  return false;
		}
		return true;
	}
	public boolean validarNewCarrera(String nombre, String codigo, String modalidad, Universidad universidad) throws Exception{
		try{
			
		}catch(Exception e){
			throw new Exception("Formato Incorrecto");
		}
		if(nombre.equals("")|| modalidad.equals("")|| codigo.equals("")||universidad.equals("")){
			return false;
		}
		return true;
	}
	
	public boolean validarCupos(String nombreC, String nombreU) throws Exception{
		int cupos =2;
		if(inscripciones.size()>0){
			for(int i=0;i<inscripciones.size();i++){
				if(nombreC.equals(inscripciones.get(i).getCarrera().getNombre())&& nombreU.equals(inscripciones.get(i).getUniversidad().getNombre())){
					cupos--;
				}
			}
			if (cupos==0){
				throw new Exception("Los cupos de esta carrera se han agotado");
				
			}
		}
		return true;
	}
	
	
}
