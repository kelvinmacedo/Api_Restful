package io.github.kelvinmacedo;

import io.github.kelvinmacedo.domain.entity.Cliente;
import io.github.kelvinmacedo.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init( @Autowired ClienteRepositorio clientes){
		return args -> {

			System.out.println("salvando clientes");
			clientes.save(new Cliente("kelvin"));
			clientes.save(new Cliente("fulano"));

			System.out.println("Buscar por nome");
			List<Cliente> resultado = clientes.encontarPorNome("fulano");
			resultado.forEach(System.out::println);
		};
	}
	public static void main(String[] args) {

		SpringApplication.run(VendasApplication.class, args);

	}

}
