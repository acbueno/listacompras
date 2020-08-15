package br.com.acbueno.shoppinglist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.acbueno.shoppinglist.exception.RecordNotFoundException;
import br.com.acbueno.shoppinglist.model.Product;
import br.com.acbueno.shoppinglist.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {

  @Autowired
  ProductService productService;


  @RequestMapping
  public String getAllProduct(Model model) {

    List<Product> list = productService.getAllProducts();

    model.addAttribute("products", list);

    return "list-products";

  }

  @RequestMapping(path = {"/edit", "/edit/{id}"})
  public String editProductById(Model model, @PathVariable("id") Optional<String> id)
      throws RecordNotFoundException {

    if (id.isPresent()) {
      Product entity = productService.getProductById(id.get());
      model.addAttribute("product", entity);
    } else {
      model.addAttribute("product", new Product());
    }

    return "add-edit-product";

  }
  
  @RequestMapping(path = "/delete/{id}")
  public String deleteProductById(Model model, @PathVariable("id") String id)
      throws RecordNotFoundException {
    productService.deleteProductById(id);

    return "redirect:/";
  }
  
  @RequestMapping(path = "/createProduct", method = RequestMethod.POST)
  public String createOrUpdateProduct(Product product) {
    productService.createOrUpdateProduct(product);

    return "redirect:/";
  }

}
