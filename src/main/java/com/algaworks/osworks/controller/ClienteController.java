package com.algaworks.osworks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.model.Cliente;
import com.algaworks.osworks.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/clientes/{clienteId}")
	public Cliente buscar(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		return cliente.orElse(null);
		
	}
}
