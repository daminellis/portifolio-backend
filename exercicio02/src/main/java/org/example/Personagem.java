package org.example;

public class Personagem {
    public String nome;
    public Integer vida = 10;

    public void verificaSeEstaVivo(){
        if (vida > 0 ) {
            System.out.println("Está Vivo!");
        } else{
            System.out.println("Está Morto!");
        }
    }

    public void atacar(Personagem alvo) {
        alvo.vida -= 5;
        this.vida += 5;
//      Quando colocado this em um public void, voce vai acessar os dados de quem chamou a variavel
    }

    public void  curar(Personagem alvo) {
        alvo.vida += 100;
    }
//  So testando, nao mais sendo utilizada


}
