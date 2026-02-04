package com.projtec.orgfinanceira.repositories;

import com.projtec.orgfinanceira.domain.receitas.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitasRepository extends JpaRepository<Receita, Integer> {
}
