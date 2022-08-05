package com.alessandra.backParte1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alessandra.backParte1.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
   // select p.nome, sum(t.duracao) from pessoa p inner join tarefa t on t.pessoa_id=p.id group by p.nome limit 1; 
    @Query(nativeQuery = true,
            value="select * from tarefa t where pessoa_id is null order by t.prazo limit 3;")
    public List<Object> get();

}
