package Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tipos.Region;

public class ModeloRegion extends AbstractTableModel {
	

	public String[] columnas={"Codigo", "Nombre"};
	public Class[] columnasTipos={ String.class, String.class, };
	private List<Region> datos;
	
	public ModeloRegion() {
		super();
		datos= new ArrayList<Region>();
	}
	public ModeloRegion(List<Region> datos) {
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
		Region dato=(Region)(datos.get(row));
		switch(col){
		case 0:
			dato.setRegion_id((int)value);
			break;
		case 1:
			dato.setRegion_name((String) value);			
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
		
		Region dato=(Region)(datos.get(row));
		switch(col){
		case 0:
			return dato.getRegion_id();
		case 1:
			return dato.getRegion_name();
			default:
				break;
		}
		
		return new String();
	}
}
