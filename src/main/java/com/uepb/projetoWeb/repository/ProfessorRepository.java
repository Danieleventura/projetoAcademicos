package com.uepb.projetoWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uepb.projetoWeb.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	List<Professor> findByMatricula(String matricula);
}
