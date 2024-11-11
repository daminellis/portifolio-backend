package com.example.exercicio13.dto;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class JogadorDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Idade é obrigatória")
    @Min(value = 18, message = "Idade mínima é 18 anos")
    private Integer idade;

    @NotBlank(message = "Posição é obrigatória")
    private String posicao;
}