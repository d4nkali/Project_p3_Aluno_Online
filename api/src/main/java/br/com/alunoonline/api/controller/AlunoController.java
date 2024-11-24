package br.com.alunoonline.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;

//? Mapeia a rota de Aluno para as request HTML executar os Endpoints
@RestController
@RequestMapping("/alunos")
public class AlunoController {

	//? Injeta as dependências do service
	@Autowired
	AlunoService alunoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criarAluno(@RequestBody Aluno aluno) {

		alunoService.criarAluno(aluno);

	}

}
