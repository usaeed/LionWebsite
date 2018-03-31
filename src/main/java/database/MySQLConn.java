package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConn {

    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException, IOException { 
        Properties properties = new Properties();
        InputStream inputStream = MySQLConn.class.getClassLoader().getResourceAsStream("database.properties");
        properties.load(inputStream);  
        String hostName = properties.getProperty("hostName");
        String dbName = properties.getProperty("dbName");
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");
        
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
            String userName, String password) throws SQLException,
            ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}
