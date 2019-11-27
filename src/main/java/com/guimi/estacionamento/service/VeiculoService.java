package com.guimi.estacionamento.service;

import com.guimi.estacionamento.domain.Veiculo;
import com.guimi.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarTodos(){
        return this.veiculoRepository.findAll();
    }

    public Optional<Veiculo> listarPorId(Integer id) {
        return this.veiculoRepository.findById(id);
    }

    public Veiculo cadastrar(Veiculo estado) {
        return this.veiculoRepository.save(estado);
    }

    public Veiculo atualizar(Veiculo estado) {
        return this.veiculoRepository.save(estado);
    }

    public void remover(Integer id) {
        this.veiculoRepository.deleteById(id);
    }
}
