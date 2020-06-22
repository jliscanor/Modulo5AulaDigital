package cl.icap.cursofullstack.modulo5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {
	@RequestMapping("/")
	public String getHome() {
		return "index";
	}
	
	@RequestMapping("/alumno_page")
	public String getAlumno() {
		return "alumno_page";
	}
	
	@RequestMapping("/curso_page")
	public String getCurso() {
		return "curso_page";
	}
}


