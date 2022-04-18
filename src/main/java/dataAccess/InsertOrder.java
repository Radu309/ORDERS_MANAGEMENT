package dataAccess;

import connection.MySql;
import model.Order;
import model.Product;
import prezentation.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertOrder {
    private static List<Order> ordersList= new ArrayList<>();

    public void insertOneOrder(String clientID, String productID, String numberOfProducts){
        Order order = new Order(
                ordersList.size() + 1,
                Integer.parseInt(clientID),
                Integer.parseInt(productID),
                Integer.parseInt(numberOfProducts)
        );
        InsertProduct insertProduct = new InsertProduct();
        insertProduct.decrementProduct(order.getProductID() - 1, order.getNumberOfProducts());

        ordersList.add(order);
        showOrdersList(ordersList);
        insertOneOrderInDataBase(order);
        Controller controller = new Controller();
        controller.writeOrders(ordersList);
    }
    public void insertOneOrderInDataBase(Order order){
        Connection connection = MySql.getConnection();
        try {
            String sql = ("INSERT INTO orders(orderID, clientID, productID, numberOfProducts)"
                    + "VALUES(?, ?, ?, ?)");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(order.getOrderID()));
            statement.setString(2,String.valueOf(order.getClientID()));
            statement.setString(3,String.valueOf(order.getProductID()));
            statement.setString(4,String.valueOf(order.getNumberOfProducts()));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showOrdersFromDataBase(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Order order = new Order(
                    Integer.parseInt(resultSet.getString("orderID")),
                    Integer.parseInt(resultSet.getString("clientID")),
                    Integer.parseInt(resultSet.getString("productID")),
                    Integer.parseInt(resultSet.getString("numberOfProducts"))
            );
            ordersList.add(order);
        }
        showOrdersList(ordersList);
        Controller controller = new Controller();
        controller.writeOrders(ordersList);
    }
    public void showOrdersList(List<Order> ordersList){
        System.out.println();
        for(Order it: ordersList)
            System.out.println(it.getOrderID() + " " + it.getClientID() + " " + it.getProductID() + " " + it.getNumberOfProducts());
    }

    public List<Order> getOrdersList() {return ordersList;}
    public void setOrdersList(List<Order> ordersList) {this.ordersList = ordersList;}
}
