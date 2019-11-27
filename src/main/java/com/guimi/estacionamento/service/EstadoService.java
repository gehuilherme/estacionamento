package com.guimi.estacionamento.service;

import com.guimi.estacionamento.domain.Cliente;
import com.guimi.estacionamento.domain.Estado;
import com.guimi.estacionamento.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> listarTodos(){
        return this.estadoRepository.findAll();
    }

    public Optional<Estado> listarPorId(Integer id) {
        return this.estadoRepository.findById(id);
    }

    public Estado cadastrar(Estado estado) {
        return this.estadoRepository.save(estado);
    }

    public Estado atualizar(Estado estado) {
        return this.estadoRepository.save(estado);
    }

    public void remover(Integer id) {
        this.estadoRepository.deleteById(id);
    }
}
