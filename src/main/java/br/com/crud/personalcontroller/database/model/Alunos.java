package br.com.crud.personalcontroller.database.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alunos")
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONE")
    private String telefone;

}
