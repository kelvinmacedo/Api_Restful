package io.github.kelvinmacedo.domain.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private Integer numeroPedido;
    private Cliente cliente;
    private LocalDate dataPedido;
    private BigDecimal total;

}
