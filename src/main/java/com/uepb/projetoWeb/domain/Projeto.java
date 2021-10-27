package com.uepb.projetoWeb.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String titulo;
	
	@Column(name = "area_projeto")
	private String areaProjeto;
	
	@Column
	private String resumo;
	
	@Column(name = "palavra_chave1")
	private String palavraChave1;
	
	@Column(name = "palavra_chave2")
	private String palavraChave2;
	
	@Column(name = "palavra_chave3")
	private String palavraChave3;
	
	@Column(name = "url_documento")
	private String urlDocumento;
	
	@OneToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fk_professor_id", foreignKey = @ForeignKey(name = "fk_professor"), referencedColumnName = "id")
	private Professor professorResponsavel;
	
	@OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "lista_alunos", 
    			joinColumns={@JoinColumn(name="fK_projeto_id", foreignKey = @ForeignKey(name = "fk_projeto"), referencedColumnName = "id")},
    			inverseJoinColumns={@JoinColumn(name="fk_aluno_id", foreignKey = @ForeignKey(name = "fk_aluno"), referencedColumnName = "id")})
	private List<Aluno> alunos;
}
