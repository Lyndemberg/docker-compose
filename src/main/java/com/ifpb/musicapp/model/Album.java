package com.ifpb.musicapp.model;

import java.time.LocalDate;

/**
 *
 * @author lyndemberg
 */
public class Album {
    private int id;
    private Estilo estilo;
    private Banda banda;
    private LocalDate lancamento;

    public Album() {
    }

    public Album(int id, Estilo estilo, Banda banda, LocalDate lancamento) {
        this.id = id;
        this.estilo = estilo;
        this.banda = banda;
        this.lancamento = lancamento;
    }

    public Album(Estilo estilo, Banda banda, LocalDate lancamento) {
        this.estilo = estilo;
        this.banda = banda;
        this.lancamento = lancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }
    
}
