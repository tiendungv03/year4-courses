import java.sql.Connection;
import Database.dbMysql;
public class App {

    public static void main(String[] args) {
        try (Connection conn = dbMysql.getConnection()) {
            System.out.println("Kết nối MySQL thành công!");
        } catch (Exception e) {
            System.out.println("Kết nối MySQL thất bại!");
            e.printStackTrace();
        }
    }
}
