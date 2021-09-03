package Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tipos.Localidad;
import Tipos.Region;

public class ModeloLocalidad extends AbstractTableModel {

	public String[] columnas={"Codigo", "Address", "Codigo Postal","Ciudad","Provincia","Codigo Pais"};
	public Class[] columnasTipos={ String.class, String.class,String.class,String.class,String.class, String.class };
	private List<Localidad> datos;
	
	public ModeloLocalidad() {
		super();
		datos= new ArrayList<Localidad>();
	}
	public ModeloLocalidad(List<Localidad> datos) {
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
		Localidad dato=(Localidad)(datos.get(row));
		switch(col){
		case 0:
			dato.setLocation_id((int) value);
			break;
		case 1:
			dato.setStreet_address((String) value);
			break;
		case 2:
			dato.setPostal_code((String) value);
			break;
		case 3:
			dato.setCity((String) value);
			break;
		case 4:
			dato.setState_province((String) value);
			break;
		case 5:
			dato.setCountry_id((String) value);
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
		
		Localidad dato=(Localidad)(datos.get(row));
		switch(col){
		case 0:
			return dato.getLocation_id();
		case 1:
			return dato.getStreet_address();
		case 2:
			return dato.getPostal_code();
		case 3:
			return dato.getCity();
		case 4: 
			return dato.getState_province();
		case 5:
			return dato.getCountry_id();
			default:
				break;
		}
		
		return new String();
	}
}
