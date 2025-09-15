import java.sql.Connection;
import Database.dbMysql;
// import function.insert_SV;
import function.menu_SV;

// import java.sql.Statement;
// import java.sql.ResultSet;
public class App {
    static final String QUERY = "SELECT ma_sv, ho_ten, ngay_sinh, nganh_dao_tao, diem_tb, lop_sinh_hoat FROM sinh_vien";

    public static void main(String[] args) {
        try (Connection conn = dbMysql.getConnection()) {
            
            System.out.println("Kết nối MySQL thành công!");


            // Statement stmt = conn.createStatement();
        //  ResultSet rs = stmt.executeQuery(QUERY);

        //  insert_SV insertSV = new insert_SV();
        //  insertSV.insertSinhVien();
         
        //  while(rs.next()){
        //     //Display values
        //     System.out.print("Mã SV: " + rs.getString("ma_sv"));
        //     System.out.print(", Họ Tên: " + rs.getString("ho_ten"));
        //     System.out.print(", Ngày Sinh: " + rs.getString("ngay_sinh"));
        //     System.out.print(", Ngành Đào Tạo: " + rs.getString("nganh_dao_tao"));
        //     System.out.print(", Điểm TB: " + rs.getFloat("diem_tb"));           
        //     System.out.println(", Lớp Sinh Hoạt: " + rs.getString("lop_sinh_hoat"));

                        
        //  }


            menu_SV menuSV = new menu_SV();
            menuSV.menu();

            
            
            
        } catch (Exception e) {
            System.out.println("Kết nối MySQL thất bại!");
            e.printStackTrace();
        }
    }
}
