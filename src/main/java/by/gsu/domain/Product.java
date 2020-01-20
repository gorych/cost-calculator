package by.gsu.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jooq.Record;

import static by.gsu.jooq.tables.Product.PRODUCT;

@Data
@NoArgsConstructor
public class Product {

    private Integer id;
    private String name;
    private Float vat;
    private Float profit;
    private Float salary;
    private Float fuelAndEnergy;
    private Float recyclableAndWaste;
    private Float components;
    private Float rawAndMaterials;

    public Product(Record record) {
        this.id = record.get(PRODUCT.ID);
        this.name = record.get(PRODUCT.NAME);
        this.vat = record.get(PRODUCT.VAT);
        this.profit = record.get(PRODUCT.PROFIT);
        this.salary = record.get(PRODUCT.SALARY);
        this.fuelAndEnergy = record.get(PRODUCT.FUELANDENERGY);
        this.recyclableAndWaste = record.get(PRODUCT.RECYCLABLEWASTE);
        this.components = record.get(PRODUCT.COMPONENTS);
        this.rawAndMaterials = record.get(PRODUCT.RAWANDMATERIALS);
    }

}
