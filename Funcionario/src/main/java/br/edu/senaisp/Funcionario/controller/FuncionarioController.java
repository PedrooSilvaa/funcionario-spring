package br.edu.senaisp.Funcionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.Funcionario.model.Funcionario;
import br.edu.senaisp.Funcionario.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository repository;
	
		@GetMapping
		public List<Funcionario> listar() {
			return repository.lista();
		}
	
		
		@GetMapping("/{id}")
		public Funcionario buscarById(@PathVariable int id) {
			System.out.println(id);
			return repository.buscarPorId(id);
		}

		
		@PutMapping("/{id}")
		public Funcionario altere(@PathVariable int id, @RequestBody Funcionario funcionario) {
			return repository.alterar(funcionario, id);
		}
		
		@PostMapping
		public List<Funcionario> inserir(@RequestBody Funcionario funcionario) {
			return repository.inserir(funcionario);
			
		}
		
		@DeleteMapping("/{id}")
		public void deletar(@PathVariable int id) {
			repository.delete(id);
		}
}
