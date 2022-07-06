package io.github.kelvinmacedo.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;
@Entity
@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Integer codigoProduto;
    private String descricao;
    private BigDecimal precoProduto;

}
