package io.github.kelvinmacedo.domain.entity;

import lombok.*;



@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {

    private Integer id;
    private Pedido pedido;
    private Produto produto;
    private Integer quantidade;

}
