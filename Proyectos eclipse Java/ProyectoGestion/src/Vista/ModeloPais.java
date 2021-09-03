package Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Logica.Pais;
import Logica.Region;

public class ModeloPais extends AbstractTableModel {
	
	public String[] columnas={"Codigo", "Nombre", "Codigo Region"};
	public Class[] columnasTipos={ String.class, String.class, String.class };
	private List<Pais> datos;
	
	public ModeloPais() {
		super();
		datos = new ArrayList<Pais>();
	}
	public ModeloPais(List<Pais> datos) {
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
		Pais dato=(Pais)(datos.get(row));
		
		switch(col){
		case 0:
			dato.setCountry_id((String) value);;
			break;
		case 1:
			dato.setCountry_name((String) value);	
			break;
		case 2:
			dato.setRegion_id((int) value);
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
		
		Pais dato=(Pais)(datos.get(row));
		
		switch(col){
		case 0:
			return dato.getCountry_id();
		case 1:
			return dato.getCountry_name();
		case 2:
			return dato.getRegion_id();
			default:
				break;
		}
		
		return new String();
	}
}
