package com.misterjackpot.cartorio.infra.client;

import com.misterjackpot.cartorio.dto.TipoCertidaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "certidoes-api", url = "https://docketdesafiobackend.herokuapp.com/api/v1/certidoes")
public interface CertidaoClient {

    @GetMapping
    List<TipoCertidaoDTO> buscarCertidoes();
}
