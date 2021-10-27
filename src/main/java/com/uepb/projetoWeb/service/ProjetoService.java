package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.Aluno;
import com.uepb.projetoWeb.domain.Professor;
import com.uepb.projetoWeb.domain.Projeto;
import com.uepb.projetoWeb.domain.dto.ProjetoDTO;
import com.uepb.projetoWeb.repository.ProjetoRepository;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	public List<ProjetoDTO> findAll(){
		return projetoRepository.findAll().stream().map(ProjetoDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Projeto> findById(Long id) {
		return projetoRepository.findById(id);
	}
	
	public List<ProjetoDTO> findByAreaProjeto(String area) {
		return projetoRepository.findByAreaProjeto(area).stream().map(ProjetoDTO::new).collect(Collectors.toList());
	}
	
	public Projeto create(Projeto projeto) {
		return projetoRepository.save(projeto);
	}
	
	public Projeto update(Projeto p, Long id) {
		
		Optional<Projeto> optional = findById(id);
		if (optional.isPresent()) {
			Projeto projetoBD = optional.get();
			projetoBD.setTitulo(p.getTitulo());
			projetoBD.setAreaProjeto(p.getAreaProjeto());
			projetoBD.setResumo(p.getResumo());
			projetoBD.setPalavraChave1(p.getPalavraChave1());
			projetoBD.setPalavraChave2(p.getPalavraChave2());
			projetoBD.setPalavraChave3(p.getPalavraChave3());
			projetoBD.setUrlDocumento(p.getUrlDocumento());
			projetoBD.setProfessorResponsavel(p.getProfessorResponsavel());
			projetoBD.setAlunos(p.getAlunos());
			
			projetoRepository.save(projetoBD);
			return projetoBD;
		}
		else {
			throw new RuntimeException("Erro ao atualizar o projeto!");
		}
	}
	
	public Projeto vincularAluno(Optional<Aluno> a, Long id) {
		Optional<Projeto> p = findById(id);
		if (a.isPresent() && p.isPresent()) {
			Projeto projeto = p.get();
			Aluno aluno = a.get();
			projeto.getAlunos().add(aluno);
			projetoRepository.save(projeto);
			return projeto;
		}else {
			throw new RuntimeException("Erro ao vincular aluno ao projeto!");
		}
	}
	
	public Projeto vincularProfessor(Optional<Professor> prof, Long id) {
		Optional<Projeto> proj = findById(id);
		if (prof.isPresent() && proj.isPresent()) {
			Projeto projeto = proj.get();
			Professor professor = prof.get();
			projeto.setProfessorResponsavel(professor);
			projetoRepository.save(projeto);
			return projeto;
		}else {
			throw new RuntimeException("Erro ao vincular professor ao projeto!");
		}
	}
	
	public void delete(Long id) {
		Optional<Projeto> projeto = findById(id);
		if(projeto.isPresent()) {
			projetoRepository.deleteById(id);
		}
	}

}