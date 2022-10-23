package io.github.kelvinmacedo.repository;

import io.github.kelvinmacedo.domain.entity.Cliente;
import io.github.kelvinmacedo.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
    @Query(value = "select * from c where c.descricao_produto like '%descricao_produto%'", nativeQuery = true)
    List<Cliente> encontarProduto(@Param("descricao") String descricao);

    //@Query(value = "select * from c where c.descricao_produto =:descricao_produto")
    //@Modifying
    //void deleteByName(String descricao_produto);


}
