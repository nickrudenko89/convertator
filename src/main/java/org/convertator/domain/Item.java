package org.convertator.domain;

public class Item extends Unit {
    private double result;
    public Item() {
    }

    public Item(String firstItem, String secondItem, int value) {
        super(firstItem, secondItem, value);
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double convert(Item item) {
        if(getFirstItem().equals("Miles") & getSecondItem().equals("Meters")){
            result = getValue() * 1612;
        }
        return result;
    }
}
