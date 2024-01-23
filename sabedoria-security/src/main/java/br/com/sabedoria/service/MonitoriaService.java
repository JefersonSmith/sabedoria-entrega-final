package br.com.sabedoria.service;

import br.com.sabedoria.model.Monitoria;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface MonitoriaService {
    Monitoria salvarMonitoria(Monitoria monitoria, Long mentorId, Long clienteId, String dataHora, MultipartFile file) throws IOException;

    byte[] obterImagemMonitoria(Long id);

    List<Monitoria> listarMonitorias();

    Monitoria obterMonitoriaPorId(Long id);

    void excluirMonitoria(Long id);
}