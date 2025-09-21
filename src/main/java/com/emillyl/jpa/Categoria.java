package com.emillyl.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    private String nome_categoria;

    @OneToMany (mappedBy = "categoria")
    private List<Video> videos;

    public Categoria() {
    }

    public Categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public Long getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }
    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public List<Video> getVideos() {
        return videos;
    }
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
