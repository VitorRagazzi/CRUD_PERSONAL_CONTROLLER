package br.com.crud.personalcontroller.database.repository;

import br.com.crud.personalcontroller.database.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Integer> {
}
