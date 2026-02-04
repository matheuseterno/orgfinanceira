package com.projtec.orgfinanceira.repositories;

import com.projtec.orgfinanceira.domain.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
}
