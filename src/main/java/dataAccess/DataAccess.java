package dataAccess;

import connection.MySql;

import java.sql.*;
import java.util.logging.Logger;

public class DataAccess {
    protected static final Logger LOGGER = Logger.getLogger(DataAccess.class.getName());

    public DataAccess(){
        MySql mySql = new MySql();
        Connection connection;
        try {
            connection = MySql.getConnection();
            Statement statement = connection.createStatement();
            ResultSet clientsTable = statement.executeQuery("SELECT * FROM clients");
            InsertClient insertClient = new InsertClient();
            insertClient.showClientsFromDataBase(clientsTable);

            ResultSet productsTable = statement.executeQuery("SELECT * FROM products");
            InsertProduct insertProduct = new InsertProduct();
            insertProduct.showProductsFromDataBase(productsTable);

            ResultSet ordersTable = statement.executeQuery("SELECT * FROM orders");
            InsertOrder insertOrder = new InsertOrder();
            insertOrder.showOrdersFromDataBase(ordersTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
