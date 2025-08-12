package br.com.projectData.projetoTeste;

import br.com.projectData.projetoTeste.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoTesteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTesteApplication.class, args);
	}


	@Override
	public void run(String... args){
		Principal principal=new Principal();
	}
}
