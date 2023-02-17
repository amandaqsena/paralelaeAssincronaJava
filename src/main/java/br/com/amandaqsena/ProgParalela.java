package br.com.amandaqsena;
public class ProgParalela {
    public static void main(String[] args) {
        PiGenerator piGenerator = new PiGenerator();
        System.out.println();
        
        Thread thread = new Thread(() -> {
            System.out.println("Dentro do run: " 
                + piGenerator.gerarPi(10000000));
        });

        thread.start();

        System.out.println("Outro processamento");

        System.out.println("Fora do run: " 
            + piGenerator.gerarPi(10));
    }
    
}
