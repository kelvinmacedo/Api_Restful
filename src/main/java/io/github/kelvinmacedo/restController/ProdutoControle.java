package io.github.kelvinmacedo.restController;

import io.github.kelvinmacedo.domain.entity.Produto;
import io.github.kelvinmacedo.repository.ProdutoRepositorio;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoControle {

    private final ProdutoRepositorio repositorio;

    public ProdutoControle(ProdutoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Produto save(@RequestBody Produto produto){
        return repositorio.save(produto);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable Integer id, @RequestBody Produto produto){
        repositorio
                .findById(id)
                .map(p -> {
                    produto.setId(p.getId());
                    repositorio.save(produto);
                    return produto;
                }).orElseThrow(()->
                        new ResponseStatusException(NOT_FOUND));
    }


    @GetMapping("{id}")
    public Produto encontrarProduto(@PathVariable Integer id){
        return repositorio
                .findById(id)
                .orElseThrow(()->
                        new ResponseStatusException(NOT_FOUND,
                                "Produto não encontrado"));
    }

    @GetMapping
    public List<Produto> find(Produto filtro){
        ExampleMatcher matcher =ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example<Produto> example = Example.of(filtro, matcher);
        return repositorio.findAll(example);
    }


}
