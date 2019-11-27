package com.guimi.estacionamento.controller;

import com.guimi.estacionamento.domain.Cidade;
import com.guimi.estacionamento.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@Controller
@RestController
@RequestMapping("/api/cidades")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

//    @GetMapping
//    public ModelAndView index(ModelMap model){
//        model.addAttribute("cidade", new Cidade());
//        model.addAttribute("rels", cidadeService.listarTodos());
//        model.addAttribute("conteudo", "/cdd/cidade");
//        return new ModelAndView("layout", model);
//    }

    @GetMapping
    public ResponseEntity<List<Cidade>> listarTodos(){
        return ResponseEntity.ok(this.cidadeService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cidade>> listarPorId(@PathVariable(name = "id")Integer id){
        return ResponseEntity.ok(this.cidadeService.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cidade> cadastrar(@Valid @RequestBody Cidade cidade){
        return ResponseEntity.ok(this.cidadeService.cadastrar(cidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> atualizar(@PathVariable(name = "id") Integer id, String descricao, @RequestBody Cidade cidade){
//        cidade.setId(id);
//        cidade.setDescricao(descricao);
        return ResponseEntity.ok(this.cidadeService.atualizar(cidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> remover(@PathVariable(name = "id") Integer id){
        this.cidadeService.remover(id);
        return ResponseEntity.ok(1);
    }
}
