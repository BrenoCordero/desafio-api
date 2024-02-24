package com.br.breno.desafioapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Dados implements Comparable<Dados> {
    private Integer codigo;
    private String nome;

    public Dados(String codigo, String nome) {
        this.codigo = Integer.valueOf(codigo);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Dados{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public int compareTo(Dados o) {
        return this.codigo.compareTo(o.codigo);
    }
}
