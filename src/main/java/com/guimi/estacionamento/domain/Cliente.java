package com.guimi.estacionamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "Nome não pode estar vazio!")
    private String nome;
    @NotEmpty(message = "Email não pode estar vazio!")
    @Email(message = "Email Inválido!")
    private String email;
    @NotEmpty(message = "CPF não pode estar vazio!")
    @CPF(message = "CPF inválido")
    private String cpf;
    private String telefone;

    //Criar a classe Endereço e fazer os relacionamentos.
    private String logradouro;
    private String numres;
    private String complemento;
    private String bairro;
    private String cep;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(@NotEmpty(message = "Nome não pode estar vazio!") String nome, @NotEmpty(message = "Email não pode estar vazio!") @Email(message = "Email Inválido!") String email, @NotEmpty(message = "CPF não pode estar vazio!") @CPF(message = "CPF inválido") String cpf, String telefone, String logradouro, String numres, String complemento, String bairro, String cep) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numres = numres;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumres() {
        return numres;
    }

    public void setNumres(String numres) {
        this.numres = numres;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
