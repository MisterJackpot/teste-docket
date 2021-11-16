package com.misterjackpot.cartorio.infra.repository;

import com.misterjackpot.cartorio.config.exception.InfrastructureException;
import com.misterjackpot.cartorio.infra.client.CertidaoClient;
import com.misterjackpot.cartorio.dto.TipoCertidaoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CertidaoRepository {

    private final CertidaoClient client;

    public List<TipoCertidaoDTO> buscarCertidoes(){
        try {
            return client.buscarCertidoes();
        }catch (Exception e){
            throw new InfrastructureException("Erro ao buscar tipos de certidão disponíveis");
        }
    }
}
