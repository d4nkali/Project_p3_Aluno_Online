package br.com.alunoonline.api.model;

import java.io.Serializable;

import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MatriculaAluno implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne //? Mapeia que aluno pode ter muitas matriculas
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@ManyToOne //? Mapeia que uma disciplina pode ter em muitas matriculas
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;

	// Armazenar as notas
	private Double nota1;
	private Double nota2;

	@Enumerated(EnumType.STRING) //? Define no spring que a enumeração é string
	private MatriculaAlunoStatusEnum status;

}
