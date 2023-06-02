package com.edweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edweb.course.entities.User;

//<Tipo da entidade, tipo do id>
public interface UserRepository extends JpaRepository<User, Long> {

}
