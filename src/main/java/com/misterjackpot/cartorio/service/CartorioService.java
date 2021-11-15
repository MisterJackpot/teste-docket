package com.misterjackpot.cartorio.service;

import com.misterjackpot.cartorio.converter.CartorioConverter;
import com.misterjackpot.cartorio.dto.CartorioDTO;
import com.misterjackpot.cartorio.infra.repository.CartorioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartorioService {

    private final CartorioRepository repository;
    private final CartorioConverter converter;

    public List<CartorioDTO> buscarCartorios() {
        return repository.findAll().stream()
                .map(converter::toDTO)
                .collect(Collectors.toList());
    }

    public void salvarCartorio(CartorioDTO cartorio) {
        repository.save(converter.toEntity(cartorio));
    }

    public void excluirCartorio(Long id) {
        repository.deleteById(id);
    }

    public void atualizarCartorio(Long id, CartorioDTO cartorio) {
        repository.save(converter.toEntity(cartorio));
    }

    public CartorioDTO buscarCartorio(Long id){
        return converter.toDTO(repository.getById(id));
    }
}
