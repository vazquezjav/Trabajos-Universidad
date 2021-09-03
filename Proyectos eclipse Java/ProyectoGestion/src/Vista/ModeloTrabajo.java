package Vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Logica.Trabajo;

/**
 * Creamos esta clase que es en la cual se genera la tabla.
 * @author daniel
 *
 */

public class ModeloTrabajo extends AbstractTableModel {

	public String[] columnas = { "Codigo", "Titulo", "SalarioMinimo", "SalarioMaximo" };
	public Class[] columnasTipos = { String.class, String.class, String.class, String.class };
	private List<Trabajo> datos;

	public ModeloTrabajo() {
		super();
		datos = new ArrayList<Trabajo>();
	}

	public ModeloTrabajo(List<Trabajo> datos) {
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
		Trabajo dato = (Trabajo) (datos.get(row));
		switch (col) {
		case 0:
			dato.setJob_id((String) value);
			break;
		case 1:
			dato.setJob_title((String) value);
			break;
		case 2:
			dato.setMin_salary((int) value);
			break;
		case 3:
			dato.setMax_salary((int) value);
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

		Trabajo dato = (Trabajo) (datos.get(row));
		switch (col) {
		case 0:
			return dato.getJob_id();
		case 1:
			return dato.getJob_title();
		case 2:
			return dato.getMin_salary();
		case 3:
			return dato.getMax_salary();
		default:
			break;
		}

		return new String();
	}
}
