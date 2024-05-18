package br.edu.senaisp.Funcionario.repository;

import br.edu.senaisp.Funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFuncionarioRepository extends JpaRepository <Funcionario, Integer> {
}
