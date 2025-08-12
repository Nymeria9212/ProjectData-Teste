package br.com.projectData.projetoTeste.principal;

import br.com.projectData.projetoTeste.model.DadosFuncionario;
import br.com.projectData.projetoTeste.model.DadosPessoa;
import br.com.projectData.projetoTeste.model.Funcionario;
import br.com.projectData.projetoTeste.repository.FuncionarioRepository;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    private FuncionarioRepository repository;
    private List<Funcionario> funcionarios=new ArrayList<>();

    public Principal(FuncionarioRepository repository) {
        this.repository = repository;
        insertFuncionarios();
        RemoverJoao();
        ListarFuncionarios();
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

        Funcionario func1=new Funcionario(f1);
        Funcionario func2=new Funcionario(f2);
        Funcionario func3=new Funcionario(f3);
        Funcionario func4=new Funcionario(f4);
        Funcionario func5=new Funcionario(f5);
        Funcionario func6=new Funcionario(f6);
        Funcionario func7=new Funcionario(f7);
        Funcionario func8=new Funcionario(f8);
        Funcionario func9=new Funcionario(f9);
        Funcionario func10=new Funcionario(f10);

        repository.saveAll(List.of(func1,func2,func3,func4,func5,func6,func7,func8,func9,func10));


    }


    public void RemoverJoao(){
            repository.deleteByName("João");
    }

    public void ListarFuncionarios(){
        List<Funcionario> funcionarios = repository.findAll();

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
}
