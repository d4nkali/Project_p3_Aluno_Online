package br.com.alunoonline.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;

//? Mapeia a rota de Aluno para as request HTML executar os Endpoints
@RestController
@RequestMapping("/alunos")
public class AlunoController {

	//? Injeta as dependências do service
	@Autowired
	AlunoService alunoService;

	@PostMapping // Mapeia para usar o Método Post
	@ResponseStatus(HttpStatus.CREATED) // Retorna o código 201(Created)
	public void criarAluno(@RequestBody Aluno aluno) { //? @RequestBody converte o body JSON para informações para o Java

		alunoService.criarAluno(aluno);

	}

	@GetMapping // Mapeia para usar o Método Get
	@ResponseStatus(HttpStatus.OK) // Retorna o código 200(Ok)
	public List<Aluno> listarTodosAlunos() {

		return alunoService.listarTodosAlunos();

	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Aluno> buscarAlunoPorId(@PathVariable Long id) {

		return alunoService.buscarAlunoPorId(id);

	}

	@DeleteMapping("/{id}") // Mapeia para usar o método Delete
	@ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o código 204(No Content)
	public void deletarAlunoPorId(@PathVariable Long id) {

		alunoService.deletarAlunoPorId(id);

	}

	@PutMapping("/{id}") // Mapeia para usar o método Put
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarAlunoPorID(@PathVariable Long id, @RequestBody Aluno aluno) {

		alunoService.atualizarAlunoPorID(id, aluno);

	}

}
