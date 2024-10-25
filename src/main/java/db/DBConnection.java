package db;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DBConnection {
    private static DBConnection instance;
    private final Connection connection;

    private DBConnection() throws SQLException {
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/clothify", "root", "12345");
    }

    public static DBConnection getInstance() throws SQLException {
        return null==instance?instance = new DBConnection():instance;
    }
}
