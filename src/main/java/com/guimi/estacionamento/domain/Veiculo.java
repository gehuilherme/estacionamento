package com.guimi.estacionamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "É necessário digitar a placa do veículo")
    private String placa;

    @JsonIgnore
    @ManyToOne
    private Cliente cliente;

    @JsonIgnore
    @OneToOne(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private Vaga vaga;

    public Veiculo() {
    }

    public Veiculo(@NotEmpty(message = "É necessário digitar a placa do veículo") String placa, Cliente cliente) {
        this.placa = placa;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
}
