package br.com.acbueno.shoppinglist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

  @Id
  private String id;

  private String name;

  private int amount;
  
  private String typeGrammage;


  public Product() {

  }

  public Product(String name, int amount, String typeGrammage) {
    this.name = name;
    this.amount = amount;
    this.typeGrammage = typeGrammage;
  }
  
  

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
  
  

  public String getTypeGrammage() {
    return typeGrammage;
  }

  public void setTypeGrammage(String typeGrammage) {
    this.typeGrammage = typeGrammage;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", amount=" + amount + ", typeGrammage="
        + typeGrammage + "]";
  }


}
