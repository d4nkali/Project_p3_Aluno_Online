package br.com.alunoonline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alunoonline.api.model.Aluno;

@Repository // Define a interface como um Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	

}
