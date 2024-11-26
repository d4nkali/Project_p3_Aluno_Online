package br.com.alunoonline.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	//? Injeta o repository no service
	@Autowired
	DisciplinaRepository disciplinaRepository;

	//* Método para criar uma disciplina no banco
	public void criarDisciplina(Disciplina disciplina) {

		disciplinaRepository.save(disciplina);

	}

	//* Método para listar as disciplinas ligadas pelo id de um professor
	public List<Disciplina> listarDisciplinasDoProf(Long professoId) {

		return disciplinaRepository.findByProfessorId(professoId);

	}


	//* Método para listar todas as disciplinas do banco
	public List<Disciplina> listarTodosDisciplinas() {

		return disciplinaRepository.findAll();

	}

	//* Método para buscar uma disciplina do banco pelo id
	public Optional<Disciplina> buscarDisciplinaPorId(Long id) {

		return disciplinaRepository.findById(id);

	}

	//* Método para Deletar o professor do banco pelo id
	public void deletarDisciplinaPorId(Long id) {

		disciplinaRepository.deleteById(id);

	}

	//* Método para Atualizar o uma disciplina pelo Id
	public void atualizarDisciplinaPorID(Long id, Disciplina disciplina) {

		//* Verificar se existe no Banco de Dados
		Optional<Disciplina> disciplinaDoBancoDeDados = buscarDisciplinaPorId(id);

		//* Caso não exista:
		if (disciplinaDoBancoDeDados.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada no banco de dados");

		}

		//* Se chegar aqui quer dizer que existe a disciplina, então:

		Disciplina disciplinaEditado = disciplinaDoBancoDeDados.get();

		// Com essa disciplina editada de cima, faço os sets necessários para atualizar os atributos
		disciplinaEditado.setNome(disciplina.getNome());
		disciplinaEditado.setProfessor(disciplina.getProfessor());

		// Com disciplina totalmente editado acima, devolve ele atualizado ao banco de dados
		disciplinaRepository.save(disciplinaEditado);

	}

}
