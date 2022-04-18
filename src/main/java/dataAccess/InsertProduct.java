package dataAccess;

import connection.MySql;
import model.Client;
import model.Product;
import prezentation.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertProduct {
    private static List<Product> productsList= new ArrayList<>();

    public void insertOneProduct(String name,String number, String price ){
        Product product = new Product(
                productsList.size() + 1,
                name,
                Integer.parseInt(number),
                Float.parseFloat(price)
        );
        productsList.add(product);
        showProductsList(productsList);
        insertOneProductInDataBase(product);
        Controller controller = new Controller();
        controller.writeProducts(productsList);
    }
    public void insertOneProductInDataBase(Product product){
        Connection connection = MySql.getConnection();
        try {
            String sql = ("INSERT INTO products(ID, nameProduct, numberProducts, price)" + "VALUES(?, ?, ?, ?)");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(product.getID()));
            statement.setString(2,product.getName());
            statement.setString(3,String.valueOf(product.getNumber()));
            statement.setString(4,String.valueOf(product.getPrice()));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteOneProduct(int index){
        if(productsList.size() > 0) {
            productsList.remove(index);
            for (int i = index; i < productsList.size(); i++) {
                productsList.get(i).setID(productsList.get(i).getID() - 1);
            }
            showProductsList(productsList);
            deleteOneProductFromDataBase(index + 1);
            Controller controller = new Controller();
            controller.writeProducts(productsList);
        }
    }
    public void deleteOneProductFromDataBase(int index){
        Connection connection = MySql.getConnection();
        try {
            String sql = ("delete from products where products.ID = ?");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(index));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql = ("update products set ID=ID - 1 where products.ID>?");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(index));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void decrementProduct(int index, int nr){
        productsList.get(index).setNumber(productsList.get(index).getNumber() - nr);
        showProductsList(productsList);
        Controller controller = new Controller();
        controller.writeProducts(productsList);
    }
    public void showProductsFromDataBase(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Product product = new Product(
                    Integer.parseInt(resultSet.getString("ID")),
                    resultSet.getString("nameProduct"),
                    Integer.parseInt(resultSet.getString("numberProducts")),
                    Float.parseFloat(resultSet.getString("price"))
            );
            productsList.add(product);
        }
        showProductsList(productsList);
        Controller controller = new Controller();
        controller.writeProducts(productsList);

    }
    public void showProductsList(List<Product> productsList){
        System.out.println();
        for(Product it: productsList)
            System.out.println(it.getID() + " " + it.getName() + " " + it.getNumber() + " " + it.getPrice());
    }

    public void editOneProduct(String string1, String string2, String string3, String string4){
        productsList.get(Integer.parseInt(string1)-1).setName(string2);
        productsList.get(Integer.parseInt(string1)-1).setNumber(Integer.parseInt(string3));
        productsList.get(Integer.parseInt(string1)-1).setPrice(Integer.parseInt(string4));
        showProductsList(productsList);
        editOneProductFromDataBase(string1,string2,string3,string4);
        Controller controller = new Controller();
        controller.writeProducts(productsList);
    }
    public void editOneProductFromDataBase(String string1, String string2, String string3, String string4){
        Connection connection = MySql.getConnection();
        try {
            String sql = ("update products set products.nameProduct = ?, products.numberProducts = ?, products.price = ? where products.ID = ?");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,string2);
            statement.setString(2,string3);
            statement.setString(3,string4);
            statement.setString(4,string1);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProductsList() {return productsList;}
    public void setProductsList(List<Product> productsList) {this.productsList = productsList;}
}
