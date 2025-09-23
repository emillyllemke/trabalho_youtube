package com.emillyl.jpa.Repository;

import com.emillyl.jpa.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}