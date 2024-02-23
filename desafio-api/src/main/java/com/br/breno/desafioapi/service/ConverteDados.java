package com.br.breno.desafioapi.service;

import com.br.breno.desafioapi.model.Marca;

import java.util.List;
import java.util.Objects;

public interface ConverteDados {
    <T> T converteDados(String json, Class<T> tClass);

   public <T> List<T> converteMarcaList(String json,Class<T>  t);
}
