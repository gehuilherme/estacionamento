package com.guimi.estacionamento.controller;

import com.guimi.estacionamento.domain.Estado;
import com.guimi.estacionamento.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/estados")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> listarTodos(){
        return ResponseEntity.ok(this.estadoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Estado>> listarPorId(@PathVariable(name = "id")Integer id){
        return ResponseEntity.ok(this.estadoService.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Estado> cadastrar(@Valid @RequestBody Estado estado){
        return ResponseEntity.ok(this.estadoService.cadastrar(estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> atualizar(@PathVariable(name = "id") Integer id,@RequestBody Estado estado){
//        estado.setId(id);
        return ResponseEntity.ok(this.estadoService.atualizar(estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> remover(@PathVariable(name = "id") Integer id){
        this.estadoService.remover(id);
        return ResponseEntity.ok(1);
    }
}
