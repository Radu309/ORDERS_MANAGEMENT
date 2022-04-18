package model;

import prezentation.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private int ID;
    private String name;
    private String email;
    private int age;

    public Client(int ID, String name, String email, int age) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
}
