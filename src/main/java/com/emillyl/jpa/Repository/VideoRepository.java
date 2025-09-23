package com.emillyl.jpa.Repository;

import com.emillyl.jpa.Entity.Categoria;
import com.emillyl.jpa.Entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Long> {
    List<Video> findByTituloContainingOrderByTitulo(String titulo);
    List<Video> findByCategoriaOrderByTitulo(Categoria categoria);
}
