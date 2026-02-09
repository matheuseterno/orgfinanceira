package com.projtec.orgfinanceira.repositories;

import com.projtec.orgfinanceira.domain.receitas.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitasRepository extends JpaRepository<Receita, Integer> {
    List<Receita> findByUsuarioId(Integer usuarioID);
}
