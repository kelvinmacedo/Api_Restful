package io.github.kelvinmacedo.domain.entity;

import lombok.*;




public class ItemPedido {

    private Integer id;
    private Pedido pedido;
    private Produto produto;
    private Integer quantidade;

}
