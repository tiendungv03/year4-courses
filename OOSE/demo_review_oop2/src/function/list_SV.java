package function;

import java.sql.Connection;
import Database.dbMysql;
import java.sql.ResultSet;
import java.sql.Statement;

public class list_SV {
    public Connection conn;

    public list_SV() throws Exception {
        conn = dbMysql.getConnection();
    }

    public void listSinhVien_menu(){
        
        System.out.println("Danh sách sinh viên");
        do {
            System.out.println("1. Hiển thị tất cả sinh viên");
            System.out.println("2. Hiển thị sinh viên theo ngành đào tạo");
            System.out.println("3. Hiển thị sinh viên theo lớp sinh hoạt");
            System.out.println("4. Hiển thị sinh viên theo tháng sinh");
            System.out.println("5. Hiển thị sinh viên theo điểm trung bình");
            System.out.println("6. Quay lại");
            System.out.println("Chọn chức năng: ");
            int choice = Integer.parseInt(System.console().readLine());
            switch(choice){
                case 1:
                    // hiển thị tất cả sinh viên
                    listAllSinhVien();
                    break;
                case 2:
                    // hiển thị sinh viên theo ngành đào tạo
                    listSinhVienByNganhDaoTao();    
                    break;
                case 3:
                    // hiển thị sinh viên theo lớp sinh hoạt
                    listSinhVienByLopSinhHoat();
                    break;
                case 4:
                    // hiển thị sinh viên theo tháng sinh
                    listSinhVienByThangSinh();
                    break;
                case 5:
                    // hiển thị sinh viên theo điểm trung bình
                    listSinhVienByDiemTB();
                    break;
                case 6:
                    System.out.println("Quay lại");
                    return;
                default:
                    System.out.println("Chọn chức năng không hợp lệ");
            }
        } while (true);
    }

    private void listAllSinhVien() {
        String sql = "SELECT ma_sv, ho_ten, ngay_sinh, nganh_dao_tao, diem_tb, lop_sinh_hoat FROM sinh_vien";
        try {
            intoListData_SV(sql);
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách sinh viên");
            e.printStackTrace();
        }
    }

    private void listSinhVienByNganhDaoTao(){
        System.out.println("Chọn ngành đào tạo (CNTT, KTPM): ");
        String nganhDaoTao;
        while (true) {
           nganhDaoTao = System.console().readLine();
            if(!nganhDaoTao.equals("CNTT") && !nganhDaoTao.equals("KTPM")){
                System.out.println("Ngành đào tạo không hợp lệ, vui lòng nhập lại (CNTT, KTPM)");
                continue;
            }
            break;
        }
        String sql = "SELECT ma_sv, ho_ten, ngay_sinh, nganh_dao_tao, diem_tb, lop_sinh_hoat FROM sinh_vien WHERE nganh_dao_tao = '"+nganhDaoTao+"'";
        try {
            intoListData_SV(sql);
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách sinh viên theo ngành đào tạo");
            e.printStackTrace();
        }

    }

    private void listSinhVienByLopSinhHoat(){
        System.out.println("Nhập lớp sinh hoạt (VD: CNTTK45A): ");
        String lopSinhHoat = System.console().readLine();
         if(lopSinhHoat == null || lopSinhHoat.isEmpty()){
             System.out.println("Lớp sinh hoạt không được để trống, vui lòng nhập lại");
             return;
         }
        String sql = "SELECT ma_sv, ho_ten, ngay_sinh, nganh_dao_tao, diem_tb, lop_sinh_hoat FROM sinh_vien WHERE lop_sinh_hoat = '"+lopSinhHoat+"'";
        try {
            intoListData_SV(sql);
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách sinh viên");
            e.printStackTrace();
        }

    }

    private void listSinhVienByThangSinh(){
        System.out.println("Nhập tháng sinh (1-12): ");
        int thangSinh;
        while (true) {
            try {
                thangSinh = Integer.parseInt(System.console().readLine());
                if(thangSinh < 1 || thangSinh > 12){
                    System.out.println("Tháng sinh không hợp lệ, vui lòng nhập lại (1-12)");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Tháng sinh không hợp lệ, vui lòng nhập lại (1-12)");
            }
        }
        String sql = "SELECT ma_sv, ho_ten, ngay_sinh, nganh_dao_tao, diem_tb, lop_sinh_hoat FROM sinh_vien WHERE MONTH(ngay_sinh) = "+thangSinh;
        try {
            intoListData_SV(sql);
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách sinh viên theo tháng sinh");
            e.printStackTrace();
            }

    }

    private void listSinhVienByDiemTB(){
        System.out.println("Hiển thị sắp xếp điểm trung bình (0-10): ");
        String sql = "SELECT ma_sv, ho_ten, ngay_sinh, nganh_dao_tao, diem_tb, lop_sinh_hoat FROM sinh_vien WHERE diem_tb BETWEEN 0 AND 10 ORDER BY diem_tb DESC";
        try {
            intoListData_SV(sql);
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách sinh viên theo điểm trung bình");
            e.printStackTrace();
            }

    }


    private void intoListData_SV(String sql) throws Exception {
        Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Display values
                System.out.print("Mã SV: " + rs.getString("ma_sv"));
                System.out.print(", Họ Tên: " + rs.getString("ho_ten"));
                System.out.print(", Ngày Sinh: " + rs.getString("ngay_sinh"));
                System.out.print(", Ngành Đào Tạo: " + rs.getString("nganh_dao_tao"));
                System.out.print(", Điểm TB: " + rs.getFloat("diem_tb"));
                System.out.println(", Lớp Sinh Hoạt: " + rs.getString("lop_sinh_hoat"));
            }
    }   


}
