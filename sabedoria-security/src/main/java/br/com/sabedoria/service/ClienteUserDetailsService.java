package br.com.sabedoria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sabedoria.model.Cliente;
import br.com.sabedoria.repository.ClienteRepository;
import br.com.sabedoria.serviceImpl.ClienteUserDetailsImpl;
import br.com.sabedoria.serviceImpl.ClienteUserDetailsImpl;

@Service
public class ClienteUserDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(email).orElse(null);

        if (cliente == null) {
            return null;
        }

        return new ClienteUserDetailsImpl(cliente);
    }
}

