package com.alessandra.backParte1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandra.backParte1.model.Tarefa;
import com.alessandra.backParte1.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public Tarefa insert(Tarefa tarefa) {
        Tarefa obj = repository.save(tarefa);
        return obj;
    }

    // public Tarefa update(Integer id, Tarefa pessoa) {
    // Tarefa pessoaAlterar = tarefaRepository.getReferenceById(id);
    // if (!pessoaAlterar.equals(null)) {
    // updateData(pessoaAlterar, pessoa);
    // pessoaAlterar = tarefaRepository.save(pessoaAlterar);
    // }
    // return pessoaAlterar;
    // }

    public Tarefa finalizar(Integer id) {
        Tarefa finalizar = repository.getReferenceById(id);
        if (!finalizar.equals(null)) {
            finalizar.setFinalizado(true);
            finalizar = repository.save(finalizar);
        }
        return finalizar;
    }

}
