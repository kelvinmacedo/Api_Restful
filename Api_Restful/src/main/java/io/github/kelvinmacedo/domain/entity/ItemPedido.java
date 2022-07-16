package io.github.kelvinmacedo.domain.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {

    private Integer id;
    private Pedido pedido;
    private Produto produto;
    private Integer quantidade;

}
