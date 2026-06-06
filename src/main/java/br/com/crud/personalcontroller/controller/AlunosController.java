package br.com.crud.personalcontroller.controller;

import br.com.crud.personalcontroller.database.model.Alunos;
import br.com.crud.personalcontroller.database.model.dto.AlunosDTO;
import br.com.crud.personalcontroller.service.AlunosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alunos")

public class AlunosController {
    private final AlunosService alunosService;

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @GetMapping
    public ResponseEntity<List<AlunosDTO>> listarAlunos() {
        return ResponseEntity.ok(alunosService.listarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunosDTO> buscarAlunoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(alunosService.buscarAlunoPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlunosDTO> criarAluno(@RequestBody AlunosDTO dto) {
        return ResponseEntity.status(201).body(alunosService.criarAluno(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunosDTO> atualizarAluno(@PathVariable Integer id,
            @RequestBody AlunosDTO dto) {
        return ResponseEntity.ok(alunosService.atualizarAluno(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Integer id) {
        alunosService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
