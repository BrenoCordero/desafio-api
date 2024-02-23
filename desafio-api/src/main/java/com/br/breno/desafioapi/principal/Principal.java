package com.br.breno.desafioapi.principal;

import com.br.breno.desafioapi.model.*;
import com.br.breno.desafioapi.service.ConverteDados;
import com.br.breno.desafioapi.service.ConverteDadosImpl;
import com.br.breno.desafioapi.service.FipeApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.*;

public class Principal {

    private Scanner leitor = new Scanner(System.in);
    private FipeApi api = new FipeApi();

    private ObjectMapper mapper = new ObjectMapper();
    private Gson gson = new Gson();
    private final ConverteDadosImpl converteDados = new ConverteDadosImpl();
    private final String URI_FIPE = "https://parallelum.com.br/fipe/api/v1";


    public void exibeMenu() {

        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhoes");
        System.out.println("Gostaria de pesquisar por qual dessas categorias:");
        var categoria = leitor.nextLine();

        var json = api.obterDados(URI_FIPE + "/" + categoria.toLowerCase() + "/marcas");
        System.out.println(json);

        List<Marca> marcas = converteDados.converteMarcaList(json, Marca.class);
        marcas.forEach(System.out::println);
//        try {
//          List<Marca>marcas  = mapper.readValue(json, mapper.getTypeFactory().
//                    constructCollectionType(List.class, Marca.class));
//            marcas.forEach(System.out::println);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Gostaria de pesquisar por qual marca :");
        var modelo = leitor.nextLine();
        json = api.obterDados(URI_FIPE + "/" + categoria.toLowerCase() + "/marcas/" + modelo + "/modelos");
        System.out.println("Modelos" + json);

       Modelos dados = gson.fromJson(json, Modelos.class);
        List<Modelo> modelos =dados.getModelos();
        modelos.forEach(System.out::println);

        System.out.println("Gostaria de pesquisar por qual modelo dessa marca");
        var modeloEscolhido = leitor.nextLine();
        json = api.obterDados(URI_FIPE + "/" + categoria.toLowerCase() + "/marcas/" + modelo + "/modelos/"+ modeloEscolhido+ "/anos");
        List<Ano> anosDOModelo = converteDados.converteMarcaList(json, Ano.class);
        anosDOModelo.forEach(System.out::println);

        System.out.println("Gostaria de pesquisar por qual ano do modelo dessa marca");
        var ano = leitor.nextLine();
        json = api.obterDados(URI_FIPE + "/" + categoria.toLowerCase() + "/marcas/" + modelo + "/modelos/"+ modeloEscolhido+ "/anos/"+ano);
        Dados dado = gson.fromJson(json, Dados.class);
        System.out.println(dado);



    }
}
