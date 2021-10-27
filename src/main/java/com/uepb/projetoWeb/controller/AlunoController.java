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
import com.uepb.projetoWeb.domain.dto.AlunoDTO;
import com.uepb.projetoWeb.service.AlunoService;


@RestController
@RequestMapping("/api/v1/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<AlunoDTO>> get() {
		return ResponseEntity.ok(alunoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> get(@PathVariable("id") Long id) {
		Optional<Aluno> aluno = alunoService.findById(id);
		return aluno.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<List<AlunoDTO>> getAlunosByMatricula(@PathVariable("matricula") String matricula) {
		List<AlunoDTO> listaAlunos = alunoService.findByMatricula(matricula);
		return listaAlunos.isEmpty() ? 
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(listaAlunos);
	}
	
	@PutMapping("/{id}")
	public String updateAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
		Aluno c = alunoService.update(aluno, id);
		return "Aluno atualizado com sucesso: " + c.getId();
	}
	
	@PostMapping
	public String createAluno(@RequestBody Aluno aluno) {
		Aluno c = alunoService.create(aluno);
		return "Aluno matriculado com sucesso: " + c.getId();
	}
	
	@DeleteMapping("/{id}")
	public String deleteAluno(@PathVariable("id") Long id) {
		alunoService.delete(id);
		return "Aluno removido com sucesso.";
	}
	
}
