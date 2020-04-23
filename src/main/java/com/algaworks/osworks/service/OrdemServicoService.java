package com.algaworks.osworks.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.enums.StatusOrdemServico;
import com.algaworks.osworks.exception.NegocioException;
import com.algaworks.osworks.model.Cliente;
import com.algaworks.osworks.model.OrdemServico;
import com.algaworks.osworks.repository.ClienteRepository;
import com.algaworks.osworks.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository servicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
		
		return servicoRepository.save(ordemServico);
	}
	
}
