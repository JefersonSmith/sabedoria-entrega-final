package br.com.sabedoria.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.sabedoria.model.Mentor;
import br.com.sabedoria.repository.MentorRepository;
import br.com.sabedoria.service.MentorService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;
    
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public Mentor salvarMentor(Mentor mentor, MultipartFile file) throws IOException {
        try {
            mentor.setImagem(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mentorRepository.save(mentor);
    }
    
    @Override
    public String encriptarSenha(String senha) {
        return passwordEncoder.encode(senha);
    }

    @Override
    public byte[] obterImagemMentor(Long id) {
        // Usando orElseThrow para lidar com o caso em que o mentor não é encontrado
        Mentor mentor = mentorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mentor não encontrado com o ID: " + id));

        return mentor.getImagem();
    }

    @Override
    public List<Mentor> listarMentores() {
        return mentorRepository.findAll();
    }

    @Override
    public Mentor obterMentorPorId(Long id) {
        // Usando orElseThrow para lidar com o caso em que o mentor não é encontrado
        return mentorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mentor não encontrado com o ID: " + id));
    }

    @Override
    public void excluirMentor(Long id) {
        mentorRepository.deleteById(id);
    }
}
