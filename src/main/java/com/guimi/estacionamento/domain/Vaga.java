package com.guimi.estacionamento.domain;

import javax.persistence.*;

@Entity
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean status;

    @OneToOne
    private Veiculo veiculo;

    public Vaga() {
    }

    public Vaga(boolean status) {
        this.status = status;
    }

    public Vaga(boolean status, Veiculo veiculo) {
        this.status = status;
        this.veiculo = veiculo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
