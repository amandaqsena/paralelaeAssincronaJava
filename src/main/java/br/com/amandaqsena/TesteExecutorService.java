package br.com.amandaqsena;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class TesteExecutorService {
    public static void main(String[] args) throws
        InterruptedException, ExecutionException{

        ExecutorService exutorService = Executors.newFixedThreadPool(2);
        

        System.out.println("Dentro do main: " + Thread.currentThread().getName());
        List<Integer> listaInteiros = Arrays.asList(2,3,4,5,2,10);

        CompletableFuture<Integer> soma = 
            CompletableFuture.supplyAsync(() -> {
                // escrever a lógica aqui
                System.out.println("Dentro do future: " + 
                    Thread.currentThread().getName());
                return listaInteiros.stream()
                    .collect(Collectors.summingInt((n)->n));
            });
        
            //Integer resultado = soma.get(); // blocante
            //System.out.println(resultado);

            //não deu tempo de executar o resultado
            soma.thenAccept(System.out::println); 


            //soma.join(); //faz a main esperar a soma executar
    
            exutorService.shutdown();
    }
}
