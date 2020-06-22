package cl.icap.cursofullstack.modulo5.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.icap.cursofullstack.modulo5.model.dto.AlumnoDto;

@Repository
@Transactional
public class AlumnoDaoImpl implements AlumnoDao {
	private String insert = "INSERT INTO ALUMNO VALUES(?,?,?)";
	private String select = "SELECT FROM ALUMNO WHERE rut=?";
	private String update = "UPDATE ALUMNO SET rut=?,nombre=?,curso=? WHERE rut=?";
	private String delete = "DELETE ALUMNO WHERE rut=?";
	private String list = "SELECT * FROM ALUMNO";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AlumnoDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AlumnoDto get(int rut) {
		Object args[] = {rut};
		AlumnoDto alumnoDto;
		try {
		alumnoDto = jdbcTemplate.queryForObject(select, args, BeanPropertyRowMapper.newInstance(AlumnoDto.class));
		} catch (Exception e) {
			alumnoDto = null;
			e.printStackTrace(); 
		}
		return alumnoDto;
	}

	@Override
	public int insert(AlumnoDto alumnoDto) {
		int rows = 0;
		Object args[] = {
				alumnoDto.getRut(),
				alumnoDto.getNombre(),
				alumnoDto.getCurso()
		};
		
		try {
		rows = jdbcTemplate.update(insert, args);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int update(AlumnoDto alumnoDto) {
		int rows = 0;
		Object args[] = {
				alumnoDto.getRut(),
				alumnoDto.getNombre(),
				alumnoDto.getCurso(),
				alumnoDto.getRut()
		};
		
		try {
		rows = jdbcTemplate.update(update, args);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int delete(int rut) {
		int rows=0;
		Object args[] = {rut};
		
		try {
		rows = jdbcTemplate.update(delete, args);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return rows;
	}

	@Override
	public List<AlumnoDto> list() {
		List<AlumnoDto> listAlumno = jdbcTemplate.query(list, BeanPropertyRowMapper.newInstance(AlumnoDto.class));
		return listAlumno;
	}

}
