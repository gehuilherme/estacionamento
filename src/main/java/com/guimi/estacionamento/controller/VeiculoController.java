package com.guimi.estacionamento.controller;

import com.guimi.estacionamento.domain.Veiculo;
import com.guimi.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos(){
        return ResponseEntity.ok(this.veiculoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> listarPorId(@PathVariable(name = "id")Integer id){
        return ResponseEntity.ok(this.veiculoService.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrar(@Valid @RequestBody Veiculo veiculo){
        return ResponseEntity.ok(this.veiculoService.cadastrar(veiculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable(name = "id") Integer id, @RequestBody Veiculo veiculo){
//        veiculo.setId(id);
        return ResponseEntity.ok(this.veiculoService.atualizar(veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> remover(@PathVariable(name = "id") Integer id){
        this.veiculoService.remover(id);
        return ResponseEntity.ok(200);
    }
}
