package com.misterjackpot.cartorio.api.v1;

import com.misterjackpot.cartorio.dto.CartorioDTO;
import com.misterjackpot.cartorio.service.CartorioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cartorios")
@AllArgsConstructor
public class CartorioRest {

    private final CartorioService service;

    @GetMapping
    public ResponseEntity<List<CartorioDTO>> buscar() {
        return ResponseEntity.ok(service.buscarCartorios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartorioDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.buscarCartorio(id));
    }

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody CartorioDTO cartorio) {
        cartorio = service.salvarCartorio(cartorio);

        return ResponseEntity.created(URI.create("/cartorios/" + cartorio.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        service.excluirCartorio(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody CartorioDTO cartorio){
        service.atualizarCartorio(id, cartorio);
        return ResponseEntity.ok().build();
    }
}
