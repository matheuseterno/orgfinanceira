package com.projtec.orgfinanceira.service;

import com.projtec.orgfinanceira.domain.receitas.Receita;
import com.projtec.orgfinanceira.domain.receitas.ReceitaRequestDTO;
import com.projtec.orgfinanceira.domain.usuarios.Usuario;
import com.projtec.orgfinanceira.repositories.ReceitasRepository;
import com.projtec.orgfinanceira.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ReceitaService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private ReceitasRepository receitasRepository;

    public Receita criaReceita(ReceitaRequestDTO data){

        Receita receita = new Receita();
        Usuario usuario = usuariosRepository.findById(data.usuarioId()).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));

        receita.setUsuario(usuario);
        receita.setTitulo(data.titulo());
        receita.setDescricao(data.descricao());
        receita.setValor(data.valor());
        receita.setRecorrente(data.recorrente());
        receita.setRecebido(data.recebido());
        if(data.dataReceita() != null){
            receita.setDataReceita(LocalDateTime.ofInstant(Instant.ofEpochMilli(data.dataReceita()), ZoneId.systemDefault()));
        }

        return receitasRepository.save(receita);
    }

}
