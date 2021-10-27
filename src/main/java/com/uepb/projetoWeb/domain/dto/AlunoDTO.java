package com.uepb.projetoWeb.domain.dto;

import com.uepb.projetoWeb.domain.Aluno;
import com.uepb.projetoWeb.domain.Endereco;

import lombok.Data;

@Data
public class AlunoDTO {
	
	private Long id;
	private String nome;
	private int matricula;
	private String cpf;
	private String curso;
	private Endereco endereco;
	
	public AlunoDTO(Aluno a) {
		this.id = a.getId();
		this.matricula = a.getMatricula();
		this.nome = a.getNome();
		this.cpf = a.getCpf();
		this.curso = a.getCurso();
		this.endereco = a.getEndereco();
	}
}
