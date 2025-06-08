
package br.com.desanQuality.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CriarPedidoDTO {
    @NotNull(message = "ID do cliente é obrigatório")
    private Long clienteId;

    @NotNull(message = "A lista de itens não pode ser nula")
    @Size(min = 1, message = "O pedido deve ter pelo menos um item")
    private List<ItemPedidoDTO> itens;

    private String observacoes;
}