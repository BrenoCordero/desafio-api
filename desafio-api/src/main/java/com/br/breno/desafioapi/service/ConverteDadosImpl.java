package com.br.breno.desafioapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDadosImpl implements ConverteDados{

    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T converteDados(String json, Class<T> tClass) {

        try {
            return mapper.readValue(json,tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
