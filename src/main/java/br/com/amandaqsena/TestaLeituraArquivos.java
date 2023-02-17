package br.com.amandaqsena;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Manipulando arquivos usando NIO
 * Usando Streams e Collectors grouping mapping
 * CompletableFuture
 */
public class TestaLeituraArquivos {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/output.txt");
        
    try{
        Files.lines(path)
            .filter(linha -> linha.startsWith("Sexo"))
            .forEach(System.out::println);
    } catch (IOException e){
        e.printStackTrace();
    }
    }
}
