# Sistema de Gerenciamento de Padaria 🥖

## Sobre o Projeto

Sistema desenvolvido para gerenciamento de pedidos de uma padaria, permitindo o controle de produtos, clientes e pedidos. O projeto foi desenvolvido utilizando tecnologias modernas do ecossistema Java.

## Tecnologias Utilizadas

- Java 17
- Jakarta EE
- Spring MVC
- Spring Data JPA
- Lombok
- H2 Database (banco de dados em memória)

## Funcionalidades

- Cadastro e gerenciamento de produtos (pães, bolos, etc.)
- Cadastro e gerenciamento de clientes
- Controle de pedidos
- Acompanhamento do status dos pedidos
- Registro de itens por pedido

## Estrutura do Banco de Dados

O sistema utiliza as seguintes tabelas principais:

### Produto
- Nome
- Descrição
- Preço
- Tipo (PAO, BOLO)

### Cliente
- Nome
- Telefone
- Endereço
- Email

### Pedido
- Cliente
- Data do Pedido
- Data de Entrega
- Status
- Observações

### Itens do Pedido
- Pedido
- Produto
- Quantidade
- Preço Unitário

## Como Executar o Projeto

1. Certifique-se de ter instalado:
    - Java JDK 17
    - Maven

2. Clone o repositório: