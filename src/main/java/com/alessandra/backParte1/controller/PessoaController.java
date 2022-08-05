package com.alessandra.backParte1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alessandra.backParte1.model.Pessoa;
import com.alessandra.backParte1.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping()
    public ResponseEntity<Pessoa> insert(@RequestBody Pessoa pessoa) {
        Pessoa obj = pessoaService.insert(pessoa);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
        Pessoa obj = pessoaService.update(id, pessoa);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

    // @GetMapping()
    // public ResponseEntity<List<Pessoa>> listarPessoas() {
    // pessoaService.listarPessoas();
    // return ResponseEntity.ok().build();
    // }
}
