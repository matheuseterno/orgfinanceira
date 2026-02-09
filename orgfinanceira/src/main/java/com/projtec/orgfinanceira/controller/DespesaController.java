package com.projtec.orgfinanceira.controller;

import com.projtec.orgfinanceira.domain.despesas.Despesa;
import com.projtec.orgfinanceira.domain.despesas.DespesaRequestDTO;
import com.projtec.orgfinanceira.domain.despesas.DespesaResponseDTO;
import com.projtec.orgfinanceira.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public ResponseEntity<Despesa> create (@RequestBody DespesaRequestDTO body){
        Despesa despesa = this.despesaService.criaDespesa(body);
        return ResponseEntity.status(201).body(despesa);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<DespesaResponseDTO>> getByUsuario(@PathVariable Integer id){
        List<DespesaResponseDTO> despesas = this.despesaService.listarPorUsuario(id);
        return ResponseEntity.ok(despesas);
    }

}
