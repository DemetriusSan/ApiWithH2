package br.com.desanQuality.service;

import br.com.desanQuality.enums.StatusPedido;
import br.com.desanQuality.models.Pedido;
import br.com.desanQuality.repositories.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> buscarPedidosEmProducao() {
        return pedidoRepository.findByStatus(StatusPedido.valueOf(String.valueOf(StatusPedido.EM_PRODUCAO)));
    }
}