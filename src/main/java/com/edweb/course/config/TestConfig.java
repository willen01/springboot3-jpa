package com.edweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edweb.course.entities.Category;
import com.edweb.course.entities.Order;
import com.edweb.course.entities.Product;
import com.edweb.course.entities.User;
import com.edweb.course.entities.enums.OrderStatus;
import com.edweb.course.repositories.CategoryRepository;
import com.edweb.course.repositories.OrderRepository;
import com.edweb.course.repositories.ProductRepository;
import com.edweb.course.repositories.UserRepository;

// Camada auxiliar
@Configuration // Define que a classe é de configuração
@Profile("test") // aponta para o perfil de teste (definido em application.properties)
public class TestConfig implements CommandLineRunner { // seed

    @Autowired // Associa uma instância de userRepository
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9123456", "123");
        User u2 = new User(null, "Alex Geen", "alex@gmail.com", "92345678x", "123");

        Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2023-06-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2023-06-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        // Salva no banco
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
