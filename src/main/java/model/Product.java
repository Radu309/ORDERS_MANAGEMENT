package model;

public class Product {
    private int ID;
    private String name;
    private int number;
    private float price;

    public Product(int ID, String name, int number, float price) {
        this.ID = ID;
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public float getPrice() {return price;}
    public void setPrice(float price) {this.price = price;}
    public int getNumber() {return number;}
    public void setNumber(int numberProducts) {this.number = numberProducts;}
}
