package com.misterjackpot.cartorio.mock;

import com.misterjackpot.cartorio.dto.TipoCertidaoDTO;

public class CertidaoMock {

    public static TipoCertidaoDTO buildCertidaoDTO(){
        return TipoCertidaoDTO.builder()
                .id(1L)
                .nome("2° Via de Certidão de Casamento")
                .build();
    }
}
