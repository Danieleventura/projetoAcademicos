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
import lombok.NoArgsConstructor;

@Entity(name = "professor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int matricula;
	
	@Column
	private String nome;
	
	@Column
	private String curso;
	
	@NotNull()
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_endereco_id", foreignKey = @ForeignKey(name = "professor_endereco"), referencedColumnName = "id")
	private Endereco endereco;
	
}
