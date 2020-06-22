package cl.icap.cursofullstack.modulo5.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cl.icap.cursofullstack.modulo5.model.dto.AlumnoDto;
import cl.icap.cursofullstack.modulo5.service.AlumnoService;



@Controller
@RequestMapping(value="/alumno_page")
public class AlumnoController {
	
	@Autowired
	AlumnoService alumnoService;
	
	@RequestMapping(value="/list")
	public @ResponseBody List<AlumnoDto> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		return alumnoService.list();
	}

	@RequestMapping(value="/get")
	public @ResponseBody AlumnoDto ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		return alumnoService.get(Integer.parseInt(req.getParameter("rut")));
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		String requestData;
		try { 
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			AlumnoDto alumnoDto = gson.fromJson(requestData, AlumnoDto.class);
			rows = alumnoService.insert(alumnoDto);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return rows;
	}
	
	@RequestMapping(value="/update")
	public @ResponseBody int ajaxUpdate(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		String requestData;
		try { 
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			AlumnoDto alumnoDto = gson.fromJson(requestData, AlumnoDto.class);
			rows = alumnoService.update(alumnoDto);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return rows;
	}
	
	@RequestMapping(value="/delete")
	public @ResponseBody int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			rows = alumnoService.delete(Integer.parseInt(req.getParameter("rut")));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}
