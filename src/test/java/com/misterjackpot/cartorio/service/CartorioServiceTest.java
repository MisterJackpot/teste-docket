package com.misterjackpot.cartorio.service;

import com.misterjackpot.cartorio.config.exception.ResourceNotFoundException;
import com.misterjackpot.cartorio.converter.CartorioConverter;
import com.misterjackpot.cartorio.dto.CartorioDTO;
import com.misterjackpot.cartorio.infra.repository.CartorioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.misterjackpot.cartorio.mock.CartorioMock.buildCartorioDTO;
import static com.misterjackpot.cartorio.mock.CartorioMock.buildCartorioEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartorioServiceTest {

    @Mock
    CartorioRepository repository;
    @Spy
    CartorioConverter converter;
    @InjectMocks
    CartorioService service;


    @Test
    public void deveRetornarCartorios() {
        dadoQueRetorneCartorios();

        List<CartorioDTO> cartorios = service.buscarCartorios();

        assertEquals(cartorios, Collections.singletonList(buildCartorioDTO()));
    }

    @Test
    public void deveRetornarCartoriosVazio() {

        List<CartorioDTO> cartorios = service.buscarCartorios();

        assertEquals(cartorios, Collections.emptyList());
    }

    @Test
    public void deveRetornarCartorioPorId() {
        dadoQueExistaCartorio();
        dadoQueRetorneCartorio();

        CartorioDTO cartorio = service.buscarCartorio(1L);

        assertEquals(cartorio, buildCartorioDTO());
    }

    @Test
    public void deveRetornarErroAoBuscarCartorioPorId() {
        dadoQueNaoExistaCartorio();

        assertThrows(ResourceNotFoundException.class, () -> {
            service.buscarCartorio(1L);
        }, "Cartório 1 não foi encontrado");
    }

    @Test
    public void deveExcluirCartorio() {
        dadoQueExistaCartorio();

        service.excluirCartorio(1L);

        verify(repository).deleteById(1L);
    }

    @Test
    public void deveRetornarErroAoExcluirCartorioPorId() {
        dadoQueNaoExistaCartorio();

        assertThrows(ResourceNotFoundException.class, () -> {
            service.excluirCartorio(1L);
        }, "Cartório 1 não foi encontrado");
    }

    @Test
    public void deveSalvarCartorio() {
        dadoQueRetorneCartorioSalvo();

        service.salvarCartorio(buildCartorioDTO());

        verify(repository).save(buildCartorioEntity());
    }

    @Test
    public void deveAtualizarCartorio() {
        dadoQueExistaCartorio();

        service.atualizarCartorio(1L, buildCartorioDTO());

        verify(repository).save(buildCartorioEntity());
    }

    @Test
    public void deveRetornarErroAoAtualizarCartorio() {
        dadoQueNaoExistaCartorio();

        assertThrows(ResourceNotFoundException.class, () -> {
            service.atualizarCartorio(1L, buildCartorioDTO());
        }, "Cartório 1 não foi encontrado");
    }

    private void dadoQueRetorneCartorios() {
        when(repository.findAll())
                .thenReturn(Collections.singletonList(buildCartorioEntity()));
    }

    private void dadoQueRetorneCartorio() {
        when(repository.getById(1L))
                .thenReturn(buildCartorioEntity());
    }

    private void dadoQueExistaCartorio() {
        when(repository.existsById(1L))
                .thenReturn(Boolean.TRUE);
    }

    private void dadoQueNaoExistaCartorio() {
        when(repository.existsById(1L))
                .thenReturn(Boolean.FALSE);
    }

    private void dadoQueRetorneCartorioSalvo() {
        when(repository.save(buildCartorioEntity()))
                .thenReturn(buildCartorioEntity());
    }

}