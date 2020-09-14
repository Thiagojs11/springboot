package br.com.testesistemas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testesistemas.model.Cliente;
import br.com.testesistemas.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public Cliente salva(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@GetMapping
	public List<Cliente> buscaTodos(){
		return clienteService.buscarTodos();
	}
	
	@GetMapping("{id}")
	public Cliente buscaPorId(@PathVariable Long id) {
		return clienteService.buscarPorId(id);
	}
	
	@DeleteMapping("{id}")
	public void deletaPorId(@PathVariable Long id) {
		clienteService.deletaPorId(id);
	}
	
}
