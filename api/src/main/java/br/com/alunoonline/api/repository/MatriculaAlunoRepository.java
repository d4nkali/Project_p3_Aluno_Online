package br.com.alunoonline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alunoonline.api.model.MatriculaAluno;
import java.util.List;


@Repository
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {

	// Cria uma lista das matriculas ligadas pelo id do aluno
	List<MatriculaAluno> findByAlunoId(Long alunoId);

}
