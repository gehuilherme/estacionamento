package com.guimi.estacionamento.service;

import com.guimi.estacionamento.domain.*;
import com.guimi.estacionamento.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private VagaRepository vagaRepository;

    public void instantiateTestDatabase(){
        Estado e1 = new Estado(null, "Paraná");
        Estado e2 = new Estado(null, "Santa Catarina");
        Estado e3 = new Estado(null, "Rio Grande do Sul");
        Estado e4 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Apucarana", e1);
        Cidade c2 = new Cidade(null, "Arapongas", e1);
        Cidade c3 = new Cidade(null, "Joinvile", e2);
        Cidade c4 = new Cidade(null, "Porto Alegre", e3);
        Cidade c5 = new Cidade(null, "São Paulo", e4);

        e1.getCidades().addAll(Arrays.asList(c1, c2));
        e2.getCidades().addAll(Arrays.asList(c3));
        e3.getCidades().addAll(Arrays.asList(c4));
        e4.getCidades().addAll(Arrays.asList(c5));

        estadoRepository.saveAll(Arrays.asList(e1,e2,e3,e4));
        cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));

        Cliente cli = new Cliente("Guilherme Henrique de Miranda", "guilherme@teste.com", "37714156082", "43998361206", "Av. Curitiba", "112", null, "Centro", "86800000");
        Cliente cli1 = new Cliente("Josevaldo Pedroso", "josevaldo@email.com", "28162150080", "43998885521", "Rua tal", "123", "Fundos", "Centro", "86805270");
        clienteRepository.saveAll(Arrays.asList(cli, cli1));

        Veiculo vei = new Veiculo("AAA1234", cli);
        Veiculo vei1 = new Veiculo("ABC4321", cli1);
        veiculoRepository.saveAll(Arrays.asList(vei, vei1));

        Vaga v1 = new Vaga(true, vei);
        Vaga v2 = new Vaga(false);
        Vaga v3 = new Vaga(false);
        Vaga v4 = new Vaga(true, vei1);
        Vaga v5 = new Vaga(false);

        vagaRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5));
    }
}
