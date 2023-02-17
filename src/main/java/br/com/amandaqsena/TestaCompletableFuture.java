package br.com.amandaqsena;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestaCompletableFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        PiGenerator piGenerator = new PiGenerator();
        System.out.println();
        
        CompletableFuture<Double> future = CompletableFuture
            .supplyAsync(()-> piGenerator.gerarPi(100));

        Double pi = future.get(); //blocante

        System.out.println("Fora do run: " 
            + pi);

        CompletableFuture<String> resultadoFinal = 
            future.thenCompose(resultado 
                -> CompletableFuture.supplyAsync(() 
                    -> recebeNumeroPi(resultado)));
        
        System.out.println(resultadoFinal.get());

        future.thenAccept(resultado 
            -> imprimeNumeroPi(resultado));
    }

    public static String recebeNumeroPi(Double pi){
        return "O número pi é: " + pi.toString();
    }

    public static void imprimeNumeroPi(Double pi){
        System.out.println("O número pi é: " + pi.toString());
    }
}
