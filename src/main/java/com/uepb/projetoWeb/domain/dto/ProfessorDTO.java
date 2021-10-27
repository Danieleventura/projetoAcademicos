package com.uepb.projetoWeb.domain.dto;

import com.uepb.projetoWeb.domain.Endereco;
import com.uepb.projetoWeb.domain.Professor;

import lombok.Data;

@Data
public class ProfessorDTO {
	
	private Long id;
	private String nome;
	private int matricula;
	private String curso;
	private Endereco endereco;
	
	public ProfessorDTO(Professor p) {
		this.id = p.getId();
		this.matricula = p.getMatricula();
		this.nome = p.getNome();
		this.curso = p.getCurso();
		this.endereco = p.getEndereco();
	}
}