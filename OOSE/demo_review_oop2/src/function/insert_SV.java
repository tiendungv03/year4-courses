package function;
import java.sql.Connection;
import java.sql.Date;

import Database.dbMysql;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.sinhVien;


public class insert_SV {
    private Map<String, sinhVien> listData_SV = new HashMap<>();
    String sql = "insert into sinh_vien(ma_sv, ho_ten, ngay_sinh, nganh_dao_tao, diem_tb, lop_sinh_hoat) values(?,?,?,?,?,?)";
    public void insertSinhVien() {
     
        try (Connection conn = dbMysql.getConnection()) {
            
            System.out.println("Kết nối MySQL thành công!");

            Statement stmt = conn.createStatement();

                    System.out.println("Thêm 1 sinh viên mới");

            // ngành đào tạo chỉ có CNTT và KTPM
            Scanner scanner = new Scanner(System.in);
            String nganhDaoTao;
            while(true){
                System.out.println("Nhập ngành đào tạo(CNTT, KTPM): ");
                nganhDaoTao = scanner.nextLine();
                if(nganhDaoTao.equals("CNTT") || nganhDaoTao.equals("KTPM")){
                    break;
                }else{
                    System.out.println("Ngành đào tạo không hợp lệ, vui lòng nhập lại (CNTT, KTPM)");
                }
            }
            // mã sinh viên phải
          String maSV;
          while(true){
            System.out.println("Nhập mã sinh viên(CNTT: 455105xxxx, KTPM: 455109xxxx): ");
            maSV = scanner.nextLine();

            if(nganhDaoTao.equals("CNTT") && maSV.startsWith("455105") && maSV.length() == 10){
                break;
            }else if(nganhDaoTao.equals("KTPM") && maSV.startsWith("455109") && maSV.length() == 10){
                break;
            }else{
                System.out.println("Mã sinh viên không hợp lệ, vui lòng nhập lại");
          }
            }

            // họ tên
            String hoTen;
            while(true){
                System.out.println("Nhập họ tên sinh viên: ");
                // String getHoTen = scanner.nextLine();
                hoTen = scanner.nextLine();
                if(hoTen.length() > 0){
                    break;
                }else{
                    System.out.println("Họ tên không được để trống, vui lòng nhập lại");
                    }
            }   


            // ngày sinh
            Date ngaySinh;   
            int namHocHienTai = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);         
            while(true){
                System.out.println("Nhập ngày sinh (YYYY-MM-DD): ");
                String getNgaySinh = scanner.nextLine();
                
                try{
                    ngaySinh = Date.valueOf(getNgaySinh);
                    int namSinh = Integer.parseInt(getNgaySinh.substring(0, 4));
                    int tuoiMin = namHocHienTai - namSinh;
                    int tuoiMax = namHocHienTai - namSinh;
                    if(tuoiMin > 15 || tuoiMax < 110){
                        System.out.println("Tuổi sinh viên không hợp lệ, vui lòng nhập lại (15 - 110 tuổi)");
                        continue;
                    }
                    break;
                }catch(Exception e){
                    System.out.println("Ngày sinh không hợp lệ, vui lòng nhập lại (YYYY-MM-DD)");
                }
            }
            
            // điểm trung bình
            Double diemTB;
            while(true){
                System.out.println("Nhập điểm trung bình (0.0 - 10.0): ");
                String getDiemTB = scanner.nextLine();
                try{
                    diemTB = Double.parseDouble(getDiemTB);
                    if(diemTB >= 0.0 && diemTB <= 10.0){
                        break;
                    }else{
                        System.out.println("Điểm trung bình không hợp lệ, vui lòng nhập lại (0.0 - 10.0)");
                    }
                }catch(Exception e){
                    System.out.println("Điểm trung bình không hợp lệ, vui lòng nhập lại (0.0 - 10.0)");
                }
            }

            // lớp sinh hoạt
            String lopSinhHoat;
            while(true){
                System.out.println("Nhập lớp sinh hoạt: ");
                lopSinhHoat = scanner.nextLine();
                if(lopSinhHoat.length() > 0){
                    break;
                }else{
                    System.out.println("Lớp sinh hoạt không được để trống, vui lòng nhập lại");
            }   
            }
            
            sinhVien newSV = new model.sinhVien(hoTen, ngaySinh, maSV, nganhDaoTao, diemTB, lopSinhHoat);
            listData_SV.put(maSV, newSV);

            sql = "insert into sinh_vien(ma_sv, ho_ten, ngay_sinh, nganh_dao_tao, diem_tb, lop_sinh_hoat) values('"+maSV+"','"+hoTen+"','"+ngaySinh+"','"+nganhDaoTao+"',"+diemTB+",'"+lopSinhHoat+"')";
            stmt.executeUpdate(sql);
            System.out.println("Thêm sinh viên thành công!");
            System.out.println(newSV.toString());
 
            // xóa dữ liệu trong map sau khi đã chèn vào database
            listData_SV.clear();




    }
        catch (Exception e) {
            System.out.println("Kết nối MySQL thất bại!");
            e.printStackTrace();
        }
    
    }

}
