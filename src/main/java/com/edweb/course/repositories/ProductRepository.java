package com.edweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edweb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
