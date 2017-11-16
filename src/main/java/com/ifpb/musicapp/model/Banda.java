package com.ifpb.musicapp.model;

import java.util.List;

/**
 *
 * @author lyndemberg
 */
public class Banda {
    private int id;
    private String nome;
    private String localOrigem;
    private List<String> integrantes;

    public Banda() {
    }

    public Banda(int id, String nome, String localOrigem, List<String> integrantes) {
        this.id = id;
        this.nome = nome;
        this.localOrigem = localOrigem;
        this.integrantes = integrantes;
    }

    public Banda(String nome, String localOrigem, List<String> integrantes) {
        this.nome = nome;
        this.localOrigem = localOrigem;
        this.integrantes = integrantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalOrigem() {
        return localOrigem;
    }

    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }

    public List<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<String> integrantes) {
        this.integrantes = integrantes;
    }
    
    
}
