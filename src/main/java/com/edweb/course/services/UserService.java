package com.edweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edweb.course.entities.User;
import com.edweb.course.repositories.UserRepository;

// Camadas de regras de negócio
@Service // registra classe como componente spring para poder ser injetado pelo autowied.
         // Poderia ser @Component também
public class UserService {

    @Autowired // inje. dependência
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get(); // Retorna objeto user que está dentro do optional
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
