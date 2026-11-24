package chamamed.uniesp.Repository;

import chamamed.uniesp.Entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface que conversa com o banco de dados, não precisa escrever SQL nem implementar nada
//O Spring cria a implementação sozinho quando o projeto sobe
//<PacienteEntity, Long> = tabela que ele acessa, e o tipo do Id dela
//Já vem pronto: save, findAll, findById, existsById, deleteById, etc.
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
}