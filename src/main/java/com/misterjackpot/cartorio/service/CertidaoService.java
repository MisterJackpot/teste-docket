package com.misterjackpot.cartorio.service;

import com.misterjackpot.cartorio.infra.client.CertidaoDTO;
import com.misterjackpot.cartorio.infra.repository.CertidaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CertidaoService {

    private CertidaoRepository repository;

    public List<CertidaoDTO> buscarTiposCertidao(){
        return repository.buscarCertidoes();
    }
}
