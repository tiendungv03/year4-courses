

import java.util.Date;

public class person {
    private String hoTen;
    private Date ngaySinh;

    public person(String hoTen, Date ngaySinh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }
}
