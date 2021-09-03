package Vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import Modelo.Aspirante;
import Modelo.Carrera;

public class TablaBusqueda extends AbstractTableModel {

	Locale localizacion=VentanaPrincipal.localizacion;
	ResourceBundle lang= ResourceBundle.getBundle("Vista.mensajes",localizacion);
	
	public String []columnas={lang.getString("carrera")};
	public Class []columnasTipos={String.class};
	private List<Carrera> datos;
	
	public TablaBusqueda(){
		super();
		datos=new ArrayList<Carrera>();
		
	}
	public TablaBusqueda(List<Carrera> datos){
		super();
		this.datos=datos;
	}
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}
	public void setValueAt(int row, int col,Object value) {
		Carrera dato=(Carrera)(datos.get(row));
		switch(col){
		case 0:
			dato.setNombre((String) value);
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
		// TODO Auto-generated method stub
		Carrera dato=(Carrera)(datos.get(row));
		switch(col){
		case 0:
			return dato.getNombre();
			default:
				break;
		
	}
		return new String();
	}
}
