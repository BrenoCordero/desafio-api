package com.br.breno.desafioapi.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FipeApi {

    public String obterDados(String endereco){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(endereco)).build();

        HttpResponse <String> response = null;
        try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        }catch(Exception e){
            System.out.println("Erro na chamada da api");
        }
        return response.body();

    }
}
