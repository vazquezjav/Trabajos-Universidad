package Logica;

/**
 * Creamos la clase Trabajo para luego ir trabajando en ella.
 * 
 * @author Daniel
 *
 */

public class Trabajo {

	/**
	 * Revisamos nuestra oracle (EX) mediante el comando desc y el nombre de tabla,
	 * para asi poder ver los atributos que tiene la tabala e irles agregando en
	 * java.
	 */
	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;

	/**
	 * Creamos la clase Trabajo para luego ir trabajando en ella.
	 * 
	 * @return
	 */
	/**
	 * Generamos getters y setters.
	 * 
	 * @return
	 */

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public int getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}

	public int getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}

}
