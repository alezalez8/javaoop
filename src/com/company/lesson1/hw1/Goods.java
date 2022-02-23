package com.company.javaoop.lesson1.hw1;

public class Goods {
    private String nameGoods;
    private String description;
    private float weight;
    private float price;
    private int countOnStore;
    private boolean isDateExpiration;

    public Goods(String nameGoods, float weight, float price, int countOnStore) {
        this.nameGoods = nameGoods;
        this.weight = weight;
        this.price = price;
        this.countOnStore = countOnStore;
        this.description = "no description";
        this.isDateExpiration = true;
    }

    public Goods(String nameGoods, float weight, float price, int countOnStore, String description, boolean isDateExpiration) {
        this.nameGoods = nameGoods;
        this.weight = weight;
        this.price = price;
        this.countOnStore = countOnStore;
        this.description = description;
        this.isDateExpiration = isDateExpiration;
    }

    public String getNameGoods() {
        return nameGoods;
    }

    public void setNameGoods(String nameGoods) {
        this.nameGoods = nameGoods;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCountOnStore() {
        return countOnStore;
    }

    public void setCountOnStore(int countOnStore) {
        this.countOnStore = countOnStore;
    }

    public boolean isDateExpiration() {
        return isDateExpiration;
    }

    public void setDateExpiration(boolean dateExpiration) {
        isDateExpiration = dateExpiration;
    }

    @Override
    public String toString() {
        return "MyMarket{" +
                "наименование товара = " + nameGoods +
                ", описание: " + description +
                ", вес = " + weight + " гр" +
                ", цена за единицу =" + price + " грв," + System.lineSeparator() +
                "количество на складе: " + countOnStore + " шт" +
                ", годен к использованию " + isDateExpiration +
                '}';
    }
}

class MarketStarter {
    public static void main(String[] args) {
        Goods goods = new Goods("сметана", 350, 27.5f, 150, "\"Селяньске\"", true);
        Goods goods1 = new Goods("колбаса", 980, 195.5f, 200, "\"Любительская\"", true);
        Goods goods2 = new Goods("порошок для стирки \"Лотос\" ", 950f, 180, 50);

        System.out.println(goods);
        System.out.println(goods1);
        System.out.println(goods2);
    }
}

/*
* output:
*  MyMarket{наименование товара = сметана, описание: "Селяньске", вес = 350.0 гр, цена за единицу =27.5 грв,
    количество на складе: 150 шт, годен к использованию true}
    MyMarket{наименование товара = колбаса, описание: "Любительская", вес = 980.0 гр, цена за единицу =195.5 грв,
    количество на складе: 200 шт, годен к использованию true}
    MyMarket{наименование товара = порошок для стирки "Лотос" , описание: no description, вес = 950.0 гр, цена за единицу =180.0 грв,
    количество на складе: 50 шт, годен к использованию true}
*
* */
