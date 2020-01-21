package by.gsu.service;

import by.gsu.model.Calculation;
import by.gsu.model.Product;

public class CalculationServiceImpl implements CalculationService {

    @Override
    public Calculation calculate(Product product) {
        float recyclableAndWaste = product.getRawAndMaterials() * product.getRecyclableAndWaste() / 100;

        float additionalSalary;
        if (product.getSalary() > 200) {
            additionalSalary = 0.1f * product.getSalary();
        } else {
            additionalSalary = product.getSalary() * 0.15f;
        }

        float payroll = 0.3f * (product.getSalary() + additionalSalary);
        float equipmentMaintenance = 0.05f * product.getSalary();
        float generalRunningCosts = 0.09f * product.getSalary();
        float overheadCosts = 0.18f * (0.25f * product.getSalary() + 0.75f * additionalSalary);

        float productionCost = product.getRawAndMaterials()
                + product.getComponents()
                + product.getFuelAndEnergy()
                + product.getSalary()
                + additionalSalary
                + payroll
                + equipmentMaintenance
                + generalRunningCosts
                + overheadCosts
                - recyclableAndWaste;

        return new Calculation(
                equipmentMaintenance,
                generalRunningCosts,
                overheadCosts,
                productionCost,
                product.getProfit(),
                product.getVat());
    }

}