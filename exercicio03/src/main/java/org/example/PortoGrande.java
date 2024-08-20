package org.example;

public class PortoGrande extends BasePorto {

    @Override
    public void atracarBarco(Barco barco) {
        if (barco.tamanho >= 10) {
            super.atracarBarco(barco);
        } else {
            System.out.println("Barco " + barco.nome + "é muito pequeno para atracar no porto grande" + nome);
        }
    }
}
