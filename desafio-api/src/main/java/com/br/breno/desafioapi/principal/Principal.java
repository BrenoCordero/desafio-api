package com.br.breno.desafioapi.principal;

import com.br.breno.desafioapi.service.FipeApi;

import java.util.Scanner;

public class Principal {

    private Scanner leitor = new Scanner(System.in);
    private FipeApi api = new FipeApi();

    private final String URI_FIPE = "https://parallelum.com.br/fipe/api/v1";

    public void exibeMenu() {

        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhoes");
        System.out.println("Gostaria de pesquisar por qual dessas categorias:");
        var categoria = leitor.nextLine();

        var resultado =api.obterDados(URI_FIPE +"/" +categoria.toLowerCase() + "/marcas");
        System.out.println(resultado);
    }
}
