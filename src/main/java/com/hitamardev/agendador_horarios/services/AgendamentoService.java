package com.hitamardev.agendador_horarios.services;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.hitamardev.agendador_horarios.infrastructure.entity.Agendamento;
import com.hitamardev.agendador_horarios.infrastructure.repository.AgendamentoRopository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Gera um construtor para as dependências finais
public class AgendamentoService {

    private final AgendamentoRopository agendamentoRopository;

    public Agendamento salvarAgendamento(Agendamento agendamento){

        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1);

        Agendamento agendados = agendamentoRopository.findByServicoDataHoraAgendamentoBetween(agendamento.getServico(), horaAgendamento, horaFim);

        if (Objects.nonNull(agendados)){
            throw new RuntimeException("Já existe um agendamento para esse horário.");
        }else{
            return agendamentoRopository.save(agendamento);
        }

    }
    public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente){
        
        agendamentoRopository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);

    }
    public Agendamento buscarAgendamento(LocalDateTime data){
        LocalDateTime primeiraHoraDia = data.toLocalDate().atStartOfDay();
        LocalDateTime horaFinalDia = data.withHour(23).withMinute(59).withSecond(59); // Define a hora final do dia

        return agendamentoRopository.findByDataHoraAgendamentoBeteween(primeiraHoraDia, horaFinalDia);

    }

    // Update do agedamento
    public Agendamento alterarAgendamento(Agendamento agendamento, String cliente, LocalDateTime dataHoraAgendamento){
        Agendamento agenda = agendamentoRopository.findByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);

        if (Objects.isNull(agenda)){
            throw new RuntimeException("Agendamento não encontrado!");
        }else{
            agendamento.setId(agenda.getId());
            return agendamentoRopository.save(agendamento);
        }

    }

}
