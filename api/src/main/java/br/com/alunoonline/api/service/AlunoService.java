package br.com.alunoonline.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
