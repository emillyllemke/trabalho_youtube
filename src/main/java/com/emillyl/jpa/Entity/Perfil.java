package com.emillyl.jpa.Entity;

import jakarta.persistence.*;

@Entity
public class Perfil {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_perfil;
    @ManyToOne
    private Usuario usuario;

    public Perfil() {
    }

    public Perfil(Long id, String nome_perfil, Usuario usuario) {
        this.id = id;
        this.nome_perfil = nome_perfil;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_perfil() {
        return nome_perfil;
    }
    public void setNome_perfil(String nome_perfil) {
        this.nome_perfil = nome_perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
