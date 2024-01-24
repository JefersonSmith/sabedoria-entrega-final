package br.com.sabedoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sabedoria.model.Cliente;
import br.com.sabedoria.model.Mentor;
import br.com.sabedoria.repository.ClienteRepository;
import br.com.sabedoria.repository.MentorRepository;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/sobreNos")
    public String sobreNos() {
        return "sobreNos";
    }
    
    @GetMapping("/planos")
    public String planos() {
        return "planos";
    }
    
    @GetMapping("/mentores")
    public String mentores() {
        return "mentores";
    }
    
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @GetMapping("/sucesso")
    public String sucesso() {
        return "sucesso";
    }
    
    @GetMapping("/sucessoExclusao")
    public String sucessoExclusao() {
        return "sucessoExclusao";
    }
    
    @GetMapping("/sucessoMonitoria")
    public String sucessoMonitoria() {
        return "sucessoMonitoria";
    }
    
	@GetMapping("/login")
	public String login() {
		return "/login/login";
	}
	
	@GetMapping("/perfil")
	public String perfil() {
		return "/perfil";
	}
	
}


    	

