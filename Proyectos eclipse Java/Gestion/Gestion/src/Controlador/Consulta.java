package Controlador;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Tipos.Departamento;
import Tipos.Empleado;
import Tipos.HistoriaTrabajo;
import Tipos.Localidad;
import Tipos.Pais;
import Tipos.Region;
import Tipos.Trabajo;

public class Consulta {

	private List<Region> regiones;
	private List<Pais> paises;
	private List<Localidad> localidades;
	private List<Departamento> departamentos;
	private List<Empleado> empleados;
	private List<HistoriaTrabajo> historias;
	private List<Trabajo> trabajos;

	private PreparedStatement sentencia = null;
	private ResultSet resultado = null;

	public Consulta() {
		regiones = new ArrayList<Region>();
		paises = new ArrayList<Pais>();
		localidades = new ArrayList<Localidad>();
		departamentos = new ArrayList<Departamento>();
		empleados = new ArrayList<Empleado>();
		historias = new ArrayList<HistoriaTrabajo>();
		trabajos = new ArrayList<Trabajo>();

	}

	public void ConsultarRegion(Conexion con, String codigo) {

		Region reg = new Region();
		try {
			sentencia = con.getConexion()
					.prepareStatement("SELECT region_id, region_name " + "FROM hr.regions " + "WHERE region_id = ? ");

			sentencia.setString(1, codigo);
			resultado = sentencia.executeQuery();
			while (resultado.next()) {

				reg.setRegion_id(Integer.parseInt(resultado.getString("region_id")));
				reg.setRegion_name(resultado.getString("region_name"));

				regiones.add(reg);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void ConsultarHistoriaTrabajo(Conexion con, String codigo) {

		HistoriaTrabajo hi = new HistoriaTrabajo();
		try {
			sentencia = con.getConexion()
					.prepareStatement("SELECT employee_id, start_date, end_date, job_id, department_id "
							+ "FROM hr.job_history " + "WHERE employee_id = ? ");

			sentencia.setString(1, codigo);
			resultado = sentencia.executeQuery();
			while (resultado.next()) {

				hi.setEmployee_id(Integer.parseInt(resultado.getString("employee_id")));
				hi.setStart_date(resultado.getString("start_date"));
				hi.setEnd_date(resultado.getString("end_date"));
				hi.setJob_id(resultado.getString("job_id"));
				hi.setDepartment_id(Integer.parseInt(resultado.getString("department_id")));

				historias.add(hi);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void ConsultarTrabajo(Conexion con, String codigo) {

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

	public void ConsultarEmpleado(Conexion con, String codigo) {

		Empleado em = new Empleado();
		try {
			sentencia = con.getConexion().prepareStatement(
					"SELECT employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, "
							+ "commission_pct, manager_id, department_id  " + "FROM hr.employees "
							+ "WHERE employee_id = ? ");

			sentencia.setString(1, codigo);
			resultado = sentencia.executeQuery();
			while (resultado.next()) {

				em.setEmployee_id(Integer.parseInt(resultado.getString("employee_id")));
				em.setFirst_name(resultado.getString("first_name"));
				em.setLast_name(resultado.getString("last_name"));
				em.setEmail(resultado.getString("email"));
				em.setPhone_number(resultado.getString("phone_number"));
				em.setHire_date(resultado.getString("hire_date"));
				em.setJob_id(resultado.getString("job_id"));
				em.setSalary(Integer.parseInt(resultado.getString("salary")));
				em.setCommission_pct(Integer.parseInt(resultado.getString("commission_pct")));
				em.setManager_id(Integer.parseInt(resultado.getString("manager_id")));
				em.setDepartment_id(Integer.parseInt(resultado.getString("department_id")));

				empleados.add(em);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void ConsultarDepartamento(Conexion con, String codigo) {

		Departamento dep = new Departamento();
		try {
			sentencia = con.getConexion()
					.prepareStatement("SELECT department_id, department_name, location_id, manager_id "
							+ "FROM hr.departments " + "WHERE department_id = ? ");

			sentencia.setString(1, codigo);
			resultado = sentencia.executeQuery();
			while (resultado.next()) {

				dep.setDepartment_id(Integer.parseInt(resultado.getString("department_id")));
				dep.setDepartment_name(resultado.getString("department_name"));
				dep.setLocation_id(Integer.parseInt(resultado.getString("location_id")));
				dep.setManager_id(Integer.parseInt(resultado.getString("manager_id")));

				departamentos.add(dep);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void ConsultarPaises(Conexion con, String codigo) {
		Pais pais = new Pais();
		try {
			sentencia = con.getConexion().prepareStatement(
					"SELECT country_id, country_name, region_id " + "FROM hr.countries " + "WHERE country_id = ? ");
			sentencia.setString(1, codigo);
			resultado = sentencia.executeQuery();
			while (resultado.next()) {

				pais.setCountry_id(resultado.getString("country_id"));
				pais.setCountry_name(resultado.getString("country_name"));
				pais.setRegion_id(Integer.parseInt(resultado.getString("region_id")));

				paises.add(pais);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void ConsultarLacalidades(Conexion con, String codigo) {
		Localidad loc = new Localidad();
		try {
			sentencia = con.getConexion()
					.prepareStatement("SELECT location_id, city, state_province,street_address,postal_code, country_id "
							+ "FROM hr.locations " + "WHERE location_id = ? ");
			sentencia.setString(1, codigo);
			resultado = sentencia.executeQuery();
			while (resultado.next()) {

				loc.setLocation_id(Integer.parseInt(resultado.getString("location_id")));
				loc.setStreet_address(resultado.getString("street_address"));
				loc.setPostal_code(resultado.getString("postal_code"));
				loc.setState_province(resultado.getString("state_province"));
				loc.setCity(resultado.getString("city"));
				loc.setCountry_id(resultado.getString("country_id"));

				localidades.add(loc);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void insertarRegion(Conexion con, int codigo, String nombre) {
		try {
			sentencia = con.getConexion()
					.prepareStatement("INSERT INTO regions(region_id, region_name)" + "VALUES(?,?)");
			sentencia.setInt(1, codigo);
			sentencia.setString(2, nombre);
			sentencia.executeUpdate();
			System.out.println("insertado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void insertarDepartamento(Conexion con, int dep_id, String dep_name, int man_id, int loc_id) {
		try {
			sentencia = con.getConexion()
					.prepareStatement("INSERT INTO departments(department_id, department_name, manager_id, location_id)"
							+ "VALUES(?,?,?,?)");
			sentencia.setInt(1, dep_id);
			sentencia.setString(2, dep_name);
			sentencia.setInt(3, man_id);
			sentencia.setInt(4, loc_id);
			sentencia.executeUpdate();
			System.out.println("insertado");
		} catch (SQLException e) {
			// TODO: handle exception
		}

	}

	public void insertarEmpleado(Conexion con, int emp_id, String fir_name, String las_name, String ema, String phon_nu,
			String hir_dat, String job_id, int sala, int comm_pct, int man_id, int depar_id) {
		try {
			sentencia = con.getConexion().prepareStatement(
					"INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)"
							+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			sentencia.setInt(1, emp_id);
			sentencia.setString(2, fir_name);
			sentencia.setString(3, las_name);
			sentencia.setString(4, ema);
			sentencia.setString(5, phon_nu);
			sentencia.setString(6, hir_dat);
			sentencia.setString(7, job_id);
			sentencia.setInt(8, sala);
			sentencia.setInt(9, comm_pct);
			sentencia.setInt(10, man_id);
			sentencia.setInt(11, depar_id);

			sentencia.executeUpdate();
			System.out.println("insertado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void insertarTrabajo(Conexion con, String jo_id, String jo_ti, int mi_sal, int ma_sal) {
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

	public void insertarHistoriaTrabajo(Conexion con, int em_id, String sta_da, String en_da, String jo_id,
			int dep_id) {
		try {
			sentencia = con.getConexion().prepareStatement(
					"INSERT INTO jobs(employee_id, start_date, end_date, job_id, department_id)" + "VALUES(?,?,?,?,?)");
			sentencia.setInt(1, em_id);
			sentencia.setString(2, sta_da);
			sentencia.setString(3, en_da);
			sentencia.setString(4, jo_id);
			sentencia.setInt(5, dep_id);

			sentencia.executeUpdate();
			System.out.println("insertado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void insertarPais(Conexion con, String codigo, String nombre, int codigoR) {
		try {
			sentencia = con.getConexion()
					.prepareStatement("INSERT INTO countries(country_id, country_name, region_id)" + "VALUES(?,?,?)");
			sentencia.setString(1, codigo);
			sentencia.setString(2, nombre);
			sentencia.setInt(3, codigoR);
			sentencia.executeUpdate();
			System.out.println("insertado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void insertarLocalidad(Conexion con, int location_id, String street_address, String postal_code, String city,
			String state_province, String country_id) {
		try {
			sentencia = con.getConexion().prepareStatement(
					"INSERT INTO locations(location_id,  street_address, postal_code, city, state_province, country_id)"
							+ "VALUES(?,?,?,?,?,?)");
			sentencia.setInt(1, location_id);
			sentencia.setString(2, street_address);
			sentencia.setString(3, postal_code);
			sentencia.setString(4, city);
			sentencia.setString(5, state_province);
			sentencia.setString(6, country_id);
			sentencia.executeUpdate();
			System.out.println("insertado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void borrarRegion(Conexion con, int codigo) {
		try {
			sentencia = con.getConexion().prepareStatement("DELETE FROM regions WHERE region_id = ? ");

			sentencia.setInt(1, codigo);
			sentencia.executeUpdate();
			System.out.println("borrado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void borrarDepartamento(Conexion con, int codigo) {
		try {
			sentencia = con.getConexion().prepareStatement("DELETE FROM departaments WHERE department_id = ? ");

			sentencia.setInt(1, codigo);
			sentencia.executeUpdate();
			System.out.println("borrado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void borrarEmpleado(Conexion con, int codigo) {
		try {
			sentencia = con.getConexion().prepareStatement("DELETE FROM employees WHERE employee_id = ? ");

			sentencia.setInt(1, codigo);
			sentencia.executeUpdate();
			System.out.println("borrado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void borrarTrabajo(Conexion con, String codigo) {
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

	public void borrarHistoriaTrabajo(Conexion con, int codigo) {
		try {
			sentencia = con.getConexion().prepareStatement("DELETE FROM job_history WHERE employee_id = ? ");

			sentencia.setInt(1, codigo);
			sentencia.executeUpdate();
			System.out.println("borrado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void borrarPais(Conexion con, String codigo) {
		try {
			sentencia = con.getConexion().prepareStatement("DELETE FROM countries WHERE country_id = ? ");

			sentencia.setString(1, codigo);
			sentencia.executeUpdate();
			System.out.println("borrado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void borrarLocalidad(Conexion con, int codigo) {
		try {
			sentencia = con.getConexion().prepareStatement("DELETE FROM locations WHERE location_id = ? ");

			sentencia.setInt(1, codigo);
			sentencia.executeUpdate();
			System.out.println("borrado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<Region> getRegiones() {
		return regiones;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<HistoriaTrabajo> getHistorias() {
		return historias;
	}

	public void setHistorias(List<HistoriaTrabajo> historias) {
		this.historias = historias;
	}

	public List<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(List<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public void setRegiones(List<Region> regiones) {
		this.regiones = regiones;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}

}
