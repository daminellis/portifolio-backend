package com.example.demo.mapper;

import com.example.demo.dto.ContaDTO;
import com.example.demo.model.Conta;

public class ContaMapper {

    public static ContaDTO toDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}
