package br.com.crud.personalcontroller.database.repository;

import br.com.crud.personalcontroller.database.model.Alunos;
import br.com.crud.personalcontroller.database.model.dto.AlunosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Integer> {

    List<AlunosDTO.AlunosInterfaceDTO> findAllBy();

    Optional<AlunosDTO.AlunosInterfaceDTO> findAlunoById(Integer id);

    @Query("SELECT COUNT(a) > 0 from Alunos a where a.email = :email")
    boolean existsByEmail(@Param("email") String email);

    @Query("SELECT COUNT(a) > 0 from Alunos a where a.telefone = :telefone")
    boolean existsByTelefone(@Param("telefone") String telefone);

    @Query("SELECT COUNT(a) > 0 from Alunos a where a.email = :email and a.id <> :id")
    boolean existsByEmailAndIdNot(@Param("email") String email, @Param("id") Integer id);

    @Query("select count(a) > 0 from Alunos a where a.telefone = :telefone and a.id <> :id")
    boolean existsByTelefoneAndIdNot(@Param("telefone") String telefone, @Param("id") Integer id);
}