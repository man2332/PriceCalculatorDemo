package com.example.john.pricecalculatordemo;

import java.util.Comparator;

enum Unit{
    g, kg, oz, lb, ml, l, fluidOz, gal, invalidUnit
}
class ItemComparator implements Comparator<Item>{
    @Override
    public int compare(Item o1, Item o2) {
        int compare;
        if(o1.getUnitValuePerGram() < o2.getUnitValuePerGram()){
            compare = -1;
        }else if(o1.getUnitValuePerGram() > o2.getUnitValuePerGram()){
            compare = 1;
        }else{
            compare = 0;
        }
        return compare;
    }
}
public class Item {
    private String name;
    private double price;
    private int quantity;
    private Unit itemUnit;

    public Item(String name, double price, int quantity, Unit itemUnit) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.itemUnit = itemUnit;
    }

    public double getUnitValuePerGram(){
        //converts all to smallest measurment
        Double gramValue = -1.0;
        switch (itemUnit){
            case g:
                gramValue = (double)quantity;
                break;
            case kg:
                gramValue = (double)quantity * 1000;
                break;
            case oz:
                gramValue = (double)quantity * 28.3495;
                break;
            case lb:
                gramValue = (double)quantity * 453.592;
                break;
            default:
                break;
        }
        Double unitValue = price / gramValue;
        return  unitValue;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Unit getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(Unit itemUnit) {
        this.itemUnit = itemUnit;
    }
}
