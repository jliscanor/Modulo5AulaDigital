package cl.icap.cursofullstack.modulo5.model.dao;

import java.util.List;

import cl.icap.cursofullstack.modulo5.model.dto.AlumnoDto;



public interface AlumnoDao {
	public AlumnoDto get(int rut);
	public int insert(AlumnoDto alumnoDto);
	public int update(AlumnoDto alumnoDto);
	public int delete(int rut);
	public List<AlumnoDto> list();

}
