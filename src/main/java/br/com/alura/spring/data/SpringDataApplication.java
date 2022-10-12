package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private Boolean system = true;
	
	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual ação você quer executar");
			System.out.println("0 -> SAIR");
			System.out.println("1 -> Cargo");
			System.out.println("2 -> Funcionario");
			int action = scanner.nextInt();
			switch (action) {
			case 0:
				system = false;
				break;
			case 1:
				cargoService.inicial(scanner);
				break;
			case 2:
				funcionarioService.inicial(scanner);
				break;
			default:
				System.out.println();
				System.out.println("Valor invalido, tente algumas das opções sugeridas!");
				System.out.println();
			}
		}
		
	}

}
