
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] mix1 = { "Saga Homens de Preto", "De Volta Para o Futuro", "Guardiões da Galaxia", "Os Caça Fantasma"};
        /* Scifi e comedia */
        String[] mix2 = { "Interestellar", "Blade Runner", "A Chegada", "A Ilha"};
        /* Scifi e drama */
        String[] mix3 = { "Robin Hood", "Coração de cavaleiro", "Valente", "Monty Python em Busca do Cálice Sagrado"};
        /* medieval e comedia */
        String[] mix4 = { "O nome da rosa", "O reino dos ceus", "A rainha margot", "Coracao valente"};
        /* medieval e drama */

        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Qual ambientação você prefere?\n1 - Scifi\n2 - Medieval");
        int primeiraEscolha = Integer.parseInt(leitor.nextLine());        

        System.out.println("Qual gênero você prefere?\n1 - Comédia\n2 - Drama");
        int segundaEscolha = Integer.parseInt(leitor.nextLine());

        String[] filmes = {};
        
        if (primeiraEscolha == 1 && segundaEscolha == 1) {
            filmes = mix1;
        } else if (primeiraEscolha == 1 && segundaEscolha == 2) {
            filmes = mix2;
        } else if (primeiraEscolha == 2 && segundaEscolha == 1) {
            filmes = mix3;
        } else if (primeiraEscolha == 2 && segundaEscolha == 2) {
            filmes = mix4;
        } else {
            System.out.println("Opção inválida");
        }

        if (filmes.length > 0) {
            int index = new Random().nextInt(filmes.length);
            System.out.println("Filme recomendado: " + filmes[index]);
        } else {
            System.out.println("Nenhuma combinacao de filme encontrado");
        }

    }
}
