package org.example;

public class Main {
    public static void main(String[] args){
        Personagem jogador = new Personagem();
        jogador.nome = "Steve";

        Personagem inimigo = new Personagem();
        inimigo.nome = "herobrine";

        Creeper verdao = new Creeper();

        jogador.atacar(inimigo);
        verdao.atacar(jogador);

        System.out.println("jogador" + jogador.vida);
        System.out.println("Herobrine" + inimigo.vida);
        System.out.println("Verdao" + verdao.vida);
    }
}