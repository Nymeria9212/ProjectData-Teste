package br.com.projectData.projetoTeste.model;

import java.math.BigDecimal;

public record DadosFuncionario(DadosPessoa dadosPessoa,BigDecimal salario, String funcao) {
}
