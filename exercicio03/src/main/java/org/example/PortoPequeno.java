package org.example;

public class PortoPequeno extends BasePorto{
    @Override
    public void atracarBarco(Barco barco) {
        if (barco.tamanho <= 10) {
            super.atracarBarco(barco);
//          este super faz com chame o metodo atracarBarco da classe pai
        }else {
            System.out.println("Barco " + barco.nome + "é grande demais para este porto" + nome);
        }
    }
}
