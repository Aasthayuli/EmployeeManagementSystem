package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

    Connection connection;
    Statement statement;

    public DBConnection() {
        String url = "jdbc:mysql://localhost:3306/employeemanagement";
        String username = "root";
        String password = "Mysqlp@ss23";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username,
                    password);
            statement = connection.createStatement();
            System.out.println("Connected to database successfully !");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("Error while connecting to database !");
        }
    }

    public static void main(String[] args) {
        new DBConnection();
    }
}
