package com.example.exercicio13.service;

import com.example.exercicio13.dto.JogadorDTO;
import com.example.exercicio13.entity.Jogador;
import com.example.exercicio13.mapper.JogadorMapper;
import com.example.exercicio13.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository repository;

    @Autowired
    private JogadorMapper mapper;

    public JogadorDTO criarJogador(JogadorDTO jogadorDTO) {
        Jogador jogador = mapper.toEntity(jogadorDTO);
        jogador = repository.save(jogador);
        return mapper.toDTO(jogador);
    }

    public List<JogadorDTO> listarJogadores() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deletarJogador(Long id) {
        repository.deleteById(id);
    }
}