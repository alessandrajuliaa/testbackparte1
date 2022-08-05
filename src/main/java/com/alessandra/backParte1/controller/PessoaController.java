package com.alessandra.backParte1.controller;

import java.text.ParseException;
import java.util.Calendar;
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

    @GetMapping()
    public ResponseEntity<List<Object>> listarPessoas() {
        List<Object> list = pessoaService.listarPessoas();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/gastos/{nome}/{dataInicial}/{dataFinal}")
    public ResponseEntity<List<Object>> mediaHoras(@PathVariable String nome, @PathVariable String dataInicial, @PathVariable String dataFinal) throws ParseException {
        List<Object> list = pessoaService.mediaHoras(nome, dataInicial, dataFinal);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping()
    public ResponseEntity<Pessoa> insert(@RequestBody Pessoa pessoa) {
        Pessoa obj = pessoaService.insert(pessoa);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
        Pessoa obj = pessoaService.update(id, pessoa);
        // Pessoa obj = null;
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

    
}
