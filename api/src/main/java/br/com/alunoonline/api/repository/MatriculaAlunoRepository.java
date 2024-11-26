package br.com.alunoonline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alunoonline.api.model.MatriculaAluno;

@Repository
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {

}
