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
            System.out.println("=====================================================================================================================");
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
                    menu1.them();
                    break;
                case 3:
                    menu1.sua();
                    break;
                case 4:
                    timKiem();
                    break;
                case 0:
                    System.out.println("Thoát ");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (chon != 0);
        dataNv.GhiFile2(Data.nhanVienList);
        System.out.print("Nhấn Enter để tiếp tục....");
        sc.nextLine();
        return;
    }

    private static void timKiem() {
        int chonTimKiem ;
        do{
            System.out.println("=============Menu Tìm kiếm==============");
            System.out.println("Lựa chọn tìm kiếm theo: ");
            System.out.println("1.Chức vụ                 2.Tên phòng ban");
            System.out.println("3.Quê quán                4.Năm sinh");
            System.out.println("5.Tên                     6.Mã nhân viên");
            System.out.println("7.Thoát khỏi tìm kiếm");
            System.out.print("Nhập lựa chọn tìm kiếm: ");
            chonTimKiem= sc.nextInt();
            switch (chonTimKiem){
                case 1:
                    timKiemChucVu();
                    break;
                case 2:
                    timKiemPhongBan();
                    break;
                case 3:
                    timKiemQueQuan();
                    break;
                case 4:
                    timKiemNamSinh();
                    break;
                case 5:
                    timKiemTen();
                    break;
                case 6:
                    timKiemMaNV();
                    break;
                case 7:

                    break;
                default:
                    System.out.println("Lựa chọn tìm kiếm không hợp lệ");

            }
            System.out.print("Nhấn Enter để tiếp tục....");
            sc.nextLine();
            return;
        }while (chonTimKiem != 7);

    }

    private static void timKiemMaNV() {
        List<NhanVien> nhanViens = new ArrayList<>();
        System.out.println("Nhập Mã nhân viên: ");
        sc.nextLine();
        String Manv = sc.nextLine();
        for (NhanVien i : Data.nhanVienList) {
            if (i.getMaNV().equals(Manv)) {
                nhanViens.add(i);
            }
        }
        Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
    }

    private static void timKiemTen() {
        List<NhanVien> nhanViens = new ArrayList<>();
        System.out.println("Nhập Tên muốn tìm: ");
        sc.nextLine();
        String TenNv = sc.nextLine();
        for (NhanVien i : Data.nhanVienList) {
            if (i.getTen().indexOf(TenNv) >= 0) {
                nhanViens.add(i);
            }
        }
        Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
    }

    private static void timKiemNamSinh() {
        List<NhanVien> nhanViens = new ArrayList<>();
        System.out.println("Nhập năm sinh: ");
        sc.nextLine();
        String NamSinh = sc.nextLine();
        for (NhanVien i : Data.nhanVienList) {
            if (i.getNamSinh().equals(NamSinh)) {
                nhanViens.add(i);
            }
        }
        Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
    }

    private static void timKiemQueQuan() {
        List<NhanVien> nhanViens = new ArrayList<>();
        System.out.println("Nhập quê quán: ");
        sc.nextLine();
        String QueQuan = sc.nextLine();
        for (NhanVien i : Data.nhanVienList) {
            if (i.getQueQuan().equals(QueQuan)) {
                nhanViens.add(i);
            }
        }
        Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
    }

    private static void timKiemPhongBan() {
        //hiển thị các phòng ban đang có
        System.out.println("Chọn phòng ban muốn tìm kiếm: ");
        int d1 = 0;
        for (PhongBan i : Data.phongBanList) {
            d1++;
            System.out.println(d1 + "." + i.getTenPhong());
        }
        int chonSo1;
        System.out.print("Chọn phòng ban số: ");
        chonSo1 = sc.nextInt();
        //tìm kiếm phòng ban được chọn
        d1 = 0;
        PhongBan phongBans = new PhongBan();
        for (PhongBan i : Data.phongBanList) {
            d1++;
            if (d1 == chonSo1)
                phongBans = i;
        }
        //Tách nhân viên có chức vụ được chọn
        List<NhanVien> nhanViens = new ArrayList<>();
        for (NhanVien i : Data.nhanVienList) {
            if (i.getChucVu().equals(phongBans.getMaPhongBan())) {
                nhanViens.add(i);
            }
        }
        Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
    }

    private static void timKiemChucVu() {
        //hiển thị các chức vụ đang có
        System.out.println("Chọn chức vụ muốn tìm kiếm: ");
        int d = 0;
        for (ChucVu i : Data.chucVuList) {
            d++;
            System.out.println(d + "." + i.getTenChucVu());
        }
        int chonSo;
        System.out.print("Chọn chức vụ số: ");
        chonSo = sc.nextInt();
        //tìm kiếm chức vụ được chọn
        d = 0;
        ChucVu chucVus = new ChucVu();
        for (ChucVu i : Data.chucVuList) {
            d++;
            if (d == chonSo)
                chucVus = i;
        }
        //Tách nhân viên có chức vụ được chọn
        List<NhanVien> nhanViens = new ArrayList<>();
        for (NhanVien i : Data.nhanVienList) {
            if (i.getChucVu().equals(chucVus.getMaChucVu())) {
                nhanViens.add(i);
            }
        }
        Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
    }

    public static void LayDuLieu() {
        Data.nhanVienList = dataNv.ReadNV();
        Data.phongBanList = dataPhongBan.Read();
        Data.chucVuList = dataChucVu.ReadNV();
        Data.soNgayLamViecList = dataSoNgayLamViec.ReadNV();

    }




}
