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

import br.com.sabedoria.model.Cliente;
import br.com.sabedoria.service.ClienteService;


@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastrarMentorado")
    public ModelAndView cadastrarMentorado() {
        ModelAndView modelAndView = new ModelAndView("/cliente/cadastrarMentorado");

        modelAndView.addObject("cliente", new Cliente());

        return modelAndView;
    }

    @PostMapping("/cadastrarMentorado")
    public ModelAndView cadastrarMentorado(Cliente cliente, @RequestParam("fileCliente") MultipartFile file) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/sucesso");
        
        String senhaEncriptada = clienteService.encriptarSenha(cliente.getSenha());
        cliente.setSenha(senhaEncriptada);
        
        clienteService.salvarCliente(cliente, file);

        return modelAndView;
    }

    @GetMapping("/imagem/{id}")
    @ResponseBody
    public byte[] exibirImagen(@PathVariable Long id) {
        return clienteService.obterImagemCliente(id);
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("cliente/edicao");

        Cliente cliente = clienteService.obterClientePorId(id);
        modelAndView.addObject("cliente", cliente);

        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public ModelAndView editar(Cliente cliente, @RequestParam("fileCliente") MultipartFile file) throws IOException {
        clienteService.salvarCliente(cliente, file);
        ModelAndView modelAndView = new ModelAndView("redirect:/listar");

        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        clienteService.excluirCliente(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/listar");

        return modelAndView;
    }

    @RequestMapping("/listar")
    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("cliente/home");

        List<Cliente> clientes = clienteService.listarClientes();
        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }
}
