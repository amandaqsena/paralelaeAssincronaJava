package br.com.amandaqsena;

import java.util.Random;

public class PiGenerator{
    public double gerarPi(int numPontos){
        int numDentro = 0;

        Random rand = new Random();
        for(int i = 0; i<numPontos; i++){
            double x = rand.nextDouble();
            double y = rand.nextDouble();
            if(x*x + y*y <= 1){
                numDentro++;
            }

        }
        double pi =  4.0 * numDentro/numPontos;
        return pi;        
    }
}