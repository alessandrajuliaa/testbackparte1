package com.alessandra.backParte1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alessandra.backParte1.model.Departamento;
import com.alessandra.backParte1.services.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping()
    public ResponseEntity<List<Object>> get() {
        List<Object> obj = service.get();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping()
    public ResponseEntity<Departamento> insert(@RequestBody Departamento departamento) {
        Departamento obj = service.insert(departamento);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping()
    public ResponseEntity<List<Departamento>> getAll() {
        List<Departamento> listAll = service.getAll();
        return ResponseEntity.ok().body(listAll);
    }

}
