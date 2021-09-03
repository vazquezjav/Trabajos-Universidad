package Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tipos.HistoriaTrabajo;

public class ModeloHistoria extends AbstractTableModel {

	public String[] columnas = { "Codigo", "FechaInicio", "FechaFin", "CodigoTrabajo", "CodigoDepartamento" };
	public Class[] columnasTipos = { String.class, String.class, String.class, String.class, String.class };
	private List<HistoriaTrabajo> datos;

	public ModeloHistoria() {
		super();
		datos = new ArrayList<HistoriaTrabajo>();
	}

	public ModeloHistoria(List<HistoriaTrabajo> datos) {
		super();
		this.datos = datos;
	}

	public int getColumnCount() {
		return columnas.length;
	}

	public int getRowCount() {
		return datos.size();
	}

	public void setValueAt(Object value, int row, int col) {
		HistoriaTrabajo dato = (HistoriaTrabajo) (datos.get(row));
		switch (col) {
		case 0:
			dato.setEmployee_id((int) value);
			break;
		case 1:
			dato.setStart_date((String) value);
			break;
		case 2:
			dato.setEnd_date((String) value);
			break;
		case 3:
			dato.setJob_id((String) value);
			break;
		case 4:
			dato.setDepartment_id((int) value);
		default:
			break;
		}
	}

	public String getColumnName(int col) {
		return columnas[col];
	}

	public Class getColumnClass(int col) {
		return columnasTipos[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		HistoriaTrabajo dato = (HistoriaTrabajo) (datos.get(row));
		switch (col) {
		case 0:
			return dato.getEmployee_id();
		case 1:
			return dato.getStart_date();
		case 2:
			return dato.getEnd_date();
		case 3:
			return dato.getJob_id();
		case 4:
			return dato.getDepartment_id();
		default:
			break;
		}

		return new String();
	}
}
