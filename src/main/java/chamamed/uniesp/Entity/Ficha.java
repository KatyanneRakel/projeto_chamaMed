package chamamed.uniesp.Entity;

import chamamed.uniesp.Enum.StatusFicha;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String numeroFicha;

    @NotNull(message = "Paciente obrigatorio")
    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteEntity paciente;

    @NotNull(message = "A especialidade é obrigatória")
    @ManyToOne(optional = false)
    @JoinColumn(name = "especialidade_id", nullable = false)
    private Especialidade especialidade;

    @NotNull(message = "A prioridade é obrigatória")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrioridadeFicha prioridade;

    @Column(nullable = false)
    private LocalDateTime dataHoraEmissao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusFicha status;

    private LocalDateTime dataHoraChamada;

    private LocalDateTime dataHoraCancelamento;

    private String motivoCancelamento;

    @PrePersist
    protected void aoCriar() {
        if (this.dataHoraEmissao == null) {
            this.dataHoraEmissao = LocalDateTime.now();
        }
        if (this.status == null) {
            this.status = StatusFicha.AGUARDANDO;
        }
}
    public Long getId() {
        return id;
    }
    public String getNumeroFicha() {
        return numeroFicha;
    }
    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }
    public PacienteEntity getPaciente() {
        return paciente;
    }
    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public PrioridadeFicha getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeFicha prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDateTime getDataHoraEmissao() {
        return dataHoraEmissao;
    }

    public void setDataHoraEmissao(LocalDateTime dataHoraEmissao) {
        this.dataHoraEmissao = dataHoraEmissao;
    }

    public StatusFicha getStatus() {
        return status;
    }

    public void setStatus(StatusFicha status) {
        this.status = status;
    }

    public LocalDateTime getDataHoraChamada() {
        return dataHoraChamada;
    }

    public void setDataHoraChamada(LocalDateTime dataHoraChamada) {
        this.dataHoraChamada = dataHoraChamada;
    }

    public LocalDateTime getDataHoraCancelamento() {
        return dataHoraCancelamento;
    }

    public void setDataHoraCancelamento(LocalDateTime dataHoraCancelamento) {
        this.dataHoraCancelamento = dataHoraCancelamento;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }
}

