package by.gsu.service;

import by.gsu.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    void delete(Product product);

    Product add(Product product);

}
