package br.com.amandaqsena;

import lombok.Setter;
import lombok.Getter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class Pessoa {
    private String nome;
    private int idade;
}
