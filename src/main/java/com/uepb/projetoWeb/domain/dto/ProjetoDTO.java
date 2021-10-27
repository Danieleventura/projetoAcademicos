package com.uepb.projetoWeb.domain.dto;

import java.util.List;

import com.uepb.projetoWeb.domain.Aluno;
import com.uepb.projetoWeb.domain.Professor;
import com.uepb.projetoWeb.domain.Projeto;

import lombok.Data;

@Data
public class ProjetoDTO {
	
	private Long id;
	private String titulo;
	private String areaProjeto;
	private String resumo;
	private String palavraChave1;
	private String palavraChave2;
	private String palavraChave3;
	private String urlDocumento;
	private Professor professorResponsavel;
	private List<Aluno> aluno;
	
	public ProjetoDTO(Projeto p) {
		this.id = p.getId();
		this.titulo = p.getTitulo();
		this.areaProjeto = p.getAreaProjeto();
		this.resumo = p.getResumo();
		this.palavraChave1 = p.getPalavraChave1();
		this.palavraChave2 = p.getPalavraChave2();
		this.palavraChave3 = p.getPalavraChave3();
		this.urlDocumento = p.getUrlDocumento();
		this.professorResponsavel = p.getProfessorResponsavel();
		this.aluno = p.getAlunos();
	}
}