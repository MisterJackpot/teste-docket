package com.misterjackpot.cartorio.mock;

import com.misterjackpot.cartorio.dto.CertidaoDTO;

public class CertidaoMock {

    public static CertidaoDTO buildCertidaoDTO(){
        return CertidaoDTO.builder()
                .id(1L)
                .nome("2° Via de Certidão de Casamento")
                .build();
    }
}
