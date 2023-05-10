package com.coderhouse.Clase8;

import com.coderhouse.Clase8.model.Client;
import com.coderhouse.Clase8.model.Product;
import com.coderhouse.Clase8.repository.ProductRepository;
import com.coderhouse.Clase8.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Clase8Application implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(Clase8Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");
        Product taza = new Product();
		taza.setCode("dasdfasdf");
		taza.setDescription("400 ml");
		taza.setPrice(10);
		taza.setStock(100);
		this.productRepository.save(taza);

		Client elementi = new Client();
		elementi.setDocnumber(32258123);
		elementi.setName("Lucas");
		elementi.setLastname("Verge");
		this.clientRepository.save(elementi);

		Optional<Product> productoObtenido = this.productRepository.findById(1);
		if (productoObtenido.isPresent()) System.out.println(productoObtenido.get());

		Optional<Client> clienteObtenido = this.clientRepository.findById(1);
		if (clienteObtenido.isPresent()) System.out.println(clienteObtenido.get());
	}

}
