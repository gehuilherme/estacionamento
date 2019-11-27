package com.guimi.estacionamento.service;

import com.guimi.estacionamento.domain.Cidade;
import com.guimi.estacionamento.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> listarTodos(){
        return this.cidadeRepository.findAll();
    }

    public Optional<Cidade> listarPorId(Integer id) {
        return this.cidadeRepository.findById(id);
    }

    public Cidade cadastrar(Cidade cidade) {
        return this.cidadeRepository.save(cidade);
    }
    @Transactional
    public Cidade atualizar(Cidade cidade) {
        return this.cidadeRepository.save(cidade);

//        Cidade cidade2 = cidadeRepository.findById(cidade.getId()).get();
//        cidade2.setDescricao();
//        cidade2.setEstado();
    }

    public void remover(Integer id) {
        this.cidadeRepository.deleteById(id);
    }
}
