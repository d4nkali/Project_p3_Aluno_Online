package br.com.alunoonline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.alunoonline.api.dtos.AtualizarNotasRequest;
import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;

@Service
public class MatriculaAlunoService {

	@Autowired
	MatriculaAlunoRepository matriculaAlunoRepository;

	public static final double MEDIA_PARA_APROVACAO = 7.0; // Define o valor da media para aprovação

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

	//* Método para professor atualizar as notas
	public void atualizarNotas(Long matriculaAlunoId, AtualizarNotasRequest atualizarNotasRequest) {

		MatriculaAluno matriculaAluno = matriculaAlunoRepository.findById(matriculaAlunoId)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula Aluno não encontrada"));

		//* Verifica se o front está mandando a nota 1
		if (atualizarNotasRequest.getNota1() != null) {

			// Se sim, o 'atualizarNotasRequest.getNota1()' pega a nota 1 do front

			// Atualiza a nota 1 do Banco
			matriculaAluno.setNota1(atualizarNotasRequest.getNota1());

		}

		//* Verifica se o front está mandando a nota 2
		if (atualizarNotasRequest.getNota2() != null) {

			// Se sim, o 'atualizarNotasRequest.getNota2()' pega a nota 2 do front
		
			// Atualiza a nota 2 do Banco
			matriculaAluno.setNota2(atualizarNotasRequest.getNota2());

		}

		// Apos atualizar as notas, chama a função calcularMedia e salva no banco de dados
		calcularMedia(matriculaAluno);
		matriculaAlunoRepository.save(matriculaAluno);

	}

	private void calcularMedia(MatriculaAluno matriculaAluno) {

		Double nota1 = matriculaAluno.getNota1();
		Double nota2 = matriculaAluno.getNota2();

		if (nota1 != null && nota2 != null) {

			Double media = (nota1 + nota2) / 2; // Calcula a media

			/*
			* Se a media for maior que a media para aprovação (?)
			* define como aprovado, senão (:) define como reprovado
			*/
			matriculaAluno.setStatus(media >= MEDIA_PARA_APROVACAO ?
			MatriculaAlunoStatusEnum.APROVADO : 
			MatriculaAlunoStatusEnum.REPROVADO);

		}

	}

}
