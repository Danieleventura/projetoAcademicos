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

import com.uepb.projetoWeb.domain.Aluno;
import com.uepb.projetoWeb.domain.Professor;
import com.uepb.projetoWeb.domain.Projeto;
import com.uepb.projetoWeb.domain.dto.ProjetoDTO;
import com.uepb.projetoWeb.service.AlunoService;
import com.uepb.projetoWeb.service.ProfessorService;
import com.uepb.projetoWeb.service.ProjetoService;

@RestController
@RequestMapping("/api/v1/projeto")
public class ProjetoController {
	
	@Autowired
	private ProfessorService serviceProfessor;
	
	@Autowired
	private ProjetoService service;
	
	@Autowired
	private AlunoService serviceAluno;
	
	
	@GetMapping
	public ResponseEntity<List<ProjetoDTO>> get() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Projeto> get(@PathVariable("id") Long id) {
		Optional<Projeto> projeto = service.findById(id);
		return projeto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/area/{area}")
	public ResponseEntity<List<ProjetoDTO>> findByArea(@PathVariable("area") String area) {
		List<ProjetoDTO> listaProjetos = service.findByAreaProjeto(area);
		return listaProjetos.isEmpty() ? 
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(listaProjetos);
	}
	
	@PostMapping
	public String createProjeto(@RequestBody Projeto projeto) {
		Projeto c = service.create(projeto);
		return "Projeto criado com sucesso: " + c.getId();
	}
	
	@PutMapping("/{id}/aluno/{alunoId}")
	public String vincularAluno(@PathVariable("id") Long id, @PathVariable("alunoId") Long alunoId) {
		Optional<Aluno> aluno = serviceAluno.findById(alunoId);
		service.vincularAluno(aluno, id);
		return "Aluno vinculado ao projeto com sucesso!";
	}
	
	@PutMapping("/{id}/professor/{professorId}")
	public String vincularProfessor(@PathVariable("id") Long id, @PathVariable("professorId") Long professorId) {
		Optional<Professor> professor = serviceProfessor.findById(professorId);
		service.vincularProfessor(professor, professorId);
		return "Professor vinculado ao projeto com sucesso!";
	}
	
	@PutMapping("/{id}")
	public String updateProjeto(@PathVariable("id") Long id, @RequestBody Projeto projeto) {
		Projeto c = service.update(projeto, id);
		return "Projeto atualizado com sucesso: " + c.getId();
	}
	
	@DeleteMapping("/{id}")
	public String deleteProjeto(@PathVariable("id") Long id) {
		service.delete(id);
		return "Projeto removido com sucesso!";
	}
	
}