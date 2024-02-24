package com.br.breno.desafioapi.principal;

import com.br.breno.desafioapi.model.*;
import com.br.breno.desafioapi.service.ConverteDados;
import com.br.breno.desafioapi.service.ConverteDadosImpl;
import com.br.breno.desafioapi.service.FipeApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitor = new Scanner(System.in);
    private FipeApi api = new FipeApi();

    private ObjectMapper mapper = new ObjectMapper();
    private Gson gson = new Gson();
    private final ConverteDadosImpl converteDados = new ConverteDadosImpl();
    private final String URI_FIPE = "https://parallelum.com.br/fipe/api/v1/";


    public void exibeMenu() {
        String url = null;

        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhoes");
        System.out.println("Gostaria de pesquisar por qual dessas categorias:");
        var categoria = leitor.nextLine();

        if (categoria.contains("car")) {
            url = URI_FIPE + categoria.toLowerCase() + "/marcas";
        } else if (categoria.contains("mot")) {

        } else {

        }

        var json = api.obterDados(url);
        System.out.println(json);


        List<DadosDTO> dados = converteDados.converteMarcaList(json, DadosDTO.class);
        List<Dados> marcas = dados.stream()
                .map(dto -> new Dados(dto.codigo(), dto.nome()))
                .collect(Collectors.toList());

        marcas.stream()
                .sorted()
                .forEach(System.out::println);



        System.out.println("Gostaria de pesquisar por qual marca :");
        var marca = leitor.nextLine();
        json = api.obterDados(URI_FIPE  + categoria.toLowerCase() + "/marcas/" + marca + "/modelos");
        System.out.println("Modelos" + json);

        Modelos modelos = converteDados.converteDados(json, Modelos.class);
      modelos.modelos().stream()
              .forEach(System.out::println);

        System.out.println("Gostaria de saber mais sobre qual modelo :");
         var modeloEscolhido = leitor.nextLine();
       List<Dados> dadosModelo =   modelos.modelos().stream()
                 .filter(m -> m.nome().toUpperCase().contains(modeloEscolhido.toUpperCase()))
               .map(dto -> new Dados(dto.codigo(), dto.nome()))
                 .collect(Collectors.toList());

       dadosModelo.stream().forEach(System.out::println);
//
//        System.out.println("Gostaria de pesquisar por qual modelo dessa marca");
//        var modeloEscolhido = leitor.nextLine();
//        json = api.obterDados(URI_FIPE + "/" + categoria.toLowerCase() + "/marcas/" + modelo + "/modelos/" + modeloEscolhido + "/anos");
//        List<Ano> anosDOModelo = converteDados.converteMarcaList(json, Ano.class);
//        anosDOModelo.forEach(System.out::println);
//
//        System.out.println("Gostaria de pesquisar por qual ano do modelo dessa marca");
//        var ano = leitor.nextLine();
//        json = api.obterDados(URI_FIPE + "/" + categoria.toLowerCase() + "/marcas/" + modelo + "/modelos/" + modeloEscolhido + "/anos/" + ano);
//        Dados dado = gson.fromJson(json, Dados.class);
//        System.out.println(dado);


    }
}
