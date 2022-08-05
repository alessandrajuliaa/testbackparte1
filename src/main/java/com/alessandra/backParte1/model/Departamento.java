package com.alessandra.backParte1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "departamento")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String titulo;
    @JsonIgnore
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Pessoa> pessoas = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(Integer id, String titulo, List<Pessoa> pessoas, List<Tarefa> tarefas) {
        this.id = id;
        this.titulo = titulo;
        this.pessoas = pessoas;
        this.tarefas = tarefas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    // public void setPessoas(List<Pessoa> pessoas) {
    // this.pessoas = pessoas;
    // }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    // public void setTarefas(List<Tarefa> tarefas) {
    // this.tarefas = tarefas;
    // }

}
