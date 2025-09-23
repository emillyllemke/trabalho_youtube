package com.emillyl.jpa.Repository;

import com.emillyl.jpa.Entity.Usuario;
import com.emillyl.jpa.Entity.Video;
import com.emillyl.jpa.Entity.Visualizacao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VisualizacaoRepository extends JpaRepository<Visualizacao,Long> {

    @Query("SELECT v.video FROM Visualizacao v GROUP BY v.video ORDER BY COUNT(v.video) DESC")
    List<Video> findTopVideosAssistidos(Pageable pageable);
    @Query("SELECT v.perfil.usuario FROM Visualizacao v GROUP BY v.perfil.usuario ORDER BY COUNT(v) DESC")
    List<Usuario> findTopUsuariosByVisualizacao(Pageable pageable);
}