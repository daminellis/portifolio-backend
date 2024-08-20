package org.example;

import java.util.ArrayList;

public class BasePorto {
    public String nome;
    public ArrayList<Barco> barcosAtracados = new ArrayList<>();

    public void atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
        System.out.println("Barco " + barco.nome + "Atracado no porto" + nome);
    }

    public void desatracarBarco(Barco barco) {
        barcosAtracados.remove(barco);
        System.out.println("Barco " + barco.nome + "Desatracado do porto" + nome);
    }
}
