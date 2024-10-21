package com.example.demo.controller;

import com.example.demo.dto.TransacaoRequestDTO;
import com.example.demo.dto.TransacaoResponseDTO;
import com.example.demo.mapper.ContaMapper;
import com.example.demo.model.Transacao;
import com.example.demo.service.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> gerarTransacao(@RequestBody TransacaoRequestDTO request) {
        //gerando a exeption
        Transacao transacao = transacoesService.realizarTransacao(
                request.origem(),
                request.destino(),
                request.valor()
        );

        //exeption com mapeamento
        TransacaoResponseDTO response = new TransacaoResponseDTO(
                ContaMapper.toDTO(transacao.getOrigem()),
                ContaMapper.toDTO(transacao.getDestino()),
                transacao.getValor()
        );

        return ResponseEntity.ok(response);
    }

    //exption de conta nao encontrada
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());
        errorResponse.put("error", "Erro de processamento");
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("timestamp", System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
