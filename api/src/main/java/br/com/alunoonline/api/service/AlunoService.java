package br.com.alunoonline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;

@Service // Define a interface como um Service para o Spring
public class AlunoService {

	//? Injeta AlunoRepository no service
	@Autowired
	AlunoRepository alunoRepository;

	//* Função para Criar Aluno 
	public void criarAluno(Aluno aluno) { 

		alunoRepository.save(aluno); // Salva as informações no banco de dados

	}

}
