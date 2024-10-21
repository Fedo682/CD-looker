package com.example.cd_show_subject;


public class CD {
    private String Name;
    private double Price;
    public CD(String name , double price){
        this.Name= name;
        this.Price=price;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
    @Override
    public String toString() {
        return Name+ "  -->"+ this.getPrice()+" $";
    }
}
