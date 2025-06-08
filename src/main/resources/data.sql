-- Limpando dados existentes
DELETE FROM itens_pedido;
DELETE FROM pedido;
DELETE FROM cliente;
DELETE FROM produto;

-- Inserindo produtos
INSERT INTO produto (nome, descricao, preco, tipo)
VALUES ('Pão Francês', 'Pão tradicional e crocante', 0.75, 'PAO');

INSERT INTO produto (nome, descricao, preco, tipo)
VALUES ('Pão de Forma', 'Pão macio para sanduíches', 8.90, 'PAO');

INSERT INTO produto (nome, descricao, preco, tipo)
VALUES ('Bolo de Chocolate', 'Bolo caseiro com cobertura de brigadeiro', 45.00, 'BOLO');

-- Inserindo clientes (agora com todos os campos obrigatórios)
INSERT INTO cliente (nome, telefone, endereco, email)
VALUES ('João Silva', '11999998888', 'Rua das Flores, 123', 'joao@email.com');

INSERT INTO cliente (nome, telefone, endereco, email)
VALUES ('Maria Santos', '11977776666', 'Av. Principal, 456', 'maria@email.com');

-- Inserindo pedidos em produção
INSERT INTO pedido (cliente_id, data_pedido, data_entrega, status, observacoes)
VALUES (1, CURRENT_TIMESTAMP, DATEADD('HOUR', 2, CURRENT_TIMESTAMP), 'EM_PRODUCAO', 'Pedido urgente');

INSERT INTO pedido (cliente_id, data_pedido, data_entrega, status, observacoes)
VALUES (2, CURRENT_TIMESTAMP, DATEADD('HOUR', 3, CURRENT_TIMESTAMP), 'EM_PRODUCAO', 'Cliente solicitou embalagem especial');

-- Inserindo itens dos pedidos
INSERT INTO itens_pedido (pedido_id, produto, quantidade, preco_unitario)
VALUES (1, 'Pão Francês', 20, 0.75);

INSERT INTO itens_pedido (pedido_id, produto, quantidade, preco_unitario)
VALUES (1, 'Bolo de Chocolate', 1, 45.00);

INSERT INTO itens_pedido (pedido_id, produto, quantidade, preco_unitario)
VALUES (2, 'Pão de Forma', 3, 8.90);