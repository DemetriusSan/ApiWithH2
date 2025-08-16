package br.com.desanQuality.config.controller;

import br.com.desanQuality.controller.ClienteController;
import br.com.desanQuality.models.Cliente;
import br.com.desanQuality.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ClienteControllerTest {
    @Mock
    private ClienteService clienteService;

    @InjectMocks
    ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testarCadastrarClienteComSucesso() {
        Cliente cliente = new Cliente();

        when(clienteService.cadastrarCliente(any())).thenReturn(null);
        clienteController.cadastrarCliente(null);
        verify(clienteService, times(1)).cadastrarCliente(any());
        Mockito.verifyNoMoreInteractions(clienteService);

        when(clienteService.cadastrarCliente(any(Cliente.class))).thenReturn(cliente);

        ResponseEntity<Cliente> response = clienteController.cadastrarCliente(cliente);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(cliente, response.getBody());
        verify(clienteService, times(1)).cadastrarCliente(cliente);

    }
}
