package cl.icap.cursofullstack.modulo5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.cursofullstack.modulo5.model.dao.AlumnoDao;
import cl.icap.cursofullstack.modulo5.model.dto.AlumnoDto;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	AlumnoDao alumnoDao;
	
	
	
	public AlumnoServiceImpl() {
	}
	
	public List<AlumnoDto> list() {
		return alumnoDao.list();
	}

	@Override
	public AlumnoDto get(int rut) {
		return alumnoDao.get(rut);
	}

	@Override
	public int insert(AlumnoDto alumnoDto) {
		return alumnoDao.insert(alumnoDto);
	}

	@Override
	public int update(AlumnoDto alumnoDto) {
		return alumnoDao.update(alumnoDto);
	}

	@Override
	public int delete(int rut) {
		return alumnoDao.delete(rut);
	}

	@Override
	public List<AlumnoDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
