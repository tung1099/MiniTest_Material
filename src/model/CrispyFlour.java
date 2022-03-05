package model;

import java.time.LocalDate;

public class CrispyFlour extends Material{
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost) {
        super(id, name, manufacturingDate, cost);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  "CrispyFlour{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufaturingDate=" + getManufacturingDate() +
                ", cost=" + getCost() +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public double getRealMoney() {
        LocalDate today = LocalDate.now();
        if (today.isBefore(getExpiryDate())&&
                (today.isAfter(getExpiryDate().minusMonths(2)))){

            return getCost()*0.6;
        }
        else if(today.isBefore(getExpiryDate().minusMonths(2)) &&
                (today.isAfter(getExpiryDate().minusMonths(4)))){

            return getCost()*0.8;
        }
        else if(today.isBefore(getExpiryDate().minusMonths(4))&&
                (today.isAfter(getManufacturingDate()))){

            return getCost()*0.95;
        }
        else {
            return -1;
        }


    }

    @Override
    public double getAmount() {
        return getCost() * quantity;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }
}
