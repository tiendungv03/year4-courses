package function;

import java.sql.Connection;
import Database.dbMysql;
// import model.sinhVien;

import java.sql.Statement;
import java.sql.ResultSet;

public class update_SV {


    public void updateSinhVien(){
        try(Connection conn = dbMysql.getConnection()) {
            

            System.out.println("Nhập mã sinh viên cần sửa: ");
            String maSV;

            //lưu tạm data
            String hoTen, ngaySinh, nganhDaoTao, lopSinhHoat;
            Double diemTB;


                maSV = System.console().readLine();
                if(maSV != null && !maSV.isEmpty()){
                    String QUERY = "SELECT ma_sv, ho_ten, ngay_sinh, nganh_dao_tao, diem_tb, lop_sinh_hoat FROM sinh_vien where ma_sv = '"+maSV+"'";

                     Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(QUERY);
                    if(rs.next()){
                        System.out.println("Tìm thấy sinh viên với mã: " + maSV);
                        // gán tạm data
                        hoTen = rs.getString("ho_ten");
                        ngaySinh = rs.getString("ngay_sinh");
                        nganhDaoTao = rs.getString("nganh_dao_tao");
                        diemTB = rs.getDouble("diem_tb");
                        lopSinhHoat = rs.getString("lop_sinh_hoat");
                        
                        // hiển thị thông tin sinh viên
                        System.out.print("Mã SV: " + rs.getString("ma_sv"));
                        System.out.print(", Họ Tên: " + rs.getString("ho_ten"));
                        System.out.print(", Ngày Sinh: " + rs.getString("ngay_sinh"));
                        System.out.print(", Ngành Đào Tạo: " + rs.getString("nganh_dao_tao"));
                        System.out.print(", Điểm TB: " + rs.getFloat("diem_tb"));           
                        System.out.println(", Lớp Sinh Hoạt: " + rs.getString("lop_sinh_hoat"));

                        updateData_form(conn, maSV, hoTen, ngaySinh, nganhDaoTao, diemTB, lopSinhHoat);
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


    private void updateData_form (Connection conn, String maSV, String hoTen, String ngaySinh, String nganhDaoTao, Double diemTB, String lopSinhHoat) {
        try {
            // sinhVien tempData = new sinhVien(hoTen, ngaySinh , maSV, nganhDaoTao, diemTB, lopSinhHoat);
            System.out.println("Cập nhật thông tin sinh viên (bỏ trống nếu không thay đổi): ");
            //
            System.out.println("Nhập họ tên mới (bỏ trống nếu không thay đổi): ");
            String newHoTen = System.console().readLine();
            if(newHoTen != null && !newHoTen.isEmpty()){
                hoTen = newHoTen;
            }   

            System.out.println("Nhập ngày sinh mới (bỏ trống nếu không thay đổi): ");
            String newNgaySinh = System.console().readLine();
            if(newNgaySinh != null && !newNgaySinh.isEmpty()){
                ngaySinh = newNgaySinh;
            }   

            System.out.println("Nhập ngành đào tạo mới (bỏ trống nếu không thay đổi): ");
            String newNganhDaoTao = System.console().readLine();
            if(newNganhDaoTao != null && !newNganhDaoTao.isEmpty()){
                nganhDaoTao = newNganhDaoTao;
            }
            System.out.println("Nhập điểm trung bình mới (bỏ trống nếu không thay đổi): ");
            String newDiemTB = System.console().readLine();
            if(newDiemTB != null && !newDiemTB.isEmpty()){
                try{
                    diemTB = Double.parseDouble(newDiemTB);
                }catch(NumberFormatException e){
                    System.out.println("Điểm trung bình không hợp lệ, giữ nguyên giá trị cũ.");
                }
            }

            System.out.println("Nhập lớp sinh hoạt mới (bỏ trống nếu không thay đổi): ");
            String newLopSinhHoat = System.console().readLine();
            if(newLopSinhHoat != null && !newLopSinhHoat.isEmpty()){
                lopSinhHoat = newLopSinhHoat;
            }   

            // tempData = new sinhVien(newHoTen, newNgaySinh, maSV, newNganhDaoTao, diemTB, newLopSinhHoat);

            String UPDATE_QUERY = "UPDATE sinh_vien SET ho_ten = '"+hoTen+"', ngay_sinh = '"+ngaySinh+"', nganh_dao_tao = '"+nganhDaoTao+"', diem_tb = "+diemTB+", lop_sinh_hoat = '"+lopSinhHoat+"' WHERE ma_sv = '"+maSV+"'";
            System.out.println(UPDATE_QUERY);

            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(UPDATE_QUERY);
            if (rowsAffected > 0) {
                System.out.println("Cập nhật thông tin sinh viên thành công.");
            } else {
                System.out.println("Cập nhật thông tin sinh viên thất bại.");
                
            }
            

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi khi cập nhật thông tin sinh viên.");
        }
    }
}
