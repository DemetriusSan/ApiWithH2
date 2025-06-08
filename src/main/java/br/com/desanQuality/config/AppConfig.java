//
//package br.com.desanQuality.config;
//
//import br.com.desanQuality.service.GerenciadorPedidos;
//import br.com.desanQuality.repositories.PedidoRepository;
//import br.com.desanQuality.repositories.ClienteRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public GerenciadorPedidos gerenciadorPedidos(PedidoRepository pedidoRepository,
//                                                 ClienteRepository clienteRepository) {
//        return new GerenciadorPedidos(pedidoRepository, clienteRepository);
//    }
//}