package com.algaworks.osworks.controller;

import java.util.List;

import javax.persistence.*;

import org.springframework.web.bind.annotation.*;

import com.algaworks.osworks.model.Cliente;

@RestController
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return manager.createQuery("from Cliente", Cliente.class).getResultList();
	}
}
