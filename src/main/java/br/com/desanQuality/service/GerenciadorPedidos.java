package br.com.desanQuality.service;

import br.com.desanQuality.dto.CriarPedidoDTO;
import br.com.desanQuality.dto.ItemPedidoDTO;
import br.com.desanQuality.enums.TipoProduto;
import br.com.desanQuality.models.*;
import br.com.desanQuality.repositories.ClienteRepository;
import br.com.desanQuality.repositories.PedidoRepository;
import br.com.desanQuality.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GerenciadorPedidos {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public GerenciadorPedidos(PedidoRepository pedidoRepository,
                              ClienteRepository clienteRepository,
                              ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Pedido criarPedido(CriarPedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.findById(pedidoDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        List<ItemPedido> itens = pedidoDTO.getItens().stream()
                .map(this::criarItemPedido)
                .collect(Collectors.toList());

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setItens(itens);
        pedido.setObservacoes(pedidoDTO.getObservacoes());
        pedido.setStatus(StatusPedido.ENTREGUE);

        return pedidoRepository.save(pedido);
    }

    private ItemPedido criarItemPedido(ItemPedidoDTO itemDTO) {
        Produto produto = new Produto();
        produto.setNome(itemDTO.getProduto().getNome());
        produto.setPreco(itemDTO.getProduto().getPreco());
        produto.setTipo(TipoProduto.valueOf(itemDTO.getProduto().getTipo()));

        produto = produtoRepository.save(produto);

        ItemPedido item = new ItemPedido();
        item.setProduto(produto);
        item.setQuantidade(itemDTO.getQuantidade());
        return item;
    }

    @Transactional
    public void atualizarStatusPedido(Long id, StatusPedido novoStatus) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(novoStatus);
        pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidosEmProducao() {
        return pedidoRepository.findByStatus(StatusPedido.EM_PRODUCAO);
    }
}