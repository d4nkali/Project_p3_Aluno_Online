package br.com.alunoonline.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.service.DisciplinaService;

//? Mapeia a rota de Aluno para as request HTML executar os Endpoints
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	//? Injeta as dependências do service
	@Autowired
	DisciplinaService disciplinaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criarDisciplina(@RequestBody Disciplina disciplina) {

		disciplinaService.criarDisciplina(disciplina);

	}

	@GetMapping("/professor/{professorId}")
	@ResponseStatus(HttpStatus.OK)
	public List<Disciplina> listarDisciplinasDoProf(@PathVariable Long professorId) {

		return disciplinaService.listarDisciplinasDoProf(professorId);

	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Disciplina> listarTodosDisciplinas() {

		return disciplinaService.listarTodosDisciplinas();

	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Disciplina> buscarDisciplinaPorId(@PathVariable Long id) {

		return disciplinaService.buscarDisciplinaPorId(id);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarDisciplinaPorId(@PathVariable Long id) {

		disciplinaService.deletarDisciplinaPorId(id);

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarDisciplinaPorID(@PathVariable Long id, @RequestBody Disciplina disciplina) {

		disciplinaService.atualizarDisciplinaPorID(id, disciplina);

	}

}
