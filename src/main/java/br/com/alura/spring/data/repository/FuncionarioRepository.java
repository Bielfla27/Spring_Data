package br.com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {
		
	List<Funcionario> findByNome(String nome); //Derived Query
	
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome "  
		 + "AND f.salario >= :salario AND f.dataContratacao = :dataContratacao")
	List<Funcionario> findNomeSalarioMaiorDataContratacap(String nome, double salario, LocalDate dataContratacao); //Usando JPQL
	
	@Query(value = "SELECT * FROM Funcionarios f WHERE f.data_contratacao >= :data",
			nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data); //Usando nativeQuery parêmetros do banco
	
	@Query(value = "select f.id, f.nome , f.salario  from funcionarios f" , nativeQuery = true)
	List<FuncionarioProjecao> findFuncionarioSalario();
}
