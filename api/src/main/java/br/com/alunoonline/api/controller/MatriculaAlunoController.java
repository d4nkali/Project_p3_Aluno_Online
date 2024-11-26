package br.com.alunoonline.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.alunoonline.api.dtos.AtualizarNotasRequest;
import br.com.alunoonline.api.dtos.HistoricoAlunoResponse;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.service.MatriculaAlunoService;

@RestController
@RequestMapping("matriculas-alunos")
public class MatriculaAlunoController {

	@Autowired
	MatriculaAlunoService matriculaAlunoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criarMatricula(@RequestBody MatriculaAluno matriculaAluno) {

		matriculaAlunoService.criarMatricula(matriculaAluno);

	}

	@PatchMapping("/trancar/{id}") // Mapeia para usar o método Patch
	@ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o código 204(No Content)
	public void trancarMatricula(@PathVariable Long id) {

		matriculaAlunoService.trancarMatricula(id);

	}

	@PatchMapping("/atualiza-notas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarNotas(@RequestBody AtualizarNotasRequest atualizarNotasRequest, 
	@PathVariable Long id){

		matriculaAlunoService.atualizarNotas(id, atualizarNotasRequest);

	}

	@GetMapping("/emitir-historico/{alunoId}")
	@ResponseStatus(HttpStatus.OK)
	public HistoricoAlunoResponse emitirHistorico(@PathVariable Long alunoId) {

		return matriculaAlunoService.emitirHistorico(alunoId);

	}

}
