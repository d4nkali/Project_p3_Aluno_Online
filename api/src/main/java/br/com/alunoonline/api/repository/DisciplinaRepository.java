package br.com.alunoonline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alunoonline.api.model.Disciplina;
import java.util.List;


@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

	// Cria uma lista das disciplinas ligadas pelo id do professor
	List<Disciplina> findByProfessorId(Long professorId);

}
