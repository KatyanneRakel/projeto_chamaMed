package chamamed.uniesp.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Nome da especialidade é obrigatorio")
    @Column(nullable = false, unique = true)
    private String nome;

    public Especialidade() {
    }
    public Especialidade(String nome) {
        this.nome = nome;
    }
    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
