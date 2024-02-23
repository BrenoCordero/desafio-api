package com.br.breno.desafioapi.service;

import com.br.breno.desafioapi.model.Marca;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Objects;

public class ConverteDadosImpl implements ConverteDados {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T converteDados(String json, Class<T> tClass) {

        try {
            return mapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public   <T> List<T> converteMarcaList(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().
                    constructCollectionType(List.class, tClass));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
