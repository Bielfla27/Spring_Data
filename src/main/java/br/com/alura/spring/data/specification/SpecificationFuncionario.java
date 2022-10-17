package br.com.alura.spring.data.specification;

import java.time.LocalDate;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.criterion.CriteriaQuery;
import org.springframework.data.jpa.domain.Specification;

import br.com.alura.spring.data.orm.Funcionario;

public class SpecificationFuncionario {
	
	public static Specification<Funcionario> nome(String nome){
		return (root, CriteriaQuery, CriteriaBuilder) -> 
				CriteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
	
	public static Specification<Funcionario> cpf(String cpf){
		return (root, CriteriaQuery, CriteriaBuilder) -> 
				CriteriaBuilder.equal(root.get("cpf"), cpf); 
	}
	
	public static Specification<Funcionario> salario(Double salario){
		return (root, CriteriaQuery, CriteriaBuilder) -> 
				CriteriaBuilder.greaterThan(root.get("salario"), salario);
	}
	
	public static Specification<Funcionario> dataCotratacao(LocalDate dataCotratacao){
		return (root, CriteriaQuery, CriteriaBuilder) -> 
				CriteriaBuilder.greaterThan(root.get("dataCotratacao"), dataCotratacao);
	}

}
