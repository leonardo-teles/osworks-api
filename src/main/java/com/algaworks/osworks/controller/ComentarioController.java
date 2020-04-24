package com.algaworks.osworks.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.dto.ComentarioDTO;
import com.algaworks.osworks.dto.ComentarioInput;
import com.algaworks.osworks.exception.EntidadeNaoEncontradaException;
import com.algaworks.osworks.model.Comentario;
import com.algaworks.osworks.model.OrdemServico;
import com.algaworks.osworks.repository.OrdemServicoRepository;
import com.algaworks.osworks.service.OrdemServicoService;

@RestController
@RequestMapping("/ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {

	@Autowired
	private OrdemServicoService servicoService;
	
	@Autowired
	private OrdemServicoRepository servicoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<ComentarioDTO> listar(@PathVariable Long ordemServicoId) {
		OrdemServico ordemServico = servicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada"));
		
		return toCollectionDto(ordemServico.getComentarios());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ComentarioDTO adicionar(@PathVariable Long ordemServicoId,@Valid @RequestBody ComentarioInput comentarioInput) {
		Comentario comentario = servicoService.adicionarComentario(ordemServicoId, comentarioInput.getDescricao());
		
		return toDto(comentario);
	}

	private ComentarioDTO toDto(Comentario comentario) {
		return modelMapper.map(comentario, ComentarioDTO.class);
	}
	
	private List<ComentarioDTO> toCollectionDto(List<Comentario> comentarios) {
		return comentarios.stream()
				.map(comentario -> toDto(comentario))
				.collect(Collectors.toList());
	}
}
