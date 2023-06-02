package com.edweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edweb.course.entities.User;

//<Tipo da entidade, tipo do id>
// Poderia ser inserido @Repository (component) para poder ser utilizado o autowired, no entando não é necessário pois já estamos estentendo de JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {

}
