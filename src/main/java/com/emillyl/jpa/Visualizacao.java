package com.emillyl.jpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Visualizacao {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data_hora;
    private Long progresso;

    @ManyToOne
    private Perfil perfil;

    @ManyToOne
    private Video video;

    public Visualizacao() {
    }

    public Visualizacao(Long id, LocalDateTime data_hora, Long progresso, Perfil perfil, Video video) {
        this.id = id;
        this.data_hora = data_hora;
        this.progresso = progresso;
        this.perfil = perfil;
        this.video = video;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public Long getProgresso() {
        return progresso;
    }

    public void setProgresso(Long progresso) {
        this.progresso = progresso;
    }
}
