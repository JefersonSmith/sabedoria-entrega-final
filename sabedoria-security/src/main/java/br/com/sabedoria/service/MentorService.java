package br.com.sabedoria.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.com.sabedoria.model.Mentor;

public interface MentorService {
    Mentor salvarMentor(Mentor mentor, MultipartFile file) throws IOException;
    byte[] obterImagemMentor(Long id);
    List<Mentor> listarMentores();
    Mentor obterMentorPorId(Long id);
    void excluirMentor(Long id);
	String encriptarSenha(String senha);
}
