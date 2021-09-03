package Vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import Modelo.Universidad;

public class ModeloUniversidad extends AbstractTableModel {
	Locale localizacion=VentanaPrincipal.localizacion;
	ResourceBundle lang= ResourceBundle.getBundle("Vista.mensajes",localizacion);
	
	public String[] columnas={lang.getString("nombre"),lang.getString("direccion"),lang.getString("sede"),lang.getString("rector")};
	public Class[] columnasTipos={ String.class, String.class, String.class,String.class};
	private List<Universidad> datos;
	
	public ModeloUniversidad(){
		super();
		datos= new ArrayList<Universidad>();
	}
	public ModeloUniversidad(List<Universidad> datos){
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
		Universidad dato=(Universidad)(datos.get(row));
		switch(col){
		case 0:
			dato.setNombre((String) value);
			break;
		case 1:
			dato.setDireccion((String) value);
			break;
		case 2:
			dato.setSede((String) value);
			break;
			default:
			break;
//		case 3:
//			dato.setRector((String) value);
//			break;
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
		
		Universidad dato=(Universidad)(datos.get(row));
		switch(col){
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getDireccion();
		case 2:
			return dato.getSede();
		case 3:
			return dato.getRector();
			default:
				break;
		}
		
		return new String();
	}

}
