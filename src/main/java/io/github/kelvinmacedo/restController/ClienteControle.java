package io.github.kelvinmacedo.restController;

import io.github.kelvinmacedo.domain.entity.Cliente;
import io.github.kelvinmacedo.repository.ClienteRepositorio;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControle {

    private final ClienteRepositorio clientes;

    public ClienteControle(ClienteRepositorio clientes) {
        this.clientes = clientes;
    }

    @GetMapping("{id}")
    public Cliente encontarPorNome (@PathVariable Integer id){
       return clientes
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente ){
        return clientes.save(cliente);

    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id){
        clientes.findById(id)
                .map(cliente -> {clientes.delete(cliente);
                return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente nao encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody Cliente cliente){
        clientes
                .findById(id)
                .map(clienteExistente -> {
                        cliente.setId(clienteExistente.getId());
                        clientes.save(cliente);
                        return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrador"));

    }
    @GetMapping
    public List<Cliente> find(Cliente filtro){
        ExampleMatcher matcher =ExampleMatcher
                                .matching()
                                .withIgnoreCase()
                                .withStringMatcher(
                                        ExampleMatcher.StringMatcher.CONTAINING);
        Example<Cliente> example = Example.of(filtro, matcher);
        return clientes.findAll(example);
    }
}
