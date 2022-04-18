package connection;
import java.sql.*;

public class MySql{
    private final static String USERNAME = "root";
    private final static String PASSWORD = "12345678";
    private final static String CONNECTION_LINK = "jdbc:mysql://localhost:3306/virtualShop";

    private static final MySql SINGLE_INSTANCE = new MySql();

    public Connection createConnection() {
        try {
            return DriverManager.getConnection(CONNECTION_LINK, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static Connection getConnection() {
        return SINGLE_INSTANCE.createConnection();
    }
    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(Statement statement) {
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
