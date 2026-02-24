package com.projtec.orgfinanceira.service;

import com.projtec.orgfinanceira.domain.despesas.Despesa;
import com.projtec.orgfinanceira.domain.despesas.DespesaRequestDTO;
import com.projtec.orgfinanceira.domain.despesas.DespesaResponseDTO;
import com.projtec.orgfinanceira.domain.usuarios.Usuario;
import com.projtec.orgfinanceira.repositories.DespesasRepository;
import com.projtec.orgfinanceira.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private DespesasRepository despesasRepository;

    public Despesa criaDespesa(DespesaRequestDTO data){
        Despesa despesa = new Despesa();

        Usuario usuario = usuariosRepository.findById(data.usuarioId()).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));

        despesa.setUsuario(usuario);
        despesa.setTitulo(data.titulo());
        despesa.setDescricao(data.descricao());
        despesa.setValor(data.valor());
        despesa.setRecorrente(data.recorrente());
        despesa.setPago(data.pago());
        despesa.setMetodoPagamento(data.metodoPagamento());
        if(data.dataDespesa() != null){
            despesa.setDataDespesa(LocalDateTime.ofInstant(Instant.ofEpochMilli(data.dataDespesa()), ZoneId.systemDefault()));
        }
        return despesasRepository.save(despesa);
    }

    public List<DespesaResponseDTO> listarPorUsuario(Integer usuarioId){
        List<Despesa> despesas = despesasRepository.findByUsuarioId(usuarioId);

        return despesas.stream()
                .map(despesa -> new DespesaResponseDTO(
                        despesa.getId(),
                        despesa.getTitulo(),
                        despesa.getDescricao(),
                        despesa.getValor(),
                        despesa.getDataDespesa(),
                        despesa.getMetodoPagamento(),
                        despesa.isPago()
                ))
                .toList();
    }

    public List<DespesaResponseDTO> listarPorTelefone(String telefone) {
        Usuario usuario = usuariosRepository.findByTelefone(telefone).orElseThrow(() -> new RuntimeException("Usuário não encontrado para o telefone informado."));
        return this.listarPorUsuario(usuario.getId());
    }
}
