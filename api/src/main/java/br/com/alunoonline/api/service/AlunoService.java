package br.com.alunoonline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alunoonline.api.repository.AlunoRepository;

@Service
public class AlunoService {

	//? Injeta AlunoRepository no service
	@Autowired
	AlunoRepository alunoRepository;

}
