package com.alessandra.backParte1.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandra.backParte1.model.Pessoa;
import com.alessandra.backParte1.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa insert(Pessoa pessoa) {
        Pessoa obj = repository.save(pessoa);
        return obj;
    }

    public Pessoa findById(Integer id) {
        Optional<Pessoa> obj = repository.findById(id);
        return obj.get();
    }

    public Pessoa update(Integer id, Pessoa pessoa) {
        System.out.println("Service");
        Optional<Pessoa> pessoaAlterar = repository.findById(id);
        Pessoa pessoaAlterada = null;
        if (pessoaAlterar.isPresent()) {
            updateData(pessoaAlterar.get(), pessoa);
            pessoaAlterada = repository.save(pessoaAlterar.get());
        }
        return pessoaAlterada;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Object> listarPessoas() {
        List<Object> obj = repository.getPessoas();
        return obj;
    }

    public List<Object> mediaHoras(String nome, String dataInicial, String dataFinal) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date inicialD = sdf.parse(dataInicial);
        Calendar inicialC = Calendar.getInstance();
        inicialC.setTime(inicialD);
        Date finalD = sdf.parse(dataFinal);
        Calendar finalC = Calendar.getInstance();
        finalC.setTime(finalD);
        List<Object> obj = repository.mediaHoras(nome, inicialC, finalC);
        // List<Object> obj = repository.mediaHoras(nome);
        return obj;
    }

    private void updateData(Pessoa pessoaAlterar, Pessoa pessoa) {
        pessoaAlterar.setNome(pessoa.getNome());
        pessoaAlterar.setDepartamento(pessoa.getDepartamento());
        pessoaAlterar.setTarefas(pessoa.getTarefas());
    }

}
