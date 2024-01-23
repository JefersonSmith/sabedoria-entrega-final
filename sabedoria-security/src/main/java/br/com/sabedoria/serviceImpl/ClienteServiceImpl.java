package br.com.sabedoria.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.sabedoria.model.Cliente;
import br.com.sabedoria.repository.ClienteRepository;
import br.com.sabedoria.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public Cliente salvarCliente(Cliente cliente, MultipartFile file) throws IOException {
        try {
            cliente.setImagem(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clienteRepository.save(cliente);
    }
    
    @Override
    public String encriptarSenha(String senha) {
        return passwordEncoder.encode(senha);
    }

    @Override
    public byte[] obterImagemCliente(Long id) {
        // Usando orElseThrow para lidar com o caso em que o cliente não é encontrado
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + id));

        return cliente.getImagem();
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obterClientePorId(Long id) {
        // Usando orElseThrow para lidar com o caso em que o cliente não é encontrado
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + id));
    }

    @Override
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
