package com.algaworks.osworks.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.enums.StatusOrdemServico;
import com.algaworks.osworks.model.OrdemServico;
import com.algaworks.osworks.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository servicoRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
		
		return servicoRepository.save(ordemServico);
	}
	
}
