package com.uepb.projetoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String rua;
	
	@Column
	private String numero;
	
	@Column
	private String cep;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
	
	@Column
	private String pais;
}
