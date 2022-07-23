package io.github.kelvinmacedo.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Getter @Setter
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_pedido")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @Column(name = "total", precision = 20, scale = 2)
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> item;

    public Pedido() {
    }

    public Pedido(Integer id, Cliente cliente, LocalDate dataPedido, BigDecimal total) {
        this.id = id;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", dataPedido=" + dataPedido +
                ", total=" + total +
                '}';
    }
}
