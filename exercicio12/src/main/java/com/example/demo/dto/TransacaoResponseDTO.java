package com.example.demo.dto;

public record TransacaoResponseDTO(ContaDTO origem, ContaDTO destino, Double valor) {}
