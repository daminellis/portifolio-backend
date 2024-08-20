package org.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Criar uma lista de barcos com diferentes tamanhos
        ArrayList<Barco> barcos = new ArrayList<>();
        barcos.add(new Barco("rodrigo A ", 8));
        barcos.add(new Barco("morona B ", 12));
        barcos.add(new Barco("lucas C ", 10));
        barcos.add(new Barco("joao D ", 5));
        barcos.add(new Barco("jean E ", 15));

        //criar os portos
        PortoPequeno portoPequeno = new PortoPequeno();
        portoPequeno.nome = "Porto Pequeno";

        PortoGrande portoGrande = new PortoGrande();
        portoGrande.nome = "Porto Grande";

        //tentar atracar os barcos
        for (Barco barco : barcos) {
            //tentar atracar no porto pequeno
            portoPequeno.atracarBarco(barco);

            //se o barco não foi atracado no porto pequeno, tentar no porto grande
            if (!portoPequeno.barcosAtracados.contains(barco)) {
                portoGrande.atracarBarco(barco);
            }
        }
    }
}
