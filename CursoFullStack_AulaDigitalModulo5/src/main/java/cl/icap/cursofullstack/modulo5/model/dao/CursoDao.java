package cl.icap.cursofullstack.modulo5.model.dao;

import java.util.List;

import cl.icap.cursofullstack.modulo5.model.dto.CursoDto;

public interface CursoDao {
	public CursoDto get(int codigo);
	public int insert(CursoDto cursoDto);
	public int update(CursoDto cursoDto);
	public int delete(int codigo);
	public List<CursoDto> list();
}
