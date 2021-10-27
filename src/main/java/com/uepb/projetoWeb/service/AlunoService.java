package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.Aluno;
import com.uepb.projetoWeb.domain.dto.AlunoDTO;
import com.uepb.projetoWeb.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<AlunoDTO> findAll(){
		return alunoRepository.findAll().stream().map(AlunoDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Aluno> findById(Long id) {
		return alunoRepository.findById(id);
	}
	
	public List<AlunoDTO> findByMatricula(String matricula) {
		return alunoRepository.findByMatricula(matricula).stream().map(AlunoDTO::new).collect(Collectors.toList());
	}
	
	public Aluno create(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno update(Aluno a, Long id) {
		
		Optional<Aluno> optional = findById(id);
		if (optional.isPresent()) {
			Aluno alunoBD = optional.get();
			alunoBD.setMatricula(a.getMatricula());
			alunoBD.setNome(a.getNome());
			alunoBD.setCpf(a.getCpf());
			alunoBD.setCurso(a.getCurso());
			alunoBD.setEndereco(a.getEndereco());
			
			alunoRepository.save(alunoBD);
			return alunoBD;
		}
		else {
			throw new RuntimeException("Erro ao atualizar o aluno!");
		}
	}
	
	public void delete(Long id) {
		Optional<Aluno> aluno = findById(id);
		if(aluno.isPresent()) {
			alunoRepository.deleteById(id);
		}
	}

}
