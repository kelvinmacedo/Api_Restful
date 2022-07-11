package io.github.kelvinmacedo.domain.entity;

import lombok.*;

import java.math.BigDecimal;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Integer codigoProduto;
    private String descricao;
    private BigDecimal precoProduto;

}
