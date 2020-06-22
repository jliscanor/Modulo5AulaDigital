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

import cl.icap.cursofullstack.modulo5.model.dto.CursoDto;
import cl.icap.cursofullstack.modulo5.service.CursoService;

@Controller
@RequestMapping(value="/curso_page")
public class CursoController {
	
	@Autowired
	CursoService cursoService;
	
	@RequestMapping(value="/list")
	public @ResponseBody List<CursoDto> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		return cursoService.list();
	}

	@RequestMapping(value="/get")
	public @ResponseBody CursoDto ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		return cursoService.get(Integer.parseInt(req.getParameter("codigo")));
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		String requestData;
		try { 
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			CursoDto cursoDto = gson.fromJson(requestData, CursoDto.class);
			rows = cursoService.insert(cursoDto);
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
			CursoDto cursoDto = gson.fromJson(requestData, CursoDto.class);
			rows = cursoService.update(cursoDto);
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
			rows = cursoService.delete(Integer.parseInt(req.getParameter("codigo")));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}

