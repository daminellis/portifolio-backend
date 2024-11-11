package com.example.exercicio13.mapper;

import com.example.exercicio13.dto.JogadorDTO;
import com.example.exercicio13.entity.Jogador;
import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {

    public Jogador toEntity(JogadorDTO dto) {
        Jogador jogador = new Jogador();
        jogador.setNome(dto.getNome());
        jogador.setIdade(dto.getIdade());
        jogador.setPosicao(dto.getPosicao());
        return jogador;
    }

    public JogadorDTO toDTO(Jogador jogador) {
        JogadorDTO dto = new JogadorDTO();
        dto.setNome(jogador.getNome());
        dto.setIdade(jogador.getIdade());
        dto.setPosicao(jogador.getPosicao());
        return dto;
    }
}
