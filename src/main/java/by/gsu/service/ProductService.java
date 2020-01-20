package by.gsu.service;

import by.gsu.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    void delete(Product product);

}
