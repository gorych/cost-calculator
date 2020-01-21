package by.gsu.model;

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

    public static class Builder {

        private int id;
        private String name;
        private Float vat;
        private Float profit;
        private Float salary;
        private Float fuelAndEnergy;
        private Float recyclableAndWaste;
        private Float components;
        private Float rawAndMaterials;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setVat(Float vat) {
            this.vat = vat;
            return this;
        }

        public Builder setProfit(Float profit) {
            this.profit = profit;
            return this;
        }

        public Builder setSalary(Float salary) {
            this.salary = salary;
            return this;
        }

        public Builder setFuelAndEnergy(Float fuelAndEnergy) {
            this.fuelAndEnergy = fuelAndEnergy;
            return this;
        }

        public Builder setRecyclableAndWaste(Float recyclableAndWaste) {
            this.recyclableAndWaste = recyclableAndWaste;
            return this;
        }

        public Builder setComponents(Float components) {
            this.components = components;
            return this;
        }

        public Builder setRawAndMaterials(Float rawAndMaterials) {
            this.rawAndMaterials = rawAndMaterials;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setId(id);
            product.setName(name);
            product.setVat(vat);
            product.setProfit(profit);
            product.setSalary(salary);
            product.setFuelAndEnergy(fuelAndEnergy);
            product.setComponents(components);
            product.setRecyclableAndWaste(recyclableAndWaste);
            product.setRawAndMaterials(rawAndMaterials);
            return product;
        }
    }

}
