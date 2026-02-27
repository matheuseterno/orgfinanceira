package com.projtec.orgfinanceira.service;

import com.projtec.orgfinanceira.domain.despesas.Despesa;
import com.projtec.orgfinanceira.domain.despesas.DespesaRequestDTO;
import com.projtec.orgfinanceira.domain.despesas.DespesaResponseDTO;
import com.projtec.orgfinanceira.domain.receitas.Receita;
import com.projtec.orgfinanceira.domain.receitas.ReceitaRequestDTO;
import com.projtec.orgfinanceira.domain.receitas.ReceitaResponseDTO;
import com.projtec.orgfinanceira.domain.usuarios.Usuario;
import com.projtec.orgfinanceira.repositories.ReceitasRepository;
import com.projtec.orgfinanceira.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

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
        receita.setMetodoRecebimento(data.metodoRecebimento());
        receita.setRecorrente(data.recorrente());
        receita.setRecebido(data.recebido());
        if(data.dataReceita() != null){
            receita.setDataReceita(LocalDateTime.ofInstant(Instant.ofEpochMilli(data.dataReceita()), ZoneId.systemDefault()));
        }

        return receitasRepository.save(receita);
    }

    public Receita criarReceitaPorTelefone(String telefone, ReceitaRequestDTO data){

        Usuario usuario = usuariosRepository.findByTelefone(telefone).orElseThrow(()->new RuntimeException("Usuário não encontrado para este telefone"));
        ReceitaRequestDTO receita = new ReceitaRequestDTO(
                usuario.getId(),
                data.titulo(),
                data.descricao(),
                data.valor(),
                data.dataReceita(),
                data.metodoRecebimento(),
                data.recorrente(),
                data.recebido()
        );

        return this.criaReceita(receita);
    }

    public List<ReceitaResponseDTO> listarPorUsuario(Integer usuarioId){
        List<Receita> receitas = receitasRepository.findByUsuarioId(usuarioId);

        return receitas.stream()
                .map(receita -> new ReceitaResponseDTO(
                        receita.getId(),
                        receita.getTitulo(),
                        receita.getDescricao(),
                        receita.getValor(),
                        receita.getDataReceita(),
                        receita.getMetodoRecebimento(),
                        receita.isRecebido()
                ))
                .toList();
    }

    public List<ReceitaResponseDTO> listarPorTelefone(String telefone) {
        Usuario usuario = usuariosRepository.findByTelefone(telefone).orElseThrow(() -> new RuntimeException("Usuário não encontrado para o telefone informado."));
        return this.listarPorUsuario(usuario.getId());
    }
}
