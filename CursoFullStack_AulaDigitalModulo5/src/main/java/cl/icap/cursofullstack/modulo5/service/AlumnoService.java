package cl.icap.cursofullstack.modulo5.service;

import java.util.List;

import cl.icap.cursofullstack.modulo5.model.dto.AlumnoDto;

public interface AlumnoService {
		public AlumnoDto get(int rut);
		public int insert(AlumnoDto alumnoDto);
		public int update(AlumnoDto alumnoDto);
		public int delete(int rut);
		public List<AlumnoDto> list();
		public List<AlumnoDto> findAll();

}
