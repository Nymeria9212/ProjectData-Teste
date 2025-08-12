package br.com.projectData.projetoTeste.repository;

import br.com.projectData.projetoTeste.model.Funcionario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Funcionario f WHERE f.nome LIKE CONCAT('%', :nome, '%')")
    void deleteByName(@Param("nome") String nome);


}
