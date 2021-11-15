package com.misterjackpot.cartorio.infra.repository;

import com.misterjackpot.cartorio.infra.client.CertidaoClient;
import com.misterjackpot.cartorio.dto.CertidaoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CertidaoRepository {

    private final CertidaoClient client;

    public List<CertidaoDTO> buscarCertidoes(){
        return client.buscarCertidoes();
    }
}
