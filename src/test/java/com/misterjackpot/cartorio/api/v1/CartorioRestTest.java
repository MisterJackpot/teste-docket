package com.misterjackpot.cartorio.api.v1;

import com.misterjackpot.cartorio.dto.CartorioDTO;
import com.misterjackpot.cartorio.service.CartorioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static com.misterjackpot.cartorio.mock.CartorioMock.buildCartorioDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartorioRestTest {

    @Mock
    CartorioService service;
    @InjectMocks
    CartorioRest rest;

    @Test
    public void deveListarCartorios() {
        dadoQueRetorneCartorios();

        ResponseEntity<List<CartorioDTO>> response = rest.buscar();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), Collections.singletonList(buildCartorioDTO()));
    }

    @Test
    public void deveBuscarCartorio() {
        dadoQueRetorneCartorio();

        ResponseEntity<CartorioDTO> response = rest.buscarPorId(1L);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), buildCartorioDTO());
    }

    @Test
    public void deveExcluirCartorio() {
        rest.excluir(1L);

        verify(service).excluirCartorio(1L);
    }

    @Test
    public void deveSalvarCartorio() {
        dadoQueRetorneCartorioAoSalvar();

        ResponseEntity<Void> response = rest.salvar(buildCartorioDTO());

        verify(service).salvarCartorio(buildCartorioDTO());
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getHeaders().get("Location"), Collections.singletonList("/cartorios/1"));
    }

    @Test
    public void deveAtualizarCartorio(){

        rest.atualizar(1L, buildCartorioDTO());

        verify(service).atualizarCartorio(1L, buildCartorioDTO());
    }

    private void dadoQueRetorneCartorios() {
        when(service.buscarCartorios())
                .thenReturn(Collections.singletonList(buildCartorioDTO()));
    }

    private void dadoQueRetorneCartorio() {
        when(service.buscarCartorio(1L))
                .thenReturn(buildCartorioDTO());
    }

    private void dadoQueRetorneCartorioAoSalvar() {
        when(service.salvarCartorio(buildCartorioDTO()))
                .thenReturn(buildCartorioDTO());
    }
}