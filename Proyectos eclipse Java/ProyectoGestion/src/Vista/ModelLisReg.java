package Vista;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Logica.Region;

public class ModelLisReg extends AbstractTableModel {
	public String[] columnas={"Codigo", "Nombre"};
	public Class[] columnasTipos={ String.class, String.class, };
	private List<Region> datos;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
