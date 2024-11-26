package br.com.alunoonline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;

@Service
public class MatriculaAlunoService {

	@Autowired
	MatriculaAlunoRepository matriculaAlunoRepository;

	//* Método onde o aluno ira se matricular
	public void criarMatricula(MatriculaAluno matriculaAluno) {

		matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
		matriculaAlunoRepository.save(matriculaAluno);

	}

	//* Método onde o aluno ira trancar sua matricula 
	public void trancarMatricula(Long matriculaAlunoId) {

		//? Procura pelo Id via repository a matricula no banco de dados e se não encontrar nada
		//? lança uma exceção para o front end o código HTTP 404(Not Found)
		MatriculaAluno matriculaAluno = 
			matriculaAlunoRepository.findById(matriculaAlunoId)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
			"Matricula Aluno não encontrada"));

		// Se encontrar, continua

		//* Se o status da matricula não for Matriculado
		if (!MatriculaAlunoStatusEnum.MATRICULADO.equals(matriculaAluno.getStatus())) {

			// Lança a exceção para o front o código HTTP 400(Bad Request)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
			"So possível trancar uma matricula com o status MATRICULADO");

		}

		// Caso for Matriculado, continua e define o status para trancado e salva no banco
		matriculaAluno.setStatus(MatriculaAlunoStatusEnum.TRANCADO);
		matriculaAlunoRepository.save(matriculaAluno);

	}

}
