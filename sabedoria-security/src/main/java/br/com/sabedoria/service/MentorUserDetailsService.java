package br.com.sabedoria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sabedoria.model.Mentor;
import br.com.sabedoria.repository.MentorRepository;
import br.com.sabedoria.serviceImpl.MentorUserDetailsImpl;

@Service
public class MentorUserDetailsService implements UserDetailsService {

    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Mentor mentor = mentorRepository.findByEmail(email).orElse(null);

        if (mentor == null) {
            return null;
        }

        return new MentorUserDetailsImpl(mentor);
    }
}
