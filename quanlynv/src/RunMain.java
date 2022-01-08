import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {


    static DataNv dataNv = new DataNv();
    static DataPhongBan dataPhongBan = new DataPhongBan();
    static DataChucVu dataChucVu = new DataChucVu();
    static DataSoNgayLamViec dataSoNgayLamViec = new DataSoNgayLamViec();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        LayDuLieu();
        Menu1 menu1 = new Menu1();
        int chon;
        do {
            System.out.println("======================================================================");
            System.out.println("===============MENU===============");
            System.out.println("1.Xem danh sách nhân viên");
            System.out.println("2. Thêm");
            System.out.println("3.Sửa");
            System.out.println("4.Tìm kiếm");
            System.out.println("0.Thoát");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    menu1.xemDanhSach();

                    break;
                case 2:
                    Menu1.them();
                    break;
                case 3:
                    sua();
                    break;
                case 4:
                    xoa();
                    break;
                case 0:
                    System.out.println("Thoát ");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (chon != 0);

    }

    public static void LayDuLieu() {
        Data.nhanVienList = dataNv.ReadNV();
        Data.phongBanList = dataPhongBan.Read();
        Data.chucVuList = dataChucVu.ReadNV();
        Data.soNgayLamViecList = dataSoNgayLamViec.ReadNV();

    }



    private static void sua() {
    }

    private static void xoa() {
    }

}
