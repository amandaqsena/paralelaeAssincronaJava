package br.com.amandaqsena;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class TesteEscritaArquivos {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/output.txt");
        List<String> lista = Arrays.asList(
          "Linha 1",  
          "Linha 2"  
        );

        Files.write(path, lista, StandardOpenOption.APPEND);
    }
}
