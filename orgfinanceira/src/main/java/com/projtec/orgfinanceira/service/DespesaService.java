package com.projtec.orgfinanceira.service;

import com.projtec.orgfinanceira.domain.despesas.Despesa;
import com.projtec.orgfinanceira.domain.despesas.DespesaResquestDTO;
import com.projtec.orgfinanceira.domain.usuarios.Usuario;
import com.projtec.orgfinanceira.repositories.DespesasRepository;
import com.projtec.orgfinanceira.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class DespesaService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private DespesasRepository despesasRepository;

    public Despesa criaDespesa(DespesaResquestDTO data){
        Despesa novaDespesa = new Despesa();

        Usuario usuario = usuariosRepository.findById(data.usuarioId()).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));

        novaDespesa.setUsuario(usuario);
        novaDespesa.setTitulo(data.titulo());
        novaDespesa.setDescricao(data.descricao());
        novaDespesa.setValor(data.valor());
        novaDespesa.setRecorrente(data.recorrente());
        novaDespesa.setPago(data.pago());
        novaDespesa.setMetodoPagamento(data.MetodoPagamento());
        if(data.dataDespesa() != null){
            novaDespesa.setDataDespesa(LocalDateTime.ofInstant(Instant.ofEpochMilli(data.dataDespesa()), ZoneId.systemDefault()));
        }
        return despesasRepository.save(novaDespesa);
    }
}
