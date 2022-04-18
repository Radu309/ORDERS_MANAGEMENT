package dataAccess;

import connection.MySql;
import model.Client;
import prezentation.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsertClient {
    private static List<Client> clientsList= new ArrayList<>();

    public void showClientsFromDataBase(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Client client = new Client(
                    Integer.parseInt(resultSet.getString("ID")),
                    resultSet.getString("nameClient"),
                    resultSet.getString("email"),
                    Integer.parseInt(resultSet.getString("age"))
            );
            clientsList.add(client);
        }
        showClientsList(clientsList);
        Controller controller = new Controller();
        controller.writeClients(clientsList);
    }
    public void showClientsList(List<Client> clientsList){
        System.out.println();
        for(Client it: clientsList)
            System.out.println(it.getID() + " " + it.getName() + " " + it.getEmail() + " " + it.getAge());
    }

    public void insertOneClient(String name, String email, String age){
        Client client = new Client(
                clientsList.size() + 1,
                name,
                email,
                Integer.parseInt(age)
        );
        clientsList.add(client);
        showClientsList(clientsList);
        insertOneClientInDataBase(client);
        Controller controller = new Controller();
        controller.writeClients(clientsList);
    }
    public void insertOneClientInDataBase(Client client){
        Connection connection = MySql.getConnection();
        try {
            String sql = ("INSERT INTO clients(ID, nameClient, email, age)" + "VALUES(?, ?, ?, ?)");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(client.getID()));
            statement.setString(2,client.getName());
            statement.setString(3,client.getEmail());
            statement.setString(4,String.valueOf(client.getAge()));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOneClient(int index){
        if(clientsList.size() > 0) {
            clientsList.remove(index);
            for (int i = index; i < clientsList.size(); i++) {
                clientsList.get(i).setID(clientsList.get(i).getID() - 1);
            }
            showClientsList(clientsList);
            deleteOneClientFromDataBase(index+1);
            Controller controller = new Controller();
            controller.writeClients(clientsList);
        }
    }
    public void deleteOneClientFromDataBase(int index){
        Connection connection = MySql.getConnection();
        try {
            String sql = ("delete from clients where clients.ID = ?");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(index));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql = ("update clients set ID=ID - 1  where clients.ID>?");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(index));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editOneClient(String string1, String string2, String string3, String string4){
        clientsList.get(Integer.parseInt(string1)-1).setName(string2);
        clientsList.get(Integer.parseInt(string1)-1).setEmail(string3);
        clientsList.get(Integer.parseInt(string1)-1).setAge(Integer.parseInt(string4));
        showClientsList(clientsList);
        editOneClientFromDataBase(string1,string2,string3,string4);
        Controller controller = new Controller();
        controller.writeClients(clientsList);
    }
    public void editOneClientFromDataBase(String string1, String string2, String string3, String string4){
        Connection connection = MySql.getConnection();
        try {
            String sql = ("update clients set clients.nameClient = ?, clients.email = ?, clients.age = ? where clients.ID = ?");
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
}