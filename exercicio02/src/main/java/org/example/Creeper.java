package org.example;

public class Creeper extends Personagem{
    @Override
//  Sobreescreve os dados do atacar
    public void atacar(Personagem alvo) {
        alvo.vida -= 8;
        this.vida = 0;
//      Quando colocado this em um public void, voce vai acessar os dados de quem chamou a variavel
    }
}
