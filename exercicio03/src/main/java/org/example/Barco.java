package org.example;

public class Barco {
    public String nome;
    public Integer tamanho;

    // criei para conseguir passar os parametros, sem isso aqui nao conseguia passar direto
    public Barco(String nome, Integer tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }
}

