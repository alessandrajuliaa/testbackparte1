package com.alessandra.backParte1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alessandra.backParte1.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    @Query(nativeQuery = true,
            value="select * from tarefa t where pessoa_id is null order by t.prazo limit 3;")
    public List<Tarefa> getTarefasPendentes();

}
