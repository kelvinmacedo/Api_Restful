package io.github.kelvinmacedo;

import io.github.kelvinmacedo.domain.entity.Cliente;
import io.github.kelvinmacedo.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner Init( @Autowired ClienteRepositorio clientes){
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setNome("kelvin");
			clientes.salvar(cliente);
		};
	}
	public static void main(String[] args) {

		SpringApplication.run(VendasApplication.class, args);

	}

}
