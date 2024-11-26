package br.com.alunoonline.api.dtos;

import java.util.List;

import lombok.Data;

// DTO para retornar as informações necessárias para o histórico do aluno

@Data
public class HistoricoAlunoResponse {

	private String nomeAluno;
	private String emailAluno;
	private String cpfAluno;
	// Lista as informações do dto DisciplinasAluno
	private List<DisciplinasAlunoResponse> disciplinasAlunoResponses;

}
