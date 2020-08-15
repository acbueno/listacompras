package br.com.acbueno.shoppinglist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import br.com.acbueno.shoppinglist.exception.RecordNotFoundException;
import br.com.acbueno.shoppinglist.model.Product;
import br.com.acbueno.shoppinglist.repository.ProductRepository;

@Service
public class ProductService {


  @Autowired
  ProductRepository productRepository;

  public List<Product> getAllProducts() {

    List<Product> result = productRepository.findAll();

    if (result.size() > 0) {
      return result;
    } else {
      return new ArrayList<Product>();
    }
  }


  public Product getProductById(String id) throws RecordNotFoundException {

    Optional<Product> product = productRepository.findById(id);

    if (product.isPresent()) {
      return product.get();
    } else {
      throw new RecordNotFoundException("No Product record exist for given id");
    }
  }

  public Product createOrUpdateProduct(Product entity) {

    if (entity.getId() == null) {
      entity = productRepository.save(entity);

      return entity;
    } else {

      Optional<Product> product = productRepository.findById(entity.getId());

      if (product.isPresent()) {

        Product newProduct = product.get();
        newProduct.setName(entity.getName());
        newProduct.setAmount(entity.getAmount());
        newProduct.setTypeGrammage(entity.getTypeGrammage());
        
        newProduct = productRepository.save(newProduct);

        return newProduct;
      } else {
        entity = productRepository.save(entity);

        return entity;
      }
    }
  }


  public void deleteProductById(String id) throws RecordNotFoundException {

    Optional<Product> products = productRepository.findById(id);

    if (products.isPresent()) {
      productRepository.deleteById(id);;
    } else {
      throw new RecordNotFoundException("No product record exit for given");
    }
  }
  
}
