package com.br.breno.desafioapi.service;

public interface ConverteDados {
    <T> T converteDados(String json, Class<T> tClass);
}
