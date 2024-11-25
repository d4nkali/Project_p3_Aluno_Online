package br.com.alunoonline.api.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Gera os Construtores da Classe da Entidade
@NoArgsConstructor
@AllArgsConstructor
@Data //? Gera os Get e Set
@Entity //? Define como Entidade no Projeto
public class Professor implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Spring automaticamente gera um Id
	private long id;

	private String nome;

	private String email;

	private String cpf;

}