package com.projtec.orgfinanceira.controller;

import com.projtec.orgfinanceira.domain.receitas.Receita;
import com.projtec.orgfinanceira.domain.receitas.ReceitaRequestDTO;
import com.projtec.orgfinanceira.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<Receita> create(@RequestBody ReceitaRequestDTO body){
        Receita receita = receitaService.criaReceita(body);
        return ResponseEntity.status(201).body(receita);
    }
}
