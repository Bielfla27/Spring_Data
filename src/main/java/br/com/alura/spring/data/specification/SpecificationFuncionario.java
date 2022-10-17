package br.com.alura.spring.data.specification;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.criterion.CriteriaQuery;
import org.springframework.data.jpa.domain.Specification;

import br.com.alura.spring.data.orm.Funcionario;

public class SpecificationFuncionario {
	
	public static Specification<Funcionario> nome(String nome){
		return (root, CriteriaQuery, CriteriaBuilder) -> 
				CriteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}

}
