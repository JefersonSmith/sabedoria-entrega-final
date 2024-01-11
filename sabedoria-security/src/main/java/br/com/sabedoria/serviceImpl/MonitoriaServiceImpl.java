package br.com.sabedoria.serviceImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.sabedoria.model.Cliente;
import br.com.sabedoria.model.Mentor;
import br.com.sabedoria.model.Monitoria;
import br.com.sabedoria.repository.ClienteRepository;
import br.com.sabedoria.repository.MentorRepository;
import br.com.sabedoria.repository.MonitoriaRepository;
import br.com.sabedoria.service.MonitoriaService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MonitoriaServiceImpl implements MonitoriaService {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MonitoriaRepository monitoriaRepository;

    @Override
    public Monitoria salvarMonitoria(Monitoria monitoria, Long mentorId, Long clienteId, String dataHora, MultipartFile file) throws IOException {
        Mentor mentor = mentorRepository.findById(mentorId)
                .orElseThrow(() -> new EntityNotFoundException("Mentor não encontrado com o ID: " + mentorId));

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));

        LocalDateTime horario = LocalDateTime.parse(dataHora, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

        monitoria.setMentor(mentor);
        monitoria.setCliente(cliente);
        monitoria.setHorario(horario);

        if (file != null && !file.isEmpty()) {
            monitoria.setImagem(file.getBytes());
        }

        return monitoriaRepository.save(monitoria);
    }

    @Override
    public byte[] obterImagemMonitoria(Long id) {
        Monitoria monitoria = monitoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Monitoria não encontrada com o ID: " + id));

        return monitoria.getImagem();
    }

    @Override
    public List<Monitoria> listarMonitorias() {
        return monitoriaRepository.findAll();
    }

    @Override
    public Monitoria obterMonitoriaPorId(Long id) {
        return monitoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Monitoria não encontrada com o ID: " + id));
    }

    @Override
    public void excluirMonitoria(Long id) {
        monitoriaRepository.deleteById(id);
    }
}