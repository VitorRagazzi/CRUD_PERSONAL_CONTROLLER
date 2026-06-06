package br.com.crud.personalcontroller.service.serviceImpl;


import br.com.crud.personalcontroller.database.model.Alunos;
import br.com.crud.personalcontroller.database.model.dto.AlunosDTO;
import br.com.crud.personalcontroller.database.repository.AlunosRepository;
import br.com.crud.personalcontroller.service.AlunosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunosServiceImpl implements AlunosService {

    private final AlunosRepository repository;

    @Override
    public AlunosDTO criarAluno(AlunosDTO dto) {

        Alunos alunos = new Alunos(
            dto.getNome(),
            dto.getEmail(),
            dto.getTelefone()
        );

        alunos = repository.save(alunos);

        return converterParaDTO(alunos);
    }

    @Override
    public AlunosDTO buscarAlunoPorId(Integer id) {

        Alunos alunos = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return converterParaDTO(alunos);
    }

    @Override
    public List<AlunosDTO> listarAlunos() {

        List<Alunos> alunos = repository.findAll();

        return alunos.stream()
                .map(this::converterParaDTO)
                .toList();
    }

    @Override
    public AlunosDTO atualizarAluno(Integer id, AlunosDTO dto) {

        Alunos alunos = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        alunos.setNome(dto.getNome());
        alunos.setEmail(dto.getEmail());
        alunos.setTelefone(dto.getTelefone());

        alunos = repository.save(alunos);

        return converterParaDTO(alunos);
    }

    @Override
    public void deletarAluno(Integer id) {
        repository.deleteById(id);
    }

    private AlunosDTO converterParaDTO(Alunos alunos) {

        AlunosDTO dto = new AlunosDTO();

        dto.setId(alunos.getId());
        dto.setNome(alunos.getNome());
        dto.setEmail(alunos.getEmail());
        dto.setTelefone(alunos.getTelefone());

        return dto;
    }
}
