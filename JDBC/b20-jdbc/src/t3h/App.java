package t3h;

// tạo một hệ CSDL, hệ CSDL đó là sampledb
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        try {
            File file = new File("./sampledb"); // tạo 1 hệ CSDL
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//kiểm tra xem class EmbeddedDriver có tồn tại hay không, nếu không về văng ngoại lệ ClassNotFoundException
            connection = DriverManager.getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
            statement = connection.createStatement();
            System.out.println("db path:" + file.getAbsolutePath());
            System.out.println("create database successful!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
        }
    }
}
