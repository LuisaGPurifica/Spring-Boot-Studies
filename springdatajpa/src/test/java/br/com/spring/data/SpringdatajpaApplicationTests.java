package br.com.spring.data;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.spring.data.entities.Product;
import br.com.spring.data.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringdatajpaApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	public void saveProduct() {
		ProductRepository repository = context.getBean(ProductRepository.class);

		// CREATE
		// Product product = new Product(1L, "Mac", "Awesome", 6500d);
		// repository.save(product);

		// READ BY ID
		Optional<Product> result = repository.findById(1L);
		Product product2 = null;

		if (result.isPresent())
			product2 = result.get();

		System.out.println(product2);

		// UPDATE
		// product2.setPrice(4000d);
		// repository.save(product2);

		// READ ALL
		repository.findAll().forEach(p -> {
			System.out.println(p.toString());
		});
		;

		// READ BY NAME
		System.out.println(repository.findByName("mac"));

		// READ BY PRICE
		System.out.println(repository.findByPrice(4000d));

		// READ BY NAME AND PRICE
		System.out.println(repository.findByNameAndPrice("MAC", 4000d));

	}

}
