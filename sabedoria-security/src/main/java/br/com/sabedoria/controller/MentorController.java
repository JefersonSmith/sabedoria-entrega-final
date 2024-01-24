package br.com.sabedoria.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.sabedoria.model.Mentor;
import br.com.sabedoria.service.MentorService;

@Controller
public class MentorController {

    @Autowired
    private MentorService mentorService;

     @GetMapping("/listarMonitores")
    public ModelAndView listarMonitores() {
        ModelAndView modelAndView = new ModelAndView("listarMonitores");

        List<Mentor> mentores = mentorService.listarMentores();
        modelAndView.addObject("mentores", mentores);

        return modelAndView;
    }

    @GetMapping("/cadastrarMentor")
    public ModelAndView cadastrarMentor() {
        ModelAndView modelAndView = new ModelAndView("mentor/cadastrarMentor");

        modelAndView.addObject("mentor", new Mentor());

        return modelAndView;
    }

    @PostMapping("/cadastrarMentor")
    public ModelAndView cadastrarMentor(Mentor mentor, @RequestParam("fileMentor") MultipartFile file) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/sucesso");

        String senhaEncriptada = mentorService.encriptarSenha(mentor.getSenha());
        mentor.setSenha(senhaEncriptada);

        mentorService.salvarMentor(mentor, file);

        return modelAndView;
    }
    @GetMapping("/imagemMentor/{id}")
    @ResponseBody
    public byte[] exibirImagenMentor(@PathVariable Long id) {
        return mentorService.obterImagemMentor(id);
    }

    @GetMapping("/{id}/editarMentor")
    public ModelAndView editarMentor(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("mentor/edicaoMentor");

        Mentor mentor = mentorService.obterMentorPorId(id);
        modelAndView.addObject("mentor", mentor);

        return modelAndView;
    }

    @PostMapping("/{id}/editarMentor")
    public ModelAndView editarMentor(Mentor mentor, @RequestParam("fileMentor") MultipartFile file) throws IOException {
        String senhaEncriptada = mentorService.encriptarSenha(mentor.getSenha());
        mentor.setSenha(senhaEncriptada);

        mentorService.salvarMentor(mentor, file);
        ModelAndView modelAndView = new ModelAndView("redirect:/perfil");

        return modelAndView;
    }

    @GetMapping("/mentor/{id}/excluir")
    public ModelAndView excluirMentor(@PathVariable Long id) {
        mentorService.excluirMentor(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/listarMentor");

        return modelAndView;
    }

    @RequestMapping("/listarMentor")
    @GetMapping
    public ModelAndView listarMentor() {
        ModelAndView modelAndView = new ModelAndView("mentor/home");

        List<Mentor> mentors = mentorService.listarMentores();
        modelAndView.addObject("mentors", mentors);

        return modelAndView;
    }
}
