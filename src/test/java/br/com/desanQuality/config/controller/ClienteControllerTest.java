package br.com.desanQuality.config.controller;

import br.com.desanQuality.controller.ClienteController;
import br.com.desanQuality.models.Cliente;
import br.com.desanQuality.service.ClienteService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    void testCadastrarCliente_Sucesso() {
        Cliente cliente = new Cliente(); // configure os dados conforme necessário
        Cliente clienteRetornado = new Cliente(); // objeto simulado retornado
        when(clienteService.cadastrarCliente(cliente)).thenReturn(clienteRetornado);

        ResponseEntity<Cliente> response = clienteController.cadastrarCliente(cliente);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clienteRetornado, response.getBody());
    }

    @Test
    void testCadastrarCliente_IllegalArgumentException() {
        Cliente cliente = new Cliente();
        when(clienteService.cadastrarCliente(cliente)).thenThrow(new IllegalArgumentException());

        ResponseEntity<Cliente> response = clienteController.cadastrarCliente(cliente);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testCadastrarCliente_ExceptionGenerica() {
        Cliente cliente = new Cliente();
        when(clienteService.cadastrarCliente(cliente)).thenThrow(new RuntimeException());

        ResponseEntity<Cliente> response = clienteController.cadastrarCliente(cliente);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testBuscarClientePorId_Sucesso() {
        Cliente cliente = new Cliente();
        when(clienteService.buscarClientePorId(1L)).thenReturn(cliente);
        ResponseEntity<Cliente> response = clienteController.buscarCliente(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
        verify(clienteService, times(1)).buscarClientePorId(1L);
    }

    @Test
    void testBuscarClientePorId_RuntimeException() {
        when(clienteService.buscarClientePorId(1L)).thenThrow(new RuntimeException());
        ResponseEntity<Cliente> response = clienteController.buscarCliente(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

}