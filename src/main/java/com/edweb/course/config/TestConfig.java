package com.edweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edweb.course.entities.User;
import com.edweb.course.repositories.UserRepository;

@Configuration // Define que a classe é de configuração
@Profile("test") // aponta para o perfil de teste (definido em application.properties)
public class TestConfig implements CommandLineRunner { // seed

    @Autowired // Associa uma instância de userRepository
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9123456", "123");
        User u2 = new User(null, "Alex Geen", "alex@gmail.com", "92345678x", "123");

        // Salva no banco
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
