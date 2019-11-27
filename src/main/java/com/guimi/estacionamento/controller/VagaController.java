package com.guimi.estacionamento.controller;

import com.guimi.estacionamento.domain.Vaga;
import com.guimi.estacionamento.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vagas")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @GetMapping
    public ResponseEntity<List<Vaga>> listarTodos(){
        return ResponseEntity.ok(this.vagaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vaga>> listarPorId(@PathVariable(name = "id")Integer id){
        return ResponseEntity.ok(this.vagaService.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Vaga> cadastrar(@Valid @RequestBody Vaga vaga){
        return ResponseEntity.ok(this.vagaService.cadastrar(vaga));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> atualizar(@PathVariable(name = "id") Integer id, boolean status, @RequestBody Vaga vaga){
//        vaga.setId(id);
//        vaga.setStatus(status);
        return ResponseEntity.ok(this.vagaService.atualizar(vaga));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> remover(@PathVariable(name = "id") Integer id){
        this.vagaService.remover(id);
        return ResponseEntity.ok(1);
    }
}
