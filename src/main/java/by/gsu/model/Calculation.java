package by.gsu.model;

import lombok.Data;

@Data
public class Calculation {

    private float equipmentMaintenance;
    private float generalRunningCosts;
    private float overheadCosts;
    private float productionCost;
    private float expenses;
    private float totalCost;
    private float profit;
    private float wholeSale;
    private float vat;
    private float finalCost;

    public Calculation(float equipmentMaintenance, float generalRunningCosts, float overheadCosts, float productionCost, float profit, float vat) {
        this.equipmentMaintenance = equipmentMaintenance;
        this.generalRunningCosts = generalRunningCosts;
        this.overheadCosts = overheadCosts;
        this.productionCost = productionCost;
        this.expenses = 0.03f * productionCost;
        this.totalCost = productionCost + expenses;
        this.profit = totalCost * profit / 100;
        this.wholeSale = totalCost + this.profit;
        this.vat = this.wholeSale  * vat / 100;
        this.finalCost = this.wholeSale  + this.vat;
    }

    @Override
    public String toString() {
        return "Результаты рассчета:\n" +
                "Содержание оборудования = " + equipmentMaintenance + " т. руб\n" +
                "Общехозяйственные расходы = " + generalRunningCosts + " т. руб\n" +
                "Общепроизводственные расходы = " + overheadCosts + " т. руб\n" +
                "Производственная себестоимость = " + productionCost + " т. руб\n" +
                "Издержки производства = " + expenses + " т. руб\n" +
                "Полная себестоимость = " + totalCost + " т. руб\n" +
                "Прибыль производителя = " + profit + " т. руб\n" +
                "Оптовая цена производителя = " + wholeSale + " т. руб\n" +
                "НДС = " + vat + " т. руб\n\n" +
                "ИТОГОВАЯ СТОИМОСТЬ = " + finalCost + " т. руб\n\n";
    }
}
