package br.com.alura.spring.data.service;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {
	private Boolean system = true; 
	private final FuncionarioRepository funcionarioRepository;
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		Scanner opção = new Scanner(System.in);
		
		while(system) {
			System.out.println();
			System.out.println("Qual ação você quer no cargo");
			System.out.println("0 -> SAIR");
			System.out.println("1 -> Salvar funcionario");
			System.out.println("2 -> Atualizar funcionario");
			System.out.println("3 -> Vizualizar funcionario");
			System.out.println("4 -> Deletar funcionario");
			System.out.println();
			int action = opção.nextInt();
			switch (action) {
			case 0:
				system = false;
				break;
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				vizualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				System.out.println();
				System.out.println("Valor invalido, tente algumas das opções sugeridas!");
				System.out.println();
			}
		}
	}
	
	private void salvar(Scanner scanner) {
		System.out.println();
		System.out.println("Nome do funcionario");
		String nome = scanner.next();
		System.out.println("CPF do funcionario");
		String cpf = scanner.next();
		System.out.println("Salario do funcionario");
		BigDecimal salario = scanner.nextBigDecimal();
		Funcionario funcionario = new Funcionario(nome, cpf, salario);
		funcionarioRepository.save(funcionario);
		System.out.println("Salvo com successo");
		System.out.println();
	}

	private void atualizar(Scanner scanner) {
		System.out.println();
		System.out.println("Degite o id do funcionario que deseja atualizar");
		Integer id = scanner.nextInt();
		System.out.println("Nome do funcionario");
		String nome = scanner.next();
		System.out.println("CPF do funcionario");
		String cpf = scanner.next();
		System.out.println("Salario do funcionario");
		BigDecimal salario = scanner.nextBigDecimal();
		Funcionario funcionario = new Funcionario(id,nome, cpf, salario);
		funcionarioRepository.save(funcionario);
		System.out.println("Atualizado com successo");
		System.out.println();
	}
	
	private void vizualizar() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
		System.out.println();
	}

	
	private void deletar(Scanner scanner) {
		System.out.println();
		System.out.println("Digite Id que deseja deletar");
		Integer id = scanner.nextInt();
		funcionarioRepository.deleteById(id);
		System.out.println("Deletado com sucesso");
		System.out.println();
	}
	
	
	
}
