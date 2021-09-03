package Vista;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tipos.Departamento;

public class ModeloDepartamento extends AbstractTableModel {

	public String[] columnas={"Codigo", "NombreDepartamento", "CodigoManager","CodigoLocalidad"};
	public Class[] columnasTipos={ String.class, String.class,String.class,String.class };
	private List<Departamento> datos;
	
	public ModeloDepartamento() {
		super();
		datos= new ArrayList<Departamento>();
	}
	public ModeloDepartamento(List<Departamento> datos) {
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
		Departamento dato=(Departamento)(datos.get(row));
		switch(col){
		case 0:
			dato.setDepartment_id((int)value);
			break;
		case 1:
			dato.setDepartment_name((String) value);
			break;
		case 2:
			dato.setManager_id((int) value);
			break;
		case 3:
			dato.setLocation_id((int) value);
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
		
		Departamento dato=(Departamento)(datos.get(row));
		switch(col){
		case 0:
			return dato.getDepartment_id();
		case 1:
			return dato.getDepartment_name();
		case 2:
			return dato.getManager_id();
		case 3:
			return dato.getLocation_id();
			default:
				break;
		}
		
		return new String();
	}
}

