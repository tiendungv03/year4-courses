package function;
import java.util.Scanner;
// import function.insert_SV;
public class menu_SV {
    public void menu(){
        do{
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Nhập danh sách sinh viên từ file");
            // System.out.println("0. Quay lại");
            System.out.println("6. Thoát");
            System.out.println("Chọn chức năng: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    insert_SV inserter = new insert_SV();
                    inserter.insertSinhVien();
                    break;
                case 2:
                    // sửa thông tin sinh viên
                    update_SV updater = new update_SV();
                    updater.updateSinhVien();
                    break;
                case 3:
                    // xóa sinh viên
                    delete_SV deleter = new delete_SV();
                    deleter.deleteSinhVien();
                    break;
                case 4:
                    // hiển thị danh sách sinh viên
                    try {
                        list_SV lister = new list_SV();
                        lister.listSinhVien_menu();
                    } catch (Exception e) {
                        System.out.println("Đã xảy ra lỗi khi gọi danh sách sinh vien: " + e.getMessage());
                    }
                    break;
                case 5:
                    // nhập danh sách sinh viên từ file
                    break;
                case 6:
                    System.out.println("Thoát chương trình");
                    break;

                // case 0:
                //     System.out.println("Quay lại");
                //     break;
                default:
                    System.out.println("Chọn chức năng không hợp lệ");
            }
        }while(true);
    }
    
}
