package io.github.kelvinmacedo.repository;

import io.github.kelvinmacedo.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    @Query(value = "select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> encontarPorNome(@Param("nome") String nome);


}
