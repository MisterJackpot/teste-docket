package com.misterjackpot.cartorio.converter;

import com.misterjackpot.cartorio.dto.CartorioDTO;
import com.misterjackpot.cartorio.infra.entity.CartorioEntity;
import com.misterjackpot.cartorio.infra.entity.CertidaoEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CartorioConverter {

    public CartorioEntity toEntity(CartorioDTO dto) {
        CartorioEntity entity = CartorioEntity.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .endereco(dto.getEndereco())
                .build();

        entity.setCertidoes(dto.getCertidoes().stream().map(certidao -> CertidaoEntity.builder()
                .cartorio(entity)
                .tipo(certidao)
                .build())
                .collect(Collectors.toList())
        );

        return entity;
    }

    public CartorioDTO toDTO(CartorioEntity entity) {
        return CartorioDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .endereco(entity.getEndereco())
                .certidoes(entity.getCertidoes().stream()
                        .map(CertidaoEntity::getTipo)
                        .collect(Collectors.toList()))
                .build();
    }
}
