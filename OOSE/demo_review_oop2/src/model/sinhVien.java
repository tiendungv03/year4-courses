package model;

import java.util.Date;

public class sinhVien extends person {
    private String maSV;
    private String nganhDaoTao;
    private Double diemTB;
    private String lopSinhHoat;

    public sinhVien(String hoTen, Date ngaySinh, String maSV, String nganhDaoTao, Double diemTB, String lopSinhHoat) {
        super(hoTen, ngaySinh);
        this.maSV = maSV;
        this.nganhDaoTao = nganhDaoTao;
        this.diemTB = diemTB;
        this.lopSinhHoat = lopSinhHoat;
    }


    // public getMaSV() {
    //     return maSV;
    // }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public Double getDiemTB() {
        return diemTB;
    }

    public String getLopSinhHoat() {
        return lopSinhHoat;
    }


    

    @Override
    public String toString() {
        return "Mã SV: " + maSV +
               " | Họ tên: " + getHoTen() +
               " | Ngày sinh: " + getNgaySinh() +
               " | Ngành đào tạo: " + nganhDaoTao +
               " | Điểm TB: " + diemTB +
               " | Lớp: " + lopSinhHoat;
    }
    
}
