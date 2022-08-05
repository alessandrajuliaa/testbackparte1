package com.alessandra.backParte1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandra.backParte1.model.Pessoa;
import com.alessandra.backParte1.model.Tarefa;
import com.alessandra.backParte1.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private PessoaService servicePessoa;

    public List<Tarefa> getTarefasPendentes() {
        List<Tarefa> obj = repository.getTarefasPendentes();
        return obj;
    }

    public Tarefa insert(Tarefa tarefa) {
        Tarefa obj = repository.save(tarefa);
        return obj;
    }

    public Tarefa update(Integer id, Tarefa tarefa) {
        Pessoa p = servicePessoa.findById(id);
        // Optional<Tarefa> tarefaAlterar = repository.findById(id);
        Tarefa alterada = null;
        if(p.getDepartamento().getId() == tarefa.getDepartamento().getId()){
            tarefa.setPessoa(p);
            alterada = repository.save(tarefa);
        }
        return alterada;
    }

    public Tarefa finalizar(Integer id) {
        Tarefa finalizar = repository.getReferenceById(id);
        if (!finalizar.equals(null)) {
            finalizar.setFinalizado(true);
            finalizar = repository.save(finalizar);
        }
        return finalizar;
    }

}
