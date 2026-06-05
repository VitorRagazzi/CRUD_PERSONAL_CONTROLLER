package br.com.crud.personalcontroller.database.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONE")
    private String telefone;

}
