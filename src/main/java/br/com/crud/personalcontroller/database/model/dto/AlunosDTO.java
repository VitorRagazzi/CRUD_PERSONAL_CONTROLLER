package br.com.crud.personalcontroller.database.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlunosDTO {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;

    public AlunosDTO(){
    }

    public AlunosDTO(AlunosDTO alunos) {
        this.id = alunos.getId();
        this.nome = alunos.getNome();
        this.email = alunos.getTelefone();
        this.telefone = alunos.getTelefone();
    }
}
