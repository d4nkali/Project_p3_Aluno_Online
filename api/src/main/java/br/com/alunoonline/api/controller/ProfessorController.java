package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ProfessorService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//? Mapeia a rota base de Professor para as request HTML executar os Endpoints
@RestController
@RequestMapping("/professor")
public class ProfessorController {

	//? Injeta as dependências do service
	@Autowired
	ProfessorService professorService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criarProfessor(@RequestBody Professor professor) {

		professorService.criarProfessor(professor);

	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Professor> listarTodosProfessor() {

		return professorService.listarTodosProfessor();

	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Professor> buscarProfessorPorId(@PathVariable Long id) {

		return professorService.buscarProfessorPorId(id);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarProfessorPorId(@PathVariable Long id) {

		professorService.deletarProfessorPorId(id);

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarProfessorPorID(@PathVariable Long id, @RequestBody Professor professor) {

		professorService.atualizarProfessorPorID(id, professor);

	}

}