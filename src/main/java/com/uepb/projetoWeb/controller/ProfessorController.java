package com.uepb.projetoWeb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uepb.projetoWeb.domain.Professor;
import com.uepb.projetoWeb.domain.dto.ProfessorDTO;
import com.uepb.projetoWeb.service.ProfessorService;


@RestController
@RequestMapping("/api/v1/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping
	public ResponseEntity<List<ProfessorDTO>> get() {
		return ResponseEntity.ok(professorService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Professor> get(@PathVariable("id") Long id) {
		Optional<Professor> professor = professorService.findById(id);
		return professor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<List<ProfessorDTO>> getProfessoresByMatricula(@PathVariable("matricula") String matricula) {
		List<ProfessorDTO> listaProfessores = professorService.findByMatricula(matricula);
		return listaProfessores.isEmpty() ? 
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(listaProfessores);
	}
	
	@PutMapping("/{id}")
	public String updateProfessor(@PathVariable("id") Long id, @RequestBody Professor professor) {
		Professor c = professorService.update(professor, id);
		return "Professor atualizado com sucesso: " + c.getId();
	}
	
	@PostMapping
	public String createProfessor(@RequestBody Professor professor) {
		Professor c = professorService.create(professor);
		return "Professor salvo com sucesso: " + c.getId();
	}
	
	@DeleteMapping("/{id}")
	public String deleteProfessor(@PathVariable("id") Long id) {
		professorService.delete(id);
		return "Professor removido com sucesso!";
	}
	
}