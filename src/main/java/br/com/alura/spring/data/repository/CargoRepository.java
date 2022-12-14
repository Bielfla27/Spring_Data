package br.com.alura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Cargo;

@Repository
public interface CargoRepository extends PagingAndSortingRepository<Cargo, Integer> { //passo como parâmetro o tipo do objeto e o tipo do ID desse objeto

	
}
