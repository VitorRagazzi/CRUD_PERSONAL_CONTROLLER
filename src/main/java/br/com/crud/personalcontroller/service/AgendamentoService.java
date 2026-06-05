package br.com.crud.personalcontroller.service;

import br.com.crud.personalcontroller.database.model.dto.AlunosDTO;

import java.util.List;

public interface AgendamentoService {
    AlunosDTO salvarAgendamento(AlunosDTO alunosDTO);
    AlunosDTO buscarPorId(Integer id);
    List<AlunosDTO> listarAgendamentos();
    void excluirAgendamento(Integer id);
}
