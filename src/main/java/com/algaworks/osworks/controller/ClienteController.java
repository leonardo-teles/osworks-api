package com.algaworks.osworks.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente c1 = new Cliente();
		c1.setId(1L);
		c1.setNome("Leonardo Teles de Almeida");
		c1.setEmail("leonardo@mail.com");
		c1.setTelefone("98765-4321");
		
		Cliente c2 = new Cliente();
		c2.setId(2L);
		c2.setNome("Manuela Souza de Almeida");
		c2.setEmail("manuela@mail.com");
		c2.setTelefone("2345-6789");
		
		return Arrays.asList(c1, c2);
	}
}
