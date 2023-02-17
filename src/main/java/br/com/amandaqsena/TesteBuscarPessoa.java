package br.com.amandaqsena;

public class TesteBuscarPessoa {
    public static void main(String[] args){
        Pessoa italo = buscarPessoa("Italo");
        System.out.println(buscarSetorPessoa(italo));
    }

    /**
     * Buscar pessoa pelo nome
     */

     public static Pessoa buscarPessoa(String nome){
        
        return Pessoa.builder().nome(nome).idade(18).build();
     }

     /**
     * Buscar setor da pessoa
     */

     public static String buscarSetorPessoa(Pessoa pessoa){
        return pessoa.getNome();
     }
}
