package com.example.demo.service;

import com.example.demo.model.Conta;
import com.example.demo.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService {

    private List<Conta> contas = new ArrayList<>();

    public TransacoesService() {
        //inicializando duas contas
        contas.add(new Conta("500-1", "Fulano", 1000.0));
        contas.add(new Conta("320-2", "Ciclano", 500.0));
    }

    //fazendo a transacao nas duas contas
    public Transacao realizarTransacao(String origemCodigo, String destinoCodigo, Double valor) {
        Conta origem = buscarContaPorCodigo(origemCodigo);
        Conta destino = buscarContaPorCodigo(destinoCodigo);

        if (origem.getSaldo() < valor) {
            throw new RuntimeException("Saldo insuficiente na conta de origem.");
        }

        origem.setSaldo(origem.getSaldo() - valor);
        destino.setSaldo(destino.getSaldo() + valor);

        return new Transacao(origem, destino, valor);
    }

    // runtime roda caso nao ache o fulano ou ciclano
    private Conta buscarContaPorCodigo(String codigo) {
        return contas.stream()
                .filter(conta -> conta.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Conta com o código " + codigo + " não foi encontrada."));
    }
}
