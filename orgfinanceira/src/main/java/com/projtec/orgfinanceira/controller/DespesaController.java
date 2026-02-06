package com.projtec.orgfinanceira.controller;

import com.projtec.orgfinanceira.domain.despesas.Despesa;
import com.projtec.orgfinanceira.domain.despesas.DespesaResquestDTO;
import com.projtec.orgfinanceira.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public ResponseEntity<Despesa> create (@RequestBody DespesaResquestDTO body){
        Despesa despesa = this.despesaService.criaDespesa(body);
        return ResponseEntity.status(201).body(despesa);
    }

}
