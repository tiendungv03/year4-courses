package Database;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbMysql {

    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/dbTest";
        // String name = "tiendungv03";
        String name = "root";
        String password = "tdung@2209";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, name, password);
    }
}
