package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private final CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		Boolean system = true; 
		Scanner opção = new Scanner(System.in);
		
		while(system) {
			System.out.println();
			System.out.println("Qual ação você quer no cargo");
			System.out.println("0 -> SAIR");
			System.out.println("1 -> Salvar cargo");
			System.out.println("2 -> Atualizar cargo");
			System.out.println("3 -> Vizualizar cargo");
			System.out.println("4 -> Deletar cargo");
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
				vizualizar(scanner);
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
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo com successo");
		System.out.println();
	}

	private void atualizar(Scanner scanner) {
		System.out.println();
		System.out.println("Degite o id que deseja atualizar");
		Integer id = scanner.nextInt();
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Atualizado com successo");
		System.out.println();
	}
	
	private void vizualizar(Scanner scanner) {
		System.out.println("Qual pagina você deseja visualizar");
		Integer page = scanner.nextInt();
		
		Pageable pageable = PageRequest.of(page, 5, Sort.unsorted());
		Page<Cargo> cargos = cargoRepository.findAll(pageable);
		
		System.out.println(cargos);
		System.out.println("Pagina atual " + cargos.getNumber());
		System.out.println("Total elemento " + cargos.getTotalElements());
		cargos.forEach(cargo -> System.out.println(cargo));
		System.out.println();
	}

	
	private void deletar(Scanner scanner) {
		System.out.println();
		System.out.println("Digite Id que deseja deletar");
		Integer id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Deletado com sucesso");
		System.out.println();
	}
	
}
