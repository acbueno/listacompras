package br.com.acbueno.shoppinglist.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.acbueno.shoppinglist.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
  
  List<Product> findByName(String name);

}
