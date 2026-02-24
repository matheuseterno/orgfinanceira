package com.projtec.orgfinanceira.controller;

import com.projtec.orgfinanceira.domain.despesas.DespesaResponseDTO;
import com.projtec.orgfinanceira.domain.receitas.Receita;
import com.projtec.orgfinanceira.domain.receitas.ReceitaRequestDTO;
import com.projtec.orgfinanceira.domain.receitas.ReceitaResponseDTO;
import com.projtec.orgfinanceira.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<ReceitaResponseDTO>> getByUsuario (@PathVariable Integer id){
        List<ReceitaResponseDTO> receita = this.receitaService.listarPorUsuario(id);
        return ResponseEntity.ok(receita);
    }

    @GetMapping("/telefone/{telefone}")
    public ResponseEntity<List<ReceitaResponseDTO>> getByTelefone(@PathVariable String telefone) {
        List<ReceitaResponseDTO> despesas = this.receitaService.listarPorTelefone(telefone);
        return ResponseEntity.ok(despesas);
    }
}
