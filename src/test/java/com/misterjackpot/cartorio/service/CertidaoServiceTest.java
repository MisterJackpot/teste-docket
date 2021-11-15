package com.misterjackpot.cartorio.service;

import com.misterjackpot.cartorio.dto.CertidaoDTO;
import com.misterjackpot.cartorio.infra.repository.CertidaoRepository;
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
class CertidaoServiceTest {

    @Mock
    CertidaoRepository repository;
    @InjectMocks
    CertidaoService service;

    @Test
    public void deveRetornarTipoCertidao() {
        dadoQueRetorneTipoCertidoes();

        List<CertidaoDTO> certidoes = service.buscarTiposCertidao();

        assertEquals(certidoes, Collections.singletonList(buildCertidaoDTO()));
    }

    private void dadoQueRetorneTipoCertidoes() {
        when(repository.buscarCertidoes())
                .thenReturn(Collections.singletonList(buildCertidaoDTO()));
    }
}