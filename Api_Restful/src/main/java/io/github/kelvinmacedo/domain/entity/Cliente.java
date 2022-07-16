package io.github.kelvinmacedo.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import java.util.UUID;
@Entity
@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private UUID id;
    private String nome;

}
