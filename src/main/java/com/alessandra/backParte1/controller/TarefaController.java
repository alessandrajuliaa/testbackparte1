package com.alessandra.backParte1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alessandra.backParte1.model.Tarefa;
import com.alessandra.backParte1.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping()
    public ResponseEntity<Tarefa> insert(@RequestBody Tarefa tarefa) {
        Tarefa obj = tarefaService.insert(tarefa);
        return ResponseEntity.ok().body(obj);
    }

    // @PutMapping("/alocar/{id}")
    // public ResponseEntity<Tarefa> update(@PathVariable Integer id, @RequestBody
    // Tarefa tarefa) {
    // Tarefa obj = tarefaService.update(id, tarefa);
    // return ResponseEntity.ok().body(obj);
    // }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Tarefa> finalizar(@PathVariable Integer id) {
        Tarefa obj = tarefaService.finalizar(id);
        return ResponseEntity.ok().body(obj);
    }

}
