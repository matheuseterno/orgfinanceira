package com.projtec.orgfinanceira.repositories;

import com.projtec.orgfinanceira.domain.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByTelefone(String telefone);
}
