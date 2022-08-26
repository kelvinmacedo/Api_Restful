package io.github.kelvinmacedo.restController;

import io.github.kelvinmacedo.domain.entity.Cliente;
import io.github.kelvinmacedo.repository.ClienteRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClienteControle {

    private ClienteRepositorio clientes;

    public ClienteControle(ClienteRepositorio clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/api/cliente/{id}")
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id){
        Optional<Cliente> cliente = clientes.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("api/cadastrar")
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente cliente ){
        Cliente salvarCliente = clientes.save(cliente);
        return ResponseEntity.ok(salvarCliente);

    }
    @DeleteMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<Cliente> cliente = clientes.findById(id);
        if (cliente.isPresent()){
            clientes.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Cliente cliente){
        return clientes
                .findById(id)
                .map(clienteExistente -> {
                        cliente.setId(clienteExistente.getId());
                        clientes.save(cliente);
                        return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());

    }

}
