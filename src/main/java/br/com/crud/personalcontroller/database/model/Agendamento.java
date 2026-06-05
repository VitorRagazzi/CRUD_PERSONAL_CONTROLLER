package br.com.crud.personalcontroller.database.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "ALUNOS_ID", nullable = false)
    private Alunos alunos;
}
