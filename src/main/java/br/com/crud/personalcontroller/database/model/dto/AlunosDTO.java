package br.com.crud.personalcontroller.database.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlunosDTO {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;

    public AlunosDTO(AlunosInterfaceDTO x) {
        this.id = x.getId();
        this.nome = x.getNome();
        this.email = x.getEmail();
        this.telefone = x.getTelefone();
    }

    public interface AlunosInterfaceDTO {
        Integer getId();
        String getNome();
        String getEmail();
        String getTelefone();
    }
}
