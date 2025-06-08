package br.com.desanQuality.controller;

import br.com.desanQuality.dto.CriarPedidoDTO;
import br.com.desanQuality.models.Pedido;
import br.com.desanQuality.models.StatusPedido;
import br.com.desanQuality.service.GerenciadorPedidos;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final GerenciadorPedidos gerenciador;

    public PedidoController(GerenciadorPedidos gerenciador) {
        this.gerenciador = gerenciador;
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@Valid @RequestBody CriarPedidoDTO pedidoDTO) {
        try {
            Pedido novoPedido = gerenciador.criarPedido(pedidoDTO);
            return ResponseEntity.ok(novoPedido);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> atualizarStatus(
            @PathVariable Long id,
            @RequestBody StatusPedido status) {
        try {
            if (id == null || status == null) {
                return ResponseEntity.badRequest().build();
            }
            gerenciador.atualizarStatusPedido(id, status);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/em-producao")
    public ResponseEntity<List<Pedido>> listarPedidosEmProducao() {
        try {
            List<Pedido> pedidos = gerenciador.listarPedidosEmProducao();
            return ResponseEntity.ok(pedidos);
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}