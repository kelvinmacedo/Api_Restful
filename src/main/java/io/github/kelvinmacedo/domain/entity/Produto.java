package io.github.kelvinmacedo.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_produto")
    private Integer id;

    @Column(name = "descricao_produto")
    private String descricao;

    @Column(name = "preco_produto", length = 20, precision = 2)
    private BigDecimal precoProduto;

    public Produto() {
    }

    public Produto(Integer id, String descricao, BigDecimal precoProduto) {
        this.id = id;
        this.descricao = descricao;
        this.precoProduto = precoProduto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", precoProduto=" + precoProduto +
                '}';
    }
}
