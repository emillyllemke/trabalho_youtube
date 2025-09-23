package com.emillyl.jpa.Entity;

import jakarta.persistence.*;

@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long nota;
    private String comentario;

    @ManyToOne
    private Perfil perfil;

    @ManyToOne
    private Video video;

    public Avaliacao() {
    }

    public Avaliacao(Long id, Long nota, String comentario, Perfil perfil, Video video) {
        this.id = id;
        this.nota = nota;
        this.comentario = comentario;
        this.perfil = perfil;
        this.video = video;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getNota() {
        return nota;
    }
    public void setNota(Long nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
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
}
