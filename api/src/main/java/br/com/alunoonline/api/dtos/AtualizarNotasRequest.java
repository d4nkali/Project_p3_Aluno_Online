package br.com.alunoonline.api.dtos;

import lombok.Data;

// Data Transfer Object apenas para atualizar nota1 e nota2 de MatriculaAluno

@Data
public class AtualizarNotasRequest {

	private Double nota1;
	private Double nota2;

}