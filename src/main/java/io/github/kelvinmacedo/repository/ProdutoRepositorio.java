package io.github.kelvinmacedo.repository;

import io.github.kelvinmacedo.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {



}
