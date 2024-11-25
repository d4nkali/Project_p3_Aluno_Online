package br.com.alunoonline.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;

@Service // Define a interface como um Service para o Spring
public class AlunoService {

	//? Injeta o repository no service
	@Autowired
	AlunoRepository alunoRepository;

	//* Método para Criar Aluno no Banco
	public void criarAluno(Aluno aluno) { 

		alunoRepository.save(aluno); // Salva as informações no banco de dados

	}

	//* Método para Listar Todos os Alunos no Banco
	public List<Aluno> listarTodosAlunos() {

		return alunoRepository.findAll();

	}

	//* Método para Listar o Aluno pelo seu id no banco
	public Optional<Aluno> buscarAlunoPorId(Long id) {

		return alunoRepository.findById(id);

	}

	//* Método para Deletar o Aluno do banco pelo id
	public void deletarAlunoPorId(Long id) {

		alunoRepository.deleteById(id);

	}

	//* Método para atualizar um aluno pelo id no banco
	public void atualizarAlunoPorID(Long id, Aluno aluno) {

		//* Verificar se existe no Banco de Dados
		Optional<Aluno> alunoDoBancoDeDados = buscarAlunoPorId(id);

		//* Caso não exista:
		if (alunoDoBancoDeDados.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado no banco de dados");

		}

		//* Se chegar aqui quer dizer que existe o aluno, então:

		Aluno alunoEditado = alunoDoBancoDeDados.get();

		// Com esse aluno editado de cima, faço os sets necessários para atualizar os atributos
		alunoEditado.setNome(aluno.getNome());
		alunoEditado.setCpf(aluno.getCpf());
		alunoEditado.setEmail(aluno.getEmail());

		// Com o aluno totalmente editado acima, devolve ele atualizado ao banco de dados e salva
		alunoRepository.save(alunoEditado);

	}

}
