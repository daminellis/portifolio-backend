import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.adicionarFilme(new Filme("Homem Aranha", 20.0, 12));
        cinema.adicionarFilme(new Filme("Batman", 22.0, 14));
        cinema.adicionarFilme(new Filme("Vingadores", 25.0, 16));
        cinema.adicionarFilme(new Filme("Toy Story", 15.0, 0));
        cinema.adicionarFilme(new Filme("Pânico", 18.0, 18));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            cinema.mostrarFilmes();

            try {
                System.out.println("Que filme você deseja assistir?");
                String nomeFilme = scanner.nextLine();
                Filme filme = cinema.buscarFilme(nomeFilme);

                System.out.println("Qual assento você deseja? (Exemplo: A1)");
                String assento = scanner.nextLine();

                System.out.println("Qual o seu nome?");
                String nomeCliente = scanner.nextLine();

                System.out.println("Qual a sua idade?");
                int idadeCliente = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);

                cinema.venderIngresso(cliente, filme, assento);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Deseja continuar? (sim/nao)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("nao")) {
                break;
            }
        }

        scanner.close();
    }
}
