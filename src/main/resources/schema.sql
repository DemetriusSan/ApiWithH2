-- Tabela de Produtos
CREATE TABLE IF NOT EXISTS produto (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    tipo VARCHAR(50) NOT NULL
    );

-- Tabela de Clientes
CREATE TABLE IF NOT EXISTS cliente (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
    );

-- Tabela de Pedidos
CREATE TABLE IF NOT EXISTS pedido (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      cliente_id BIGINT NOT NULL,
                                      data_pedido TIMESTAMP NOT NULL,
                                      data_entrega TIMESTAMP,
                                      status VARCHAR(50) NOT NULL,
    observacoes TEXT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
    );

-- Tabela de Itens do Pedido
CREATE TABLE IF NOT EXISTS itens_pedido (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            pedido_id BIGINT NOT NULL,
                                            produto VARCHAR(255) NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
    );