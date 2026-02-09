package com.hitamardev.agendador_horarios.infrastructure.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hitamardev.agendador_horarios.infrastructure.entity.Agendamento;

import jakarta.transaction.Transactional;

public interface AgendamentoRopository extends JpaRepository<Agendamento, Long>{
    Agendamento findByServicoDataHoraAgendamentoBetween(String servico, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal);

    @Transactional
    void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

    Agendamento findByDataHoraAgendamentoBeteween(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal);

    Agendamento findByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);
}
