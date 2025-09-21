package com.emillyl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Long> {
    List<Video> findByTituloContainingOrderByTitulo(String titulo);
    List<Video> findByCategoriaOrderByTitulo(Categoria categoria);
}
