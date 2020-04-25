package com.algaworks.osworks.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.enums.StatusOrdemServico;
import com.algaworks.osworks.exception.EntidadeNaoEncontradaException;
import com.algaworks.osworks.exception.NegocioException;
import com.algaworks.osworks.model.Cliente;
import com.algaworks.osworks.model.Comentario;
import com.algaworks.osworks.model.OrdemServico;
import com.algaworks.osworks.repository.ClienteRepository;
import com.algaworks.osworks.repository.ComentarioRepository;
import com.algaworks.osworks.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository servicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		return servicoRepository.save(ordemServico);
	}

	public void finalizar(Long ordemServicoId) {
		OrdemServico ordemServico = buscar(ordemServicoId);
		
		ordemServico.finalizar();
		
		servicoRepository.save(ordemServico);
	}

	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
		OrdemServico ordemServico = buscar(ordemServicoId);
		
		Comentario comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);
		
		return comentarioRepository.save(comentario);
	}
	
	private OrdemServico buscar(Long ordemServicoId) {
		return servicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de Serviço não encontrada"));
	}
	
}
