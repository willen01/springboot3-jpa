package com.edweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edweb.course.entities.Order;
import com.edweb.course.entities.User;
import com.edweb.course.repositories.OrderRepository;
import com.edweb.course.repositories.UserRepository;

// Camada auxiliar
@Configuration // Define que a classe é de configuração
@Profile("test") // aponta para o perfil de teste (definido em application.properties)
public class TestConfig implements CommandLineRunner { // seed

    @Autowired // Associa uma instância de userRepository
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9123456", "123");
        User u2 = new User(null, "Alex Geen", "alex@gmail.com", "92345678x", "123");

        Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2023-06-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2023-06-22T15:21:22Z"), u1);

        // Salva no banco
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}