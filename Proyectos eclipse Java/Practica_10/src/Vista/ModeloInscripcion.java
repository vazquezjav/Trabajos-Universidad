package Vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import Modelo.Aspirante;
import Modelo.Carrera;
import Modelo.Inscripcion;
import Modelo.Universidad;

public class ModeloInscripcion extends AbstractTableModel {
	Locale localizacion=VentanaPrincipal.localizacion;
	ResourceBundle lang= ResourceBundle.getBundle("Vista.mensajes",localizacion);
	

	public String[] columnas={lang.getString("nombre"),lang.getString("carrera"),lang.getString("universidad")};
	public Class[] columnasTipos={ String.class, String.class, String.class};
	private List<Inscripcion> datos;
	
	public ModeloInscripcion(){
		super();
		datos= new ArrayList<Inscripcion>();
	}
	public ModeloInscripcion(List<Inscripcion> datos){
		super();
		this.datos=datos;
	}
	
	
	public int getColumnCount() {
		return columnas.length;
	}

	public int getRowCount() {
		return datos.size();
	}

	public void setValueAt(Object value, int row, int col){
		Inscripcion dato=(Inscripcion)(datos.get(row));
		switch(col){
		case 0:
			dato.setAspirante(((Aspirante) value));
			break;
		case 1:
			dato.setCarrera((Carrera)value);;
			break;
		case 2:
			dato.setUniversidad((Universidad)value);;
			break;
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
		
		Inscripcion dato=(Inscripcion)(datos.get(row));
		switch(col){
		case 0:
			return dato.getAspirante();
		case 1:
			return dato.getCarrera();
		case 2:
			return dato.getUniversidad();
			default:
				break;
		}
		
		return new String();
	}

	
}
