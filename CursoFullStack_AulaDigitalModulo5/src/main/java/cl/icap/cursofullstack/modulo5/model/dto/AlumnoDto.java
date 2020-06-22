package cl.icap.cursofullstack.modulo5.model.dto;

public class AlumnoDto {

	private Integer rut;
	private String nombre;		
	private Integer curso;
	
	public AlumnoDto() {
		
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}
	

}
