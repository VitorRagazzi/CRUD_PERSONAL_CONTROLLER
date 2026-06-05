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
}
