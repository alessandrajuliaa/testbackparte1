package com.alessandra.backParte1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandra.backParte1.model.Departamento;
import com.alessandra.backParte1.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    public Departamento insert(Departamento departamento) {
        Departamento obj = repository.save(departamento);
        return obj;
    }

    public List<Departamento> getAll() {
        List<Departamento> listAll = repository.findAll();
        return listAll;
    }

}
