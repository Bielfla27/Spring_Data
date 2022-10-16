package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private final FuncionarioRepository funcionarioRepository;
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		Boolean system = true; 

		Scanner opção = new Scanner(System.in);
		
		while(system) {
			System.out.println();
			System.out.println("Qual ação você quer no cargo");
			System.out.println("0 -> SAIR");
			System.out.println("1 -> Buscar funcionario pelo nome");
			System.out.println();
			int action = opção.nextInt();
			switch (action) {
			case 0:
				system = false;
				break;
			case 1:
				buscarPorNome(scanner);
				break;
			default:
				System.out.println();
				System.out.println("Valor invalido, tente algumas das opções sugeridas!");
				System.out.println();
			}
		}
	}
	
	private void buscarPorNome(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = scanner.next();
		List<Funcionario> listFuncionario = funcionarioRepository.findByNome(nome);
		listFuncionario.forEach(System.out::println);
	}
}
