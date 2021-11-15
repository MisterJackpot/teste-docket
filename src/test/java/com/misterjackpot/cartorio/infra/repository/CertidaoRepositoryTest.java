package com.misterjackpot.cartorio.infra.repository;

import com.misterjackpot.cartorio.dto.CertidaoDTO;
import com.misterjackpot.cartorio.infra.client.CertidaoClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.misterjackpot.cartorio.mock.CertidaoMock.buildCertidaoDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CertidaoRepositoryTest {

    @Mock
    CertidaoClient client;
    @InjectMocks
    CertidaoRepository repository;

    @Test
    public void deveRetornarTiposCertidao(){
        dadoQueRetorneCertidoes();

        List<CertidaoDTO> certidoes = repository.buscarCertidoes();

        assertEquals(certidoes, Collections.singletonList(buildCertidaoDTO()));
    }

    private void dadoQueRetorneCertidoes(){
        when(client.buscarCertidoes())
        .thenReturn(Collections.singletonList(buildCertidaoDTO()));
    }

}