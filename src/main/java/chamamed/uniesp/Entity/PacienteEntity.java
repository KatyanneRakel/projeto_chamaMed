package chamamed.uniesp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class PacienteEntity {
    private String  nome;
    private String cpf;
    private String dataNasc;
    private String telefone;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public PacienteEntity(String telefone, String dataNasc, String cpf, String nome) {
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.nome = nome;
    }

    public PacienteEntity() {

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
}

