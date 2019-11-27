package com.guimi.estacionamento.controller;

import com.guimi.estacionamento.domain.Cliente;
import com.guimi.estacionamento.domain.Veiculo;
import com.guimi.estacionamento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos(){
        return ResponseEntity.ok(this.clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> listarPorId(@PathVariable(name = "id")Integer id){
        return ResponseEntity.ok(this.clienteService.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente){
        return ResponseEntity.ok(this.clienteService.cadastrar(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable(name = "id") Integer id, String nome, String email, String telefone, String logradouro, String numres, String complemento, String bairro, String cep, @RequestBody Cliente cliente){
//        cliente.setId(id);
//        cliente.setNome(nome);
//        cliente.setTelefone(telefone);
//        cliente.setLogradouro(logradouro);
//        cliente.setNumres(numres);
//        cliente.setComplemento(complemento);
//        cliente.setBairro(bairro);
//        cliente.setCep(cep);
        return ResponseEntity.ok(this.clienteService.atualizar(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> remover(@PathVariable(name = "id") Integer id){
        this.clienteService.remover(id);
        return ResponseEntity.ok(1);
    }

}
