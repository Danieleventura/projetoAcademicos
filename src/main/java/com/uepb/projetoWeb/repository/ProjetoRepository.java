package com.uepb.projetoWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uepb.projetoWeb.domain.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
	
	List<Projeto> findByAreaProjeto(String areaProjeto);
}