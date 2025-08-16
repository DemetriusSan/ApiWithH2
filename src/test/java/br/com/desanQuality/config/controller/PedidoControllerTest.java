package br.com.desanQuality.config.controller;

import br.com.desanQuality.controller.PedidoController;
import br.com.desanQuality.dto.CriarPedidoDTO;
import br.com.desanQuality.models.Pedido;
import br.com.desanQuality.models.StatusPedido;
import br.com.desanQuality.service.GerenciadorPedidos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PedidoControllerTest {

    @Mock
    private GerenciadorPedidos gerenciador;

    @InjectMocks
    private PedidoController pedidoController;

    @Test
    void testCriarPedido_Sucesso() {
        CriarPedidoDTO dto = new CriarPedidoDTO();
        Pedido pedido = new Pedido();
        when(gerenciador.criarPedido(dto)).thenReturn(pedido);

        ResponseEntity<Pedido> response = pedidoController.criarPedido(dto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pedido, response.getBody());
    }

    @Test
    void testCriarPedido_RuntimeException() {
        CriarPedidoDTO dto = new CriarPedidoDTO();
        when(gerenciador.criarPedido(dto)).thenThrow(new RuntimeException());

        ResponseEntity<Pedido> response = pedidoController.criarPedido(dto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testAtualizarStatus_Sucesso() {
        Long id = 1L;
        StatusPedido status = StatusPedido.EM_PRODUCAO;

        ResponseEntity<Void> response = pedidoController.atualizarStatus(id, status);

        verify(gerenciador).atualizarStatusPedido(id, status);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testAtualizarStatus_IdNulo() {
        StatusPedido status = StatusPedido.EM_PRODUCAO;

        ResponseEntity<Void> response = pedidoController.atualizarStatus(null, status);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
        verifyNoInteractions(gerenciador);
    }

    @Test
    void testAtualizarStatus_StatusNulo() {
        Long id = 1L;

        ResponseEntity<Void> response = pedidoController.atualizarStatus(id, null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
        verifyNoInteractions(gerenciador);
    }

    @Test
    void testAtualizarStatus_RuntimeException() {
        Long id = 1L;
        StatusPedido status = StatusPedido.EM_PRODUCAO;

        doThrow(new RuntimeException()).when(gerenciador).atualizarStatusPedido(id, status);

        ResponseEntity<Void> response = pedidoController.atualizarStatus(id, status);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testListarPedidosEmProducao_Sucesso() {
        Pedido pedido = new Pedido();
        List<Pedido> pedidos = Collections.singletonList(pedido);
        when(gerenciador.listarPedidosEmProducao()).thenReturn(pedidos);

        ResponseEntity<List<Pedido>> response = pedidoController.listarPedidosEmProducao();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pedidos, response.getBody());
    }

    @Test
    void testListarPedidosEmProducao_RuntimeException() {
        when(gerenciador.listarPedidosEmProducao()).thenThrow(new RuntimeException());

        ResponseEntity<List<Pedido>> response = pedidoController.listarPedidosEmProducao();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNull(response.getBody());
    }
}