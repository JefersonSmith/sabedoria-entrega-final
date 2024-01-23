package br.com.sabedoria.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.com.sabedoria.model.Cliente;

public interface ClienteService {
    Cliente salvarCliente(Cliente cliente, MultipartFile file) throws IOException;
    byte[] obterImagemCliente(Long id);
    List<Cliente> listarClientes();
    Cliente obterClientePorId(Long id);
    void excluirCliente(Long id);
	String encriptarSenha(String senha);

}
