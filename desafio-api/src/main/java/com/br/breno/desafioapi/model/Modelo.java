package com.br.breno.desafioapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class Modelo {
    private int codigo;
    private String nome;

    // Construtor vazio
    public Modelo() {
    }

    // Construtor que recebe os valores dos atributos
    public Modelo(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    // Métodos getters e setters para acessar e modificar os atributos
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método toString para imprimir o objeto de forma legível
    @Override
    public String toString() {
        return "Modelo{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }

}
