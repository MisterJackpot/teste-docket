package com.misterjackpot.cartorio.service;

import com.misterjackpot.cartorio.dto.CartorioDTO;
import com.misterjackpot.cartorio.infra.entity.CartorioEntity;
import com.misterjackpot.cartorio.infra.repository.CartorioRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartorioService {

    private final CartorioRepository repository;
    private final ModelMapper mapper;

    public List<CartorioDTO> buscarCartorios(){
        return repository.findAll().stream()
                .map(cartorio -> mapper.map(cartorio, CartorioDTO.class))
                .collect(Collectors.toList());
    }

    public void salvarCartorio(CartorioDTO cartorio){
        repository.save(mapper.map(cartorio, CartorioEntity.class));
    }

    public void excluirCartorio(Long id){
        repository.deleteById(id);
    }
}
