package br.com.sabedoria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sabedoria.model.Cliente;
import br.com.sabedoria.model.Mentor;
import br.com.sabedoria.repository.ClienteRepository;
import br.com.sabedoria.repository.MentorRepository;
import br.com.sabedoria.serviceImpl.ClienteUserDetailsImpl;
import br.com.sabedoria.serviceImpl.MentorUserDetailsImpl;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Cliente cliente = clienteRepository.findByEmail(email).orElse(null);

        if (cliente != null) {
            return new ClienteUserDetailsImpl(cliente);
        }

        Mentor mentor = mentorRepository.findByEmail(email).orElse(null);

        if (mentor != null) {
            return new MentorUserDetailsImpl(mentor);
        }

        // Retorna null se nenhum usuário for encontrado com o email fornecido
        return null;
    }
}
