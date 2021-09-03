package Vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import Modelo.Aspirante;
import Modelo.Carrera;


public class TablaAspirante extends AbstractTableModel {

	Locale localizacion=VentanaPrincipal.localizacion;
	ResourceBundle lang= ResourceBundle.getBundle("Vista.mensajes",localizacion);
	
	public String[] columnas={lang.getString("nombre"),lang.getString("apellido"),lang.getString("cedula"),lang.getString("carrera")};
	public Class[] columnasTipos={ String.class, String.class,String.class,String.class};
	private List<Aspirante> datos;
	
	public TablaAspirante(){
		super();
		datos= new ArrayList<Aspirante>();
	}
	public TablaAspirante(List<Aspirante> datos){
		super();
		this.datos=datos;
	}
	
	
	public int getColumnCount() {
		return columnas.length;
	}


	public int getRowCount() {
		return datos.size();
	}
	public void setValueAt(int row, int col,Object value) {
		Aspirante dato=(Aspirante)(datos.get(row));
		switch(col){
		case 0:
			dato.setNombre((String) value);
			break;
		case 1:
			dato.setApellido((String) value);
			break;
		case 2:
			dato.setCedula((String) value);
			break;
		case 3:
			dato.setCarrera((Carrera) value);
			default:
			break;
		}
	}
	public String getColumnName(int col){
		return columnas[col];
	}
	public Class getColumnClass(int col){
		return columnasTipos[col];
	}
	@Override
	public Object getValueAt(int row, int col) {
		Aspirante dato=(Aspirante)(datos.get(row));
		switch(col){
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getApellido();
		case 2:
			return dato.getCedula();
		case 3:
			return dato.getCarrera();
			default:
				break;
		}
			
		return new String();
	}

}
