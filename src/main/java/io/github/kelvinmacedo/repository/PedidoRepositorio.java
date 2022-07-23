package io.github.kelvinmacedo.repository;

import io.github.kelvinmacedo.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {

}
