package com.programming.techie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.programming.techie.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
