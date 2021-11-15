package com.misterjackpot.cartorio.mock;

import com.misterjackpot.cartorio.dto.CartorioDTO;
import com.misterjackpot.cartorio.infra.entity.CartorioEntity;
import com.misterjackpot.cartorio.infra.entity.CertidaoEntity;

import java.util.Collections;

public class CartorioMock {

    public static CartorioDTO buildCartorioDTO() {
        return CartorioDTO.builder()
                .id(1L)
                .nome("Teste")
                .endereco("Rua Teste")
                .certidoes(Collections.singletonList(1L))
                .build();
    }

    public static CartorioEntity buildCartorioEntity() {
        return CartorioEntity.builder()
                .id(1L)
                .nome("Teste")
                .endereco("Rua Teste")
                .certidoes(Collections.singletonList(CertidaoEntity.builder()
                        .tipo(1L)
                        .build()))
                .build();
    }
}
