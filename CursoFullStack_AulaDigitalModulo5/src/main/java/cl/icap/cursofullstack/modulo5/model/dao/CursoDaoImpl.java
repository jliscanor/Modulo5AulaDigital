package cl.icap.cursofullstack.modulo5.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.icap.cursofullstack.modulo5.model.dto.CursoDto;

@Repository
@Transactional
public class CursoDaoImpl implements CursoDao {
	private String insert = "INSERT INTO CURSO VALUES(?,?)";
	private String select = "SELECT FROM CURSO WHERE codigo=?";
	private String update = "UPDATE CURSO SET codigo=?,nombre=? WHERE codigo=?";
	private String delete = "DELETE CURSO WHERE codigo=?";
	private String list = "SELECT * FROM CURSO";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public CursoDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CursoDto get(int codigo) {
		Object args[] = {codigo};
		CursoDto cursoDto;
		try {
		cursoDto = jdbcTemplate.queryForObject(select, args, BeanPropertyRowMapper.newInstance(CursoDto.class));
		} catch (Exception e) {
			cursoDto = null;
			e.printStackTrace(); 
		}
		return cursoDto;
	}

	@Override
	public int insert(CursoDto cursoDto) {
		int rows = 0;
		Object args[] = {
				cursoDto.getCodigo(),
				cursoDto.getNombre(),
		};
		
		try {
		rows = jdbcTemplate.update(insert, args);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int update(CursoDto cursoDto) {
		int rows = 0;
		Object args[] = {
				cursoDto.getCodigo(),
				cursoDto.getNombre(),
		};
		
		try {
		rows = jdbcTemplate.update(update, args);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int delete(int codigo) {
		int rows=0;
		Object args[] = {codigo};
		
		try {
		rows = jdbcTemplate.update(delete, args);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return rows;
	}

	@Override
	public List<CursoDto> list() {
		List<CursoDto> listCurso = jdbcTemplate.query(list, BeanPropertyRowMapper.newInstance(CursoDto.class));
		return listCurso;
	}

}
