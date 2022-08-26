package io.github.kelvinmacedo.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    public ItemPedido() {
    }

    public ItemPedido(Integer id, Pedido pedido, Produto produto, Integer quantidade) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }


}
