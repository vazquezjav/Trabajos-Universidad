package Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tipos.Empleado;

public class ModeloEmpleado extends AbstractTableModel {

	public String[] columnas = { "Codigo", "Nombre", "Apellido", "Email", "Numero", "FechaContrato", "CodigoTrabajo",
			"Salario", "Comision", "CodigoManager", "CodigoDepartamento" };
	public Class[] columnasTipos = { String.class, String.class, String.class, String.class, String.class, String.class,
			String.class, String.class, String.class, String.class, String.class };
	private List<Empleado> datos;

	public ModeloEmpleado() {
		super();
		datos = new ArrayList<Empleado>();
	}

	public ModeloEmpleado(List<Empleado> datos) {
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
		Empleado dato = (Empleado) (datos.get(row));
		switch (col) {
		case 0:
			dato.setEmployee_id((int) value);
			break;
		case 1:
			dato.setFirst_name((String) value);
			break;
		case 2:
			dato.setLast_name((String) value);
			break;
		case 3:
			dato.setEmail((String) value);
			break;
		case 4:
			dato.setPhone_number((String) value);
			break;
		case 5:
			dato.setHire_date((String) value);
			break;
		case 6:
			dato.setJob_id((String) value);
			break;
		case 7:
			dato.setSalary((int) value);
			break;
		case 8:
			dato.setCommission_pct((int) value);
			break;
		case 9:
			dato.setManager_id((int) value);
			break;
		case 10:
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

		Empleado dato = (Empleado) (datos.get(row));
		switch (col) {
		case 0:
			return dato.getEmployee_id();
		case 1:
			return dato.getFirst_name();
		case 2:
			return dato.getLast_name();
		case 3:
			return dato.getEmail();
		case 4:
			return dato.getPhone_number();
		case 5:
			return dato.getHire_date();
		case 6:
			return dato.getJob_id();
		case 7:
			return dato.getSalary();
		case 8:
			return dato.getCommission_pct();
		case 9:
			return dato.getManager_id();
		case 10:
			return dato.getDepartment_id();
		default:
			break;
		}

		return new String();
	}
}
