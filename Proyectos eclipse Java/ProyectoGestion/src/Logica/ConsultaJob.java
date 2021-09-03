package Logica;

/**
 * Importamos las distintas clases
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.Conexion2;

/**
 * Creamos una clase denominada ConsultaJob
en esta clase se definira los distintos metodos para
mas tarde su implementacion.
 */


public class ConsultaJob {

	/**
	 * Para este proyecto se hara el uso de listas (ArrayList).
	 */

	private List<Trabajo> trabajos;

	/**
	 * Inicializamos los atributos en null.
	 */
	private PreparedStatement sentencia = null;
	private ResultSet resultado = null;

	/**
	 * Generamos el constructor
	 */

	public ConsultaJob() {
		trabajos = new ArrayList<Trabajo>();

	}

	/**
	 * Generamos el metodo consultarTrabajo.
	 * 
	 * @param con
	 * @param codigo
	 */

	public void ConsultarTrabajo(Conexion2 con, String codigo) {

		Trabajo tra = new Trabajo();
		try {
			sentencia = con.getConexion().prepareStatement(
					"SELECT job_id, job_title, min_salary, max_salary " + "FROM hr.jobs " + "WHERE job_id = ? ");

			sentencia.setString(1, codigo);
			resultado = sentencia.executeQuery();
			while (resultado.next()) {

				tra.setJob_id(resultado.getString("job_id"));
				tra.setJob_title(resultado.getString("job_title"));
				tra.setMin_salary(Integer.parseInt(resultado.getString("min_salary")));
				tra.setMax_salary(Integer.parseInt(resultado.getString("max_salary")));

				trabajos.add(tra);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Generamos el metodo insertarTrabajo.
	 * 
	 * @param con
	 * @param jo_id
	 * @param jo_ti
	 * @param mi_sal
	 * @param ma_sal
	 */

	public void insertarTrabajo(Conexion2 con, String jo_id, String jo_ti, int mi_sal, int ma_sal) {
		try {
			sentencia = con.getConexion().prepareStatement(
					"INSERT INTO jobs(job_id, job_title, min_salary, max_salary)" + "VALUES(?,?,?,?)");
			sentencia.setString(1, jo_id);
			sentencia.setString(2, jo_ti);
			sentencia.setInt(3, mi_sal);
			sentencia.setInt(4, ma_sal);
			sentencia.executeUpdate();
			System.out.println("insertado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Generamos el metodo borrarTrabajo
	 * 
	 * @param con
	 * @param codigo
	 */

	public void borrarTrabajo(Conexion2 con, String codigo) {
		try {
			sentencia = con.getConexion().prepareStatement("DELETE FROM jobs WHERE job_id = ? ");

			sentencia.setString(1, codigo);
			sentencia.executeUpdate();
			System.out.println("borrado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * Generamos el metodo actualizarTrabajo
	 * 
	 * @param con
	 * @param j_id
	 * @param j_title
	 * @param mi_salary
	 * @param ma_salary
	 */

	public void actualizarTrabajo(Conexion2 con, String j_id, String j_title, int mi_salary, int ma_salary) {

		try {
			sentencia = con.getConexion()
					.prepareStatement("UPDATE jobs SET job_title=?, min_salary=?, max_salary=?" + "WHERE job_id = ?");

			sentencia.setString(1, j_title);
			sentencia.setInt(2, mi_salary);
			sentencia.setInt(3, ma_salary);
			sentencia.setString(4, j_id);
			sentencia.executeUpdate();

			System.out.println("actualizado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Generamos los getters y setters de las listas para poder recuperarlas.
	 * 
	 * @return
	 */

	public List<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(List<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

}
