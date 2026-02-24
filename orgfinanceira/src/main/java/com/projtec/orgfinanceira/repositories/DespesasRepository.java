package com.projtec.orgfinanceira.repositories;

import com.projtec.orgfinanceira.domain.despesas.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DespesasRepository extends JpaRepository<Despesa, Integer> {
    List<Despesa> findByUsuarioId(Integer usuarioId);
}
