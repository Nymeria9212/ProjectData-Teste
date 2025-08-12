package br.com.projectData.projetoTeste.principal;

import br.com.projectData.projetoTeste.model.DadosFuncionario;
import br.com.projectData.projetoTeste.model.DadosPessoa;
import br.com.projectData.projetoTeste.model.Funcionario;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {


    private List<Funcionario> funcionarios=new ArrayList<>();

    public Principal() {

        insertFuncionarios();
        RemoverJoao();
        ListarFuncionarios();
        atualizarSalario();
        listarPorFuncao();
        aniversariantes();
        maisVelhos();
        listarOrdemAlf();
        totalSalarios();
    }


    public void insertFuncionarios(){

        DadosPessoa maria=new DadosPessoa("Maria", LocalDate.of(2000,10,18));
        DadosFuncionario f1=new DadosFuncionario(maria,new BigDecimal(2009.44),"Operador");

        DadosPessoa joao=new DadosPessoa("João",LocalDate.of(1990,5,12));
        DadosFuncionario f2= new DadosFuncionario(joao,new BigDecimal(2284.38),"Operador");

        DadosPessoa caio=new DadosPessoa("Caio",LocalDate.of(1961,5,2));
        DadosFuncionario f3=new DadosFuncionario(caio,new BigDecimal(9836.14),"Coordenador");

        DadosPessoa miguel=new DadosPessoa("Miguel",LocalDate.of(1988,10,14));
        DadosFuncionario f4=new DadosFuncionario(miguel,new BigDecimal(19119.88),"Diretor");

        DadosPessoa alice=new DadosPessoa("Alice",LocalDate.of(1995,1,5));
        DadosFuncionario f5=new DadosFuncionario(alice,new BigDecimal(2234.68),"Recepcionista");

        DadosPessoa heitor=new DadosPessoa("Heitor",LocalDate.of(1999,11,19));
        DadosFuncionario f6=new DadosFuncionario(heitor,new BigDecimal(1582.72),"Operador");

        DadosPessoa arthur=new DadosPessoa("Arthur",LocalDate.of(1993,3,31));
        DadosFuncionario f7=new DadosFuncionario(arthur,new BigDecimal(4071.84),"Contador");

        DadosPessoa laura=new DadosPessoa("Laura",LocalDate.of(1994,7,8));
        DadosFuncionario f8=new DadosFuncionario(laura,new BigDecimal(3017.45),"Gerente");

        DadosPessoa heloisa=new DadosPessoa("Heloisa",LocalDate.of(2003,5,24));
        DadosFuncionario f9=new DadosFuncionario(heloisa,new BigDecimal(1606.85),"Eletricista");

        DadosPessoa helena=new DadosPessoa("Helena",LocalDate.of(1996,9,2));
        DadosFuncionario f10=new DadosFuncionario(helena,new BigDecimal(2799.93),"Gerente");

        funcionarios.add(new Funcionario(f1));
        funcionarios.add(new Funcionario(f2));
        funcionarios.add(new Funcionario(f3));
        funcionarios.add(new Funcionario(f4));
        funcionarios.add(new Funcionario(f5));
        funcionarios.add(new Funcionario(f6));
        funcionarios.add(new Funcionario(f7));
        funcionarios.add(new Funcionario(f8));
        funcionarios.add(new Funcionario(f9));
        funcionarios.add(new Funcionario(f10));


    }


    public void RemoverJoao(){
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));

    }

    public void ListarFuncionarios(){


        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);

        for (Funcionario f : funcionarios) {
            // Pegando os dados da pessoa dentro do funcionário
            String nome = f.getNome();
            String dataFormatada = f.getData_nascimento().format(dateFormatter);
            String salarioFormatado = decimalFormat.format(f.getSalario());
            String cargo = f.getFuncao();

            System.out.println("--------------------------");
            System.out.println("Nome: " + nome);
            System.out.println("Data de Nascimento: " + dataFormatada);
            System.out.println("Salário: R$ " + salarioFormatado);
            System.out.println("Cargo: " + cargo);
            System.out.println("--------------------------");
        }
    }

    public void atualizarSalario(){
        funcionarios.forEach(funcionario ->
                funcionario.setSalario(funcionario.getSalario().add(funcionario.getSalario().multiply(new BigDecimal("0.1"))))
        );
    }

    public void listarPorFuncao(){
        System.out.println("Lista por função:");
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(funcionario -> funcionario.getFuncao()));

        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(f -> System.out.println("  - " + f.getNome()));
        });

        System.out.println("-----------------");


    }

    public void aniversariantes(){
        System.out.println("Aniversariantes de Outubro e Dezembro");
        funcionarios.stream().filter(funcionario -> {int mes=funcionario.getData_nascimento().getMonthValue();
        return mes==10||mes==12;
        }).forEach(funcionario -> {
            System.out.println(funcionario.getNome());
        });

        System.out.println("-----------");
    }

    public void maisVelhos(){

        System.out.println("Mais velho:");
        Optional<Funcionario> funcionarioMaisVelho = funcionarios.stream()
                .max((f1, f2) -> {
                    LocalDate nascimento1 = f1.getData_nascimento();
                    LocalDate nascimento2 = f2.getData_nascimento();
                    // Quanto mais antigo, maior a idade
                    return nascimento2.compareTo(nascimento1);
                });

        funcionarioMaisVelho.ifPresent(f -> {
            String nome = f.getNome();
            LocalDate nascimento = f.getData_nascimento();
            int idade = Period.between(nascimento, LocalDate.now()).getYears();

            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
        });
    }

    public void listarOrdemAlf(){

        System.out.println("---Ordem alfabetica------");
        List<Funcionario> ordemAlfFunc=funcionarios.stream().sorted(Comparator.comparing(funcionario -> funcionario.getNome())).collect(Collectors.toList());

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        for (Funcionario f : ordemAlfFunc) {
            // Pegando os dados da pessoa dentro do funcionário
            String nome = f.getNome();
            String dataFormatada = f.getData_nascimento().format(dateFormatter);
            String salarioFormatado = decimalFormat.format(f.getSalario());
            String cargo = f.getFuncao();

            System.out.println("--------------------------");
            System.out.println("Nome: " + nome);
            System.out.println("Data de Nascimento: " + dataFormatada);
            System.out.println("Salário: R$ " + salarioFormatado);
            System.out.println("Cargo: " + cargo);
            System.out.println("--------------------------");
        }
    }

    public void totalSalarios(){
        BigDecimal somaSalario=funcionarios.stream().map(f->f.getSalario()).reduce(BigDecimal.ZERO,BigDecimal::add);
        System.out.println("Soma dos salarios: R$"+somaSalario);
    }

    public void salariosMinimos(){
        //não consegui fazer essa parte
    }
}
