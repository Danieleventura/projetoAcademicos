package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.Professor;
import com.uepb.projetoWeb.domain.dto.ProfessorDTO;
import com.uepb.projetoWeb.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<ProfessorDTO> findAll(){
		return professorRepository.findAll().stream().map(ProfessorDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Professor> findById(Long id) {
		return professorRepository.findById(id);
	}
	
	public List<ProfessorDTO> findByMatricula(String matricula) {
		return professorRepository.findByMatricula(matricula).stream().map(ProfessorDTO::new).collect(Collectors.toList());
	}
	
	public Professor create(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public Professor update(Professor p, Long id) {
		
		Optional<Professor> optional = findById(id);
		if (optional.isPresent()) {
			Professor professorBD = optional.get();
			professorBD.setMatricula(p.getMatricula());
			professorBD.setNome(p.getNome());
			professorBD.setCurso(p.getCurso());
			professorBD.setEndereco(p.getEndereco());
			
			professorRepository.save(professorBD);
			return professorBD;
		}
		else {
			throw new RuntimeException("Erro ao atualizar o professor!");
		}
	}
	
	public void delete(Long id) {
		Optional<Professor> professor = findById(id);
		if(professor.isPresent()) {
			professorRepository.deleteById(id);
		}
	}

}