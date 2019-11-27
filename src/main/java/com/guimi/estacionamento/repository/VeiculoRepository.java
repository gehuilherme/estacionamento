package com.guimi.estacionamento.repository;

import com.guimi.estacionamento.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
}
