import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cinema {
    private List<Filme> filmesDisponiveis;
    private HashMap<String, Ingresso> ingressosVendidos;

    public Cinema() {
        filmesDisponiveis = new ArrayList<>();
        ingressosVendidos = new HashMap<>();
    }

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public Filme buscarFilme(String nome) throws Exception {
        for (Filme filme : filmesDisponiveis) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        throw new Exception("Filme não encontrado!");
    }

    public void venderIngresso(Cliente cliente, Filme filme, String assento) throws Exception {
        if (ingressosVendidos.containsKey(assento)) {
            throw new Exception("O assento não está mais disponível!");
        }

        if (cliente.getIdade() < filme.getIdadeMinima()) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }

        Ingresso ingresso = new Ingresso(cliente, filme, assento);
        ingressosVendidos.put(assento, ingresso);
        System.out.println(ingresso);
    }

    public void mostrarFilmes() {
        System.out.println("Filmes disponíveis:");
        for (Filme filme : filmesDisponiveis) {
            System.out.println("- " + filme.getNome());
        }
    }
}
