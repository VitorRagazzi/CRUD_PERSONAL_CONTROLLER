package br.com.crud.personalcontroller.service.serviceImpl;


import br.com.crud.personalcontroller.database.model.Alunos;
import br.com.crud.personalcontroller.database.model.dto.AlunosDTO;
import br.com.crud.personalcontroller.database.repository.AlunosRepository;
import br.com.crud.personalcontroller.service.AlunosService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunosServiceImpl implements AlunosService {

    private final AlunosRepository repository;

    @Override
    public List<AlunosDTO> listarAlunos() {
        return repository.findAllBy()
                .stream()
                .map(AlunosDTO::new)
                .toList();
    }

    @Override
    @Transactional
    public AlunosDTO criarAluno(AlunosDTO dto) {
        validarCamposObrigatorios(dto);
        if (repository.existsByEmail(dto.getEmail()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado!");

        if (repository.existsByTelefone(dto.getTelefone()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Telefone já cadastrado!");

        Alunos aluno = new Alunos(dto.getNome(), dto.getEmail(), dto.getTelefone());
        aluno = repository.saveAndFlush(aluno);

        return repository.findAlunoById(aluno.getId())
                .map(AlunosDTO::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao salvar aluno"));
    }

    @Override
    public AlunosDTO buscarAlunoPorId(Integer id) {
        return repository.findAlunoById(id)
                .map(AlunosDTO::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @Override
    @Transactional
    public AlunosDTO atualizarAluno(Integer id, AlunosDTO dto) {
        Alunos alunos = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado com o ID: " + id));
        validarCamposObrigatorios(dto);

        if(repository.existsByEmailAndIdNot(dto.getEmail(), id))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado para outro aluno!");

        if(repository.existsByTelefoneAndIdNot(dto.getTelefone(), id))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Telefone já cadastrado para outro aluno!");

        alunos.setNome(dto.getNome());
        alunos.setEmail(dto.getEmail());
        alunos.setTelefone(dto.getTelefone());

        repository.saveAndFlush(alunos);

        return repository.findAlunoById(id)
                .map(AlunosDTO::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar aluno"));
    }

    @Override
    @Transactional
    public void deletarAluno(Integer id) {
        Optional<Alunos> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
        } else {
            throw new EntityNotFoundException("Aluno não encontrado com ID: " + id);
        }
    }

    private void validarCamposObrigatorios(AlunosDTO dto) {
        if (dto.getNome() == null || dto.getNome().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome é obrigatório!");

        if (dto.getEmail() == null || dto.getEmail().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O e-mail é obrigatório!");

        if (dto.getTelefone() == null || dto.getTelefone().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O telefone é obrigatório!");
    }
}
