package br.com.crud.personalcontroller.service;

import br.com.crud.personalcontroller.database.model.dto.AlunosDTO;

import java.util.List;

public interface AlunosService {
    AlunosDTO criarAluno(AlunosDTO alunosDTO);
    AlunosDTO buscarAlunoPorId(Integer id);
    List<AlunosDTO> listarAlunos();
    AlunosDTO atualizarAluno(Integer id, AlunosDTO dto);
    void deletarAluno(Integer id);


}
