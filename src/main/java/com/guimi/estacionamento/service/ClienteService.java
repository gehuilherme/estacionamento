package com.guimi.estacionamento.service;

import com.guimi.estacionamento.domain.Cliente;
import com.guimi.estacionamento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> listarPorId(Integer id) {
        return this.clienteRepository.findById(id);
    }

    public Cliente cadastrar(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public void remover(Integer id) {
        this.clienteRepository.deleteById(id);
    }

}
