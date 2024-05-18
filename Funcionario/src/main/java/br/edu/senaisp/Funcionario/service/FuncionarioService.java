package br.edu.senaisp.Funcionario.service;

import br.edu.senaisp.Funcionario.model.Funcionario;
import br.edu.senaisp.Funcionario.repository.IFuncionarioRepository;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FuncionarioService {

    private final IFuncionarioRepository funcionarioRepository;

    public FuncionarioService(IFuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public Funcionario salvarFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @Transactional(readOnly = true)
    public List<Funcionario> listarTodos(){
        try {
            return funcionarioRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Transactional(readOnly = true)
    public Funcionario buscarPorId(int id){
        return funcionarioRepository.findById(id).orElseThrow(
                RuntimeException::new
        );
    }

    @Transactional
    public Funcionario alterar(int id, Funcionario funcionario){
        Funcionario funcionarioAlterado = buscarPorId(id);
        funcionarioAlterado.setNome(funcionario.getNome());
        funcionarioAlterado.setAnoNascimento(funcionario.getAnoNascimento());
        funcionarioAlterado.setFuncao(funcionario.getFuncao());
        return funcionarioAlterado;
    }

    @Transactional
    public String delete(int id){
        funcionarioRepository.deleteById(id);
        return String.format("Funcionario do id = %s foi excluido", id);
    }

}
