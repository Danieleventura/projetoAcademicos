package com.uepb.projetoWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uepb.projetoWeb.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	List<Aluno> findByMatricula(String matricula);
}
