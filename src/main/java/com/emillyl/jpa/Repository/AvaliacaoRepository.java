package com.emillyl.jpa.Repository;

import com.emillyl.jpa.Entity.Avaliacao;
import com.emillyl.jpa.Entity.Video;
import org.springframework.data.domain.Pageable; // Para a paginação
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // Para a anotação @Query
import java.util.List; // Para a List

public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {

    @Query("SELECT a.video FROM Avaliacao a GROUP BY a.video ORDER BY AVG(a.nota) DESC")
    List<Video> findTopMelhoresVideos(Pageable pageable);
}

