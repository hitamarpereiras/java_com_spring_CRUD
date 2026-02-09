package com.hitamardev.agendador_horarios.controller;

import java.time.LocalDateTime;

import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hitamardev.agendador_horarios.infrastructure.entity.Agendamento;
import com.hitamardev.agendador_horarios.services.AgendamentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping // Endpoint para criar um novo agendamento
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento){
        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping // Endpoint para deletar um agendamento existente
    public ResponseEntity<Void> deletarAgendamento(@RequestBody String cliente, LocalDateTime dataHoraAgendamento){
        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping // Endpoint para listar todos os agendamentos
    public ResponseEntity<Agendamento> buscarAgendamentosDia(LocalDateTime dataHoraAgendamento){
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamento(dataHoraAgendamento));
    }

    @PutMapping // Endpoint para atualizar os dados de um agendamento existente
    public ResponseEntity<Agendamento> alterarAgendamentos(@RequestBody Agendamento agendamento, String cliente, LocalDateTime dataHoraAgendamento){
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamento, cliente, dataHoraAgendamento));
    }

}
