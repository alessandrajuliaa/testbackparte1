package com.alessandra.backParte1.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alessandra.backParte1.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query(nativeQuery = true,
            value="select p.nome, d.titulo, sum(t.duracao) from pessoa p inner join departamento d on d.id= p.id inner join tarefa t on t.pessoa_id = p.id group by p.nome, d.titulo;")
    public List<Object> getPessoas();

    @Query(nativeQuery = true,
            value="select avg(t.duracao) from tarefa t inner join pessoa p on t.pessoa_id = p.id where p.nome = :nome and t.prazo between :dataInicial and :dataFinal")
    public List<Object> mediaHoras(String nome, Calendar dataInicial, Calendar dataFinal);

    // @Query(nativeQuery = true,
    //         value="select p.nome from pessoa p where p.nome= :nome")
    // public List<Object> mediaHoras(String nome);

}
