package br.com.spring.data.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.spring.data.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	ArrayList<Product> findByName(String name);

	ArrayList<Product> findByPrice(Double price);

	ArrayList<Product> findByNameAndPrice(String name, Double price);

}
