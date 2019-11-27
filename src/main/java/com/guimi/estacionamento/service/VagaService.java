package com.guimi.estacionamento.service;

import com.guimi.estacionamento.domain.Vaga;
import com.guimi.estacionamento.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaService {
    @Autowired
    private VagaRepository vagaRepository;

    public List<Vaga> listarTodos(){
        return this.vagaRepository.findAll();
    }

    public Optional<Vaga> listarPorId(Integer id) {
        return this.vagaRepository.findById(id);
    }

    public Vaga cadastrar(Vaga vaga) {
        return this.vagaRepository.save(vaga);
    }

    public Vaga atualizar(Vaga vaga) {
        return this.vagaRepository.save(vaga);
    }

    public void remover(Integer id) {
        this.vagaRepository.deleteById(id);
    }
}
