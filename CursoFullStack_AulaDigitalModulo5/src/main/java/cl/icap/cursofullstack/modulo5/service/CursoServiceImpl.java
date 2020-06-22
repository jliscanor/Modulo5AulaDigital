package cl.icap.cursofullstack.modulo5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.icap.cursofullstack.modulo5.model.dao.CursoDao;
import cl.icap.cursofullstack.modulo5.model.dto.CursoDto;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	CursoDao cursoDao;
	
	
	
	public CursoServiceImpl() {
	}
	
	public List<CursoDto> list() {
		return cursoDao.list();
	}

	@Override
	public CursoDto get(int codigo) {
		return cursoDao.get(codigo);
	}

	@Override
	public int insert(CursoDto cursoDto) {
		return cursoDao.insert(cursoDto);
	}

	@Override
	public int update(CursoDto cursoDto) {
		return cursoDao.update(cursoDto);
	}

	@Override
	public int delete(int codigo) {
		return cursoDao.delete(codigo);
	}
}
