package io.github.kelvinmacedo.repository;

import io.github.kelvinmacedo.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String nome);
}
