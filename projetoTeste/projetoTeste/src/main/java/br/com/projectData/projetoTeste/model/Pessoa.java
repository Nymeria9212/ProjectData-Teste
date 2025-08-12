package br.com.projectData.projetoTeste.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate data_nascimento;


    public Pessoa(){}

    public Pessoa(DadosPessoa dadosPessoa) {
        this.nome = dadosPessoa.nome();
        this.data_nascimento = dadosPessoa.dataNascimento();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }


}
