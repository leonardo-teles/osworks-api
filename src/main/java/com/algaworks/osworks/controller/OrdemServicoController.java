package com.algaworks.osworks.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.dto.OrdemServicoDTO;
import com.algaworks.osworks.dto.OrdemServicoInput;
import com.algaworks.osworks.model.OrdemServico;
import com.algaworks.osworks.repository.OrdemServicoRepository;
import com.algaworks.osworks.service.OrdemServicoService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoService servicoService;
	
	@Autowired
	private OrdemServicoRepository servicoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServicoDTO criar(@Valid @RequestBody OrdemServicoInput ordemServicoInput) {
		OrdemServico ordemServico = toEntity(ordemServicoInput);
		
		return toDto(servicoService.criar(ordemServico));
	}
	
	@GetMapping
	public List<OrdemServicoDTO> listar() {
		return toCollectionDto(servicoRepository.findAll());
	}
	
	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<OrdemServicoDTO> buscar(@PathVariable Long ordemServicoId) {
		Optional<OrdemServico> ordemServico = servicoRepository.findById(ordemServicoId);
		
		if (ordemServico.isPresent()) {
			OrdemServicoDTO dto = toDto(ordemServico.get());
			
			return ResponseEntity.ok(dto);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	private OrdemServicoDTO toDto(OrdemServico ordemServico) {
		return modelMapper.map(ordemServico, OrdemServicoDTO.class);
	}
	
	private List<OrdemServicoDTO> toCollectionDto(List<OrdemServico> ordensServico) {
		return ordensServico.stream()
				.map(ordemServico -> toDto(ordemServico))
				.collect(Collectors.toList());
	}
	
	private OrdemServico toEntity(OrdemServicoInput ordemServicoInput) {
		return modelMapper.map(ordemServicoInput, OrdemServico.class);
	}
	
}
