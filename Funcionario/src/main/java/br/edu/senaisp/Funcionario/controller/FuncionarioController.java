package br.edu.senaisp.Funcionario.controller;

import java.util.List;

import br.edu.senaisp.Funcionario.model.Funcionario;
import br.edu.senaisp.Funcionario.repository.IFuncionarioRepository;
import br.edu.senaisp.Funcionario.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@PostMapping
	public Funcionario salvar(@RequestBody Funcionario funcionario){
		return funcionarioService.salvarFuncionario(funcionario);
	}

	@GetMapping
	public List<Funcionario> listar(){
		return funcionarioService.listarTodos();
	}

	@GetMapping("/{id}")
	public Funcionario buscarId(@PathVariable int id){
		return funcionarioService.buscarPorId(id);
	}

	@PutMapping("/{id}")
	public Funcionario alterarFuncionario(@RequestBody @Valid Funcionario funcionario, @PathVariable int id){
		return funcionarioService.alterar(id, funcionario);
	}

	@DeleteMapping("/{id}")
	public String deletarFuncionario(@PathVariable int id){
		return funcionarioService.delete(id);
	}

}
