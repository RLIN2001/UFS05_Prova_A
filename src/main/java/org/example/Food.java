package org.example;

public class Food implements Comparable<Food>{
    String descrizione;
    int id;
    String name;
    Double price;

    public Food(String descrizione,int id,
                   String name,
                   Double price) {
        this.descrizione =descrizione;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int compareTo(Food food) {
        return this.name.compareTo(food.name);
    }

}
