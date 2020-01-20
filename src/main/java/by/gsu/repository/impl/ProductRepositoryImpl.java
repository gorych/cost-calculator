package by.gsu.repository.impl;

import by.gsu.domain.Product;
import by.gsu.repository.ConnectionHolder;
import by.gsu.repository.ProductRepository;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.Optional;

import static by.gsu.jooq.Tables.PRODUCT;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return DSL.using(ConnectionHolder.getConnection())
                .select()
                .from(PRODUCT)
                .fetch()
                .map(Product::new);
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
