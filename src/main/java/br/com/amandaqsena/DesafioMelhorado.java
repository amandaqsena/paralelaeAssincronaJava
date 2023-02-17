package br.com.amandaqsena;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DesafioMelhorado {
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

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Pessoa lucas = Pessoa.builder()
                            .nome("Bruno").idade(20).build();

        leArquivo("src/main/resources/input.txt",executorService)
            .thenCompose((conteudo)->substituiInfos(conteudo, lucas, executorService))
            .thenAccept(System.out::println).join(); 
        
        executorService.shutdown();
    }

    /**
     * 
     * @param filename endereço do arquivo
     * @param executorService executor aonde o future será executado
     * @return CompletableFuture que retorna conteúdo do arquivo
     */
    private static CompletableFuture<String> leArquivo(String filename, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            
            try {
                return Files.readString(Path.of(filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, executorService);
    }


    /**
     * 
     * @param conteudo String aonde serão inseridas as informações da pessoa
     * @param pessoa Pessoa cujas informações serão inseridas no conteúdo
     * @param executorService
     * @return Future que retorna String com informações da pessoa substituída
     */
    private static CompletableFuture<String> substituiInfos(String conteudo, Pessoa pessoa, 
        ExecutorService executorService) {
            return CompletableFuture.supplyAsync(() -> {
                return conteudo.replace("$IDADE", String.valueOf(pessoa.getIdade()))
                    .replace("$NOME", String.valueOf(pessoa.getNome()));
        }, executorService);
    }
}
