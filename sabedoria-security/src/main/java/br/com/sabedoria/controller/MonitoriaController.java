package br.com.sabedoria.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.sabedoria.model.Cliente;
import br.com.sabedoria.model.Mentor;
import br.com.sabedoria.model.Monitoria;
import br.com.sabedoria.repository.ClienteRepository;
import br.com.sabedoria.repository.MentorRepository;
import br.com.sabedoria.repository.MonitoriaRepository;
import br.com.sabedoria.service.MonitoriaService;

@Controller
public class MonitoriaController {
	
    @Autowired
    private MonitoriaService monitoriaService;

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MonitoriaRepository monitoriaRepository;

    @GetMapping("/cadastrarMonitoria")
    public ModelAndView cadastrarMonitoria() {
        ModelAndView modelAndView = new ModelAndView("monitoria/cadastrarMonitoria");

        List<Mentor> mentores = mentorRepository.findAll();
        List<Cliente> clientes = clienteRepository.findAll();

        modelAndView.addObject("mentores", mentores);
        modelAndView.addObject("clientes", clientes);
        modelAndView.addObject("monitoria", new Monitoria());

        return modelAndView;
    }

    @PostMapping("/cadastrarMonitoria")
    public ModelAndView cadastrarMonitoria(@ModelAttribute Monitoria monitoria,
                                           @RequestParam Long mentorId,
                                           @RequestParam Long clienteId,
                                           @RequestParam String dataHora,
                                           @RequestParam(required = false) MultipartFile file) throws IOException {
        monitoriaService.salvarMonitoria(monitoria, mentorId, clienteId, dataHora, file);

        return new ModelAndView("redirect:/listarMonitorias");
    }

    @GetMapping("/listarMonitorias")
    public ModelAndView listarMonitorias() {
        ModelAndView modelAndView = new ModelAndView("monitoria/home");

        List<Monitoria> monitorias = monitoriaRepository.findAll();
        modelAndView.addObject("monitorias", monitorias);

        return modelAndView;
    }

    @GetMapping("/excluirMonitoria")
    public ModelAndView excluirMonitoria(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/listarMonitorias");

        // Verificando se a monitoria existe antes de tentar excluí-la
        if (monitoriaRepository.existsById(id)) {
            monitoriaRepository.deleteById(id);
        }

        return modelAndView;
    }
}
