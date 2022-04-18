package model;

public class Order {
    private int orderID;
    private int clientID;
    private int productID;
    private int numberOfProducts;

    public Order(int orderID, int clientID, int productID, int numberOfProducts) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.productID = productID;
        this.numberOfProducts = numberOfProducts;
    }

    public int getOrderID() {return orderID;}
    public void setOrderID(int orderID) {this.orderID = orderID;}
    public int getClientID() {return clientID;}
    public void setClientID(int clientID) {this.clientID = clientID;}
    public int getProductID() {return productID;}
    public void setProductID(int productID) {this.productID = productID;}
    public int getNumberOfProducts() {return numberOfProducts;}
    public void setNumberOfProducts(int numberOfProducts) {this.numberOfProducts = numberOfProducts;}
}
