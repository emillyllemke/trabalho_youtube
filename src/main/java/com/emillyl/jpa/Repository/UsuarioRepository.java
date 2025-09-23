package com.emillyl.jpa.Repository;

import com.emillyl.jpa.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
