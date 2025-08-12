package br.com.projectData.projetoTeste.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{


        private BigDecimal salario;
        private String funcao;


        public Funcionario(){
            super();
        }

        public Funcionario(DadosFuncionario dadosFuncionario) {
                super(dadosFuncionario.dadosPessoa());
                this.salario = dadosFuncionario.salario();
                this.funcao = dadosFuncionario.funcao();
        }

        public BigDecimal getSalario() {
                return salario;
        }

        public void setSalario(BigDecimal salario) {
                this.salario = salario;
        }

        public String getFuncao() {
                return funcao;
        }

        public void setFuncao(String funcao) {
                this.funcao = funcao;
        }
}
