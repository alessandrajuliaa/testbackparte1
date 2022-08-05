package com.alessandra.backParte1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandra.backParte1.model.Pessoa;
import com.alessandra.backParte1.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa insert(Pessoa pessoa) {
        Pessoa obj = repository.save(pessoa);
        return obj;
    }

    public Pessoa update(Integer id, Pessoa pessoa) {
        Pessoa pessoaAlterar = repository.getReferenceById(id);
        if (!pessoaAlterar.equals(null)) {
            updateData(pessoaAlterar, pessoa);
            pessoaAlterar = repository.save(pessoaAlterar);
        }
        return pessoaAlterar;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    // public List<Pessoa> listarPessoas() {
    // Pessoa obj = repository.save();
    // return obj;
    // }

    private void updateData(Pessoa pessoaAlterar, Pessoa pessoa) {
        pessoaAlterar.setNome(pessoa.getNome());
        pessoaAlterar.setDepartamento(pessoa.getDepartamento());
        pessoaAlterar.setTarefas(pessoa.getTarefas());
    }

}
