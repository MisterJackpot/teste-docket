package com.misterjackpot.cartorio.service;

import com.misterjackpot.cartorio.config.exception.ResourceNotFoundException;
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

    public CartorioDTO salvarCartorio(CartorioDTO cartorio) {
        return converter.toDTO(repository.save(converter.toEntity(cartorio)));
    }

    public void excluirCartorio(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(String.format("Cartório %s não foi encontrado", id));
        }
    }

    public void atualizarCartorio(Long id, CartorioDTO cartorio) {
        if (repository.existsById(id)) {
            repository.save(converter.toEntity(cartorio));
        } else {
            throw new ResourceNotFoundException(String.format("Cartório %s não foi encontrado", id));
        }
    }

    public CartorioDTO buscarCartorio(Long id) {
        if (repository.existsById(id)) {
            return converter.toDTO(repository.getById(id));
        } else {
            throw new ResourceNotFoundException(String.format("Cartório %s não foi encontrado", id));
        }

    }
}
