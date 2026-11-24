package chamamed.uniesp.Controller;

import chamamed.uniesp.Entity.PacienteEntity;
import chamamed.uniesp.Service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Declara que a classe recebe requisições HTTP e devolve os dados em JSON
@RestController
//Define o endereço base, todas as rotas abaixo começam com /pacientes
@RequestMapping("/pacientes")
public class PacienteController {

    //Usado para salvar, buscar e apagar pacientes no banco

    private final PacienteService pacienteService;

    //O Spring entrega o repository pronto aqui (injeção de dependência), não precisa dar new
    public PacienteController(PacienteService service) {
        this.pacienteService = service;
    }

    //CREATE: responde ao POST /pacientes e cadastra um novo paciente
    //@RequestBody transforma o JSON enviado em um objeto PacienteEntity
    //@Valid ativa as validações da Entity (nome e cpf obrigatórios), se falhar devolve erro 400
    //Devolve o paciente salvo (já com o id) e o status 201 (Created)
    @PostMapping
    public ResponseEntity<PacienteEntity> criar(@Valid @RequestBody PacienteEntity paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.criarPaciente(paciente));
    }

    //READ: responde ao GET /pacientes e devolve a lista de todos os pacientes
    @GetMapping
    public List<PacienteEntity> listar() {
        return pacienteService.listarPaciente();
    }

    //READ: responde ao GET /pacientes/1 e devolve só o paciente com aquele id
    //@PathVariable pega o número que está na URL
    //Se existir devolve 200 (OK), se não existir devolve 404 (Not Found)
    @GetMapping("/{id}")
    public ResponseEntity<PacienteEntity> buscar(@PathVariable Long id) {
        return pacienteService.buscarPacientePorId(id);
    }

    //UPDATE: responde ao PUT /pacientes/1 e altera os dados do paciente com aquele id
    //Primeiro busca o paciente no banco, depois troca os campos pelos novos e salva de novo
    //Se o id não existir devolve 404, não cria um paciente novo
    @PutMapping("/{id}")
    public ResponseEntity<PacienteEntity> atualizar(@PathVariable Long id, @Valid @RequestBody PacienteEntity dados) {
        return pacienteService.atualizarPaciente(id, dados);
    }

    //DELETE: responde ao DELETE /pacientes/1 e apaga o paciente com aquele id
    //Se o id não existir devolve 404, se apagar devolve 204 (No Content, deu certo e não tem nada para mostrar)
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
            return pacienteService.deletarPaciente(id);
        }
}