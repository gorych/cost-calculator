package by.gsu.repository.impl;

import by.gsu.jooq.tables.Product;
import by.gsu.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Product add(Product entity) {
        return null;
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public void delete(List<Product> entities) {

    }
}
