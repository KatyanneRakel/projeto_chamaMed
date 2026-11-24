package chamamed.uniesp.Service;

import chamamed.uniesp.Entity.PacienteEntity;
import chamamed.uniesp.Repository.PacienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteEntity criarPaciente(PacienteEntity paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<PacienteEntity> listarPaciente() {
        return pacienteRepository.findAll();
    }

    public ResponseEntity<PacienteEntity> buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PacienteEntity> atualizarPaciente(Long id, PacienteEntity dados) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNome(dados.getNome());
                    paciente.setCpf(dados.getCpf());
                    paciente.setDataNasc(dados.getDataNasc());
                    paciente.setTelefone(dados.getTelefone());
                    return ResponseEntity.ok(pacienteRepository.save(paciente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deletarPaciente(Long id) {
        if (!pacienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pacienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}