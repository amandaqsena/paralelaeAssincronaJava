package br.com.amandaqsena;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Desafio {
    /**Usando Completablefuture e o pacote NIO do Java, 
     * devemos ler um arquivo e substituir o conteúdo dele
     * por informacoes de uma Pessoa. Para esse exemplo,
     * considere um completable future para ler o arquivo
     * e um método para substituir seu conteudo.
     * O retorno deve ser exibido no terminal. 
     * 
     * Exemplo de texto: Olá $NOME, Parabéns pelos seus $IDADE anos de vida!
     *  Desejamos a você muitas felicidades e sucesso em sua jornada. 
     * Atenciosamente, Equipe ADA.
     * @throws IOException
     * 
     */
    public static void main(String[] args) throws IOException{

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Pessoa lucas = Pessoa.builder()
                            .nome("Bruno").idade(20).build();

        substituiNomes(lucas,executorService).thenAccept(System.out::println); 
        
        executorService.shutdown();
    }

    private static CompletableFuture<String> substituiNomes(Pessoa pessoa, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            
            try {
                String conteudo = Files.readString(Path.of("src/main/resources/input.txt"));

                return conteudo.replace("$IDADE", String.valueOf(pessoa.getIdade()))
                        .replace("$NOME", String.valueOf(pessoa.getNome()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, executorService);
    }
    
}
