package model;

import java.time.LocalDate;

public class Meat extends Material{
    private double weight;

    public Meat() {
    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost) {
        super(id, name, manufacturingDate, cost);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getRealMoney() {
        LocalDate today = LocalDate.now();
        double realMoney = 0;
        if (today.isBefore(getExpiryDate()) &&
                (today.isAfter(getExpiryDate().minusDays(5)))){
            return  getCost() * 0.7;

        } else if (today.isBefore(getExpiryDate().minusDays(5)) &&
                today.isAfter(getManufacturingDate())){
             return getCost() * 0.9;

        } else {
            return -1;
        }
    }

    @Override
    public double getAmount() {
        return getCost() * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public String toString() {
        return  "Meat{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufaturingDate=" + getManufacturingDate() +
                ", cost=" + getCost() +
                ", weight=" + weight +
                '}';
    }
}
