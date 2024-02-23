package com.br.breno.desafioapi.model;

public class Dados {
    private int tipoVeiculo;
    private String valor;
    private String marca;
    private String modelol;
    private int ano;
    private String combustivel;
    private String codigoFipe;
    private String mesReferencia;
    private  String siglaCombustivel;

    public int getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    @Override
    public String toString() {
        return "Dados{" +
                "tipoVeiculo=" + tipoVeiculo +
                ", valor='" + valor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelol='" + modelol + '\'' +
                ", ano=" + ano +
                ", combustivel='" + combustivel + '\'' +
                ", codigoFipe='" + codigoFipe + '\'' +
                ", mesReferencia='" + mesReferencia + '\'' +
                ", siglaCombustivel='" + siglaCombustivel + '\'' +
                '}';
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelol() {
        return modelol;
    }

    public void setModelol(String modelol) {
        this.modelol = modelol;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        this.siglaCombustivel = siglaCombustivel;
    }
}
