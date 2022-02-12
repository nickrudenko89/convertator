package org.convertator.domain;

public abstract class Unit {
    private String firstItem;
    private String secondItem;
    private double value;

    public Unit() {
    }

    public Unit(String firstItem, String secondItem, double value) {
        this.firstItem = firstItem;
        this.value = value;
        this.secondItem = secondItem;
    }

    public String getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(String firstItem) {
        this.firstItem = firstItem;
    }

    public String getSecondItem() {
        return secondItem;
    }

    public void setSecondItem(String secondItem) {
        this.secondItem = secondItem;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
