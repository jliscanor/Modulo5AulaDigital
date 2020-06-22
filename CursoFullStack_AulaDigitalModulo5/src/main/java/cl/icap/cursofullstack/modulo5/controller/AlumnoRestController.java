package cl.icap.cursofullstack.modulo5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.icap.cursofullstack.modulo5.model.dto.AlumnoDto;
import cl.icap.cursofullstack.modulo5.service.AlumnoService;

@RestController
@RequestMapping(value="/rest")
public class AlumnoRestController {
	@Autowired
	AlumnoService alumnoService;
	
	@RequestMapping(value="/alumnolist")
	public List<AlumnoDto> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		List<AlumnoDto> list = alumnoService.findAll();
		return list;
	}

}
