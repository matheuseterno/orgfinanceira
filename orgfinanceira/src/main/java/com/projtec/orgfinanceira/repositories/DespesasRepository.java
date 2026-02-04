package com.projtec.orgfinanceira.repositories;

import com.projtec.orgfinanceira.domain.despesas.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesasRepository extends JpaRepository<Despesa, Integer> {
}
