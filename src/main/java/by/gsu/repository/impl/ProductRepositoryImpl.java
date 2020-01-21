package by.gsu.repository.impl;

import by.gsu.jooq.tables.records.ProductRecord;
import by.gsu.model.Product;
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
        return Optional.of(new Product(DSL.using(ConnectionHolder.getConnection()).fetchOne(PRODUCT, PRODUCT.ID.eq(id))));
    }

    @Override
    public Product save(Product product) {
        ProductRecord productRecord = DSL.using(ConnectionHolder.getConnection()).newRecord(PRODUCT);
        return saveOrUpdate(product, productRecord);
    }

    @Override
    public void update(Product product) {
        ProductRecord productRecord = DSL.using(ConnectionHolder.getConnection()).fetchOne(PRODUCT, PRODUCT.ID.eq(product.getId()));
        saveOrUpdate(product, productRecord);
    }

    @Override
    public void delete(Product product) {
        DSL.using(ConnectionHolder.getConnection())
                .delete(PRODUCT)
                .where(PRODUCT.ID.eq(product.getId()))
                .execute();
    }

    @Override
    public void delete(List<Product> products) {
        products.forEach(this::delete);
    }

    private Product saveOrUpdate(Product product, ProductRecord productRecord) {
        productRecord.setName(product.getName());
        productRecord.setVat(product.getVat());
        productRecord.setProfit(product.getProfit());
        productRecord.setSalary(product.getSalary());
        productRecord.setFuelandenergy(product.getFuelAndEnergy());
        productRecord.setRecyclablewaste(product.getRecyclableAndWaste());
        productRecord.setComponents(product.getComponents());
        productRecord.setRawandmaterials(product.getRawAndMaterials());
        productRecord.store();
        return new Product(productRecord);
    }
}
