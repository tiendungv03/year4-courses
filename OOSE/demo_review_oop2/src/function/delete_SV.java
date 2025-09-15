package function;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Database.dbMysql;

public class delete_SV {
    public void deleteSinhVien(){
        System.out.println("Xóa sinh viên");
        try(Connection conn = dbMysql.getConnection()) {
            

            System.out.println("Nhập mã sinh viên cần xóa: ");
            String maSV;


                maSV = System.console().readLine();
                if(maSV != null && !maSV.isEmpty()){
                    String QUERY = "SELECT ma_sv, ho_ten, ngay_sinh, nganh_dao_tao, diem_tb, lop_sinh_hoat FROM sinh_vien where ma_sv = '"+maSV+"'";

                     Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(QUERY);
                    if(rs.next()){
                        System.out.println("Tìm thấy sinh viên với mã: " + maSV);
                        // hiển thị thông tin sinh viên
                        System.out.print("Mã SV: " + rs.getString("ma_sv"));
                        System.out.print(", Họ Tên: " + rs.getString("ho_ten"));
                        System.out.print(", Ngày Sinh: " + rs.getString("ngay_sinh"));
                        System.out.print(", Ngành Đào Tạo: " + rs.getString("nganh_dao_tao"));
                        System.out.print(", Điểm TB: " + rs.getFloat("diem_tb"));           
                        System.out.println(", Lớp Sinh Hoạt: " + rs.getString("lop_sinh_hoat"));


                        System.out.println("Xác nhận xóa sinh viên với mã: " + maSV + " (y/n): ");
                        String confirm = System.console().readLine();
                        if(confirm.equalsIgnoreCase("y")){
                            String DELETE_QUERY = "DELETE FROM sinh_vien WHERE ma_sv = '"+maSV+"'";
                            int rowsAffected = stmt.executeUpdate(DELETE_QUERY);
                            if (rowsAffected > 0) {
                                System.out.println("Xóa sinh viên thành công.");
                            } else {
                                System.out.println("Xóa sinh viên thất bại.");
                                } 
                            }
                        else {
                            System.out.println("Hủy xóa sinh viên.");
                            }

                    }else{
                        System.out.println("Không tìm thấy sinh viên với mã: " + maSV);
                    }
                }else{  
                System.out.println("Mã sinh viên không được để trống, vui lòng nhập lại: ");
            }

            
            
        } catch (Exception e) {
            e.printStackTrace();
        System.out.println("Sửa thông tin sinh viên");
        }
    }
}
