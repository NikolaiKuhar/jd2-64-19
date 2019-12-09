package by.it.academy.comics.service;

import by.it.academy.comics.model.Product;

import java.util.List;

public interface ProductService  {
    List<Product> getAllProducts();

    void addNewProduct(Product product);
    void deleteProduct(Long id);
}
