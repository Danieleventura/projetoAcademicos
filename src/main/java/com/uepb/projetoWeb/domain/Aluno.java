package com.uepb.projetoWeb.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "aluno")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int matricula;
	
	@Column
	private String nome;
	
	@Column
	private String cpf;
	
	@Column
	private String curso;
	
	@NotNull()
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_endereco_id", foreignKey = @ForeignKey(name = "fk_endereco"), referencedColumnName = "id")
	private Endereco endereco;
}
