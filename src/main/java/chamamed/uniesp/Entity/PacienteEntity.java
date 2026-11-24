package chamamed.uniesp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

//Declara como Entity para já ser criado a tabela no banco de dados
@Entity

public class PacienteEntity {

    //Faz com que o Id seja criado pelo banco de dados automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;

    //define que cpf não pode ser vazio e tem que ser unico para cada paciente
    @NotBlank(message = "Cpf é obrigatório")
    @Column(unique=true)
    private String  cpf;

    //define nome como obrigatorio para paciente
    @NotBlank(message = "Nome é obrigatório")
    private String  nome;

    private String  dataNasc;
    private String  telefone;


    //construtores
    public PacienteEntity(String telefone, String dataNasc, String cpf, String nome) {
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.nome = nome;
    }
    public PacienteEntity() {}


    // setters
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public void setDataNasc(String dataNasc) {this.dataNasc = dataNasc;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setNome(String nome) {this.nome = nome;}

    // getters
    public String   getTelefone() {return telefone;}
    public Long     getId() {return id;}
    public String   getNome() {return nome;}
    public String   getCpf() {return cpf;}
    public String   getDataNasc() {return dataNasc;}
}

