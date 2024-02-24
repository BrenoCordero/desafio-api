package com.br.breno.desafioapi.service;

import java.util.List;

public interface ConverteDados {
    <T> T converteDados(String json, Class<T> tClass);

   public <T> List<T> converteMarcaList(String json,Class<T>  t);
}
