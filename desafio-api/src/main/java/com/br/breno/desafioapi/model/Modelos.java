package com.br.breno.desafioapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Modelos {
    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    @JsonAlias("modelos")
    private List<Modelo> modelos;

}
