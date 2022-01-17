import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class RunMain {
    static DataNv dataNv = new DataNv();
    static DataPhongBan dataPhongBan = new DataPhongBan();
    static DataChucVu dataChucVu = new DataChucVu();
    static DataSoNgayLamViec dataSoNgayLamViec = new DataSoNgayLamViec();
    static  DataLichSu dataLichSu = new DataLichSu();
    public static Scanner sc = new Scanner(System.in);


    static List<Account> listAccount = new ArrayList<>();
    static FileController fileController = new FileController();

    public static void main(String[] args) throws IOException {

        do {
            System.out.println("\n\t++=======* MENU *=======++	");
            System.out.println("           1. Đăng nhập.");
            System.out.println("           2. Thoát.            			");
            System.out.println("================================");
            switch (Choose(1, 2)) {
                case 1:
                    listAccount = fileController.ReadAccountFromFile("Account.DAT");
                    String username, password;
                    System.out.print("Nhập tên tài khoản: ");
                    username = sc.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    password = sc.nextLine();

                    if (KiemTraDangNhap(username, password)) {
                        Account account = new Account();
                        for (int i = 0; i < listAccount.size(); i++)
                            if (listAccount.get(i).getUserName().compareTo(username) == 0)
                                account = listAccount.get(i);


                        do {
                            System.out.println("===============================================");
                            System.out.println("1. Đổi mật khẩu. ");
                            System.out.println("2. Vào chức năng quản lý nhân viên");
                            System.out.println("3. Xem lịch sử quản lý");
                            System.out.println("4. Thoát          ");
                            System.out.println("===============================================");

                            switch (Choose(1, 4)) {
                                case 1:
                                    DoiMatKhau(username, password, account);
                                    System.out.println("Mật khẩu của bạn đã được thay đổi!");
                                    break;
                                case 2:
                                    LayDuLieu();

                                    Menu1 menu1 = new Menu1();
                                    int chon;
                                    do {
                                        // sc.nextLine();
                                        System.out.println("\n===============MENU===============");
                                        System.out.println("1. Xem danh sách nhân viên");
                                        System.out.println("2. Thêm");
                                        System.out.println("3. Sửa");
                                        System.out.println("4. Tìm kiếm");
                                        System.out.println("0. Thoát");
                                        System.out.println("==================================");
                                        System.out.print("Chọn: ");

                                        chon = sc.nextInt();

                                        switch (chon) {
                                            case 1:
                                                System.out.println("Danh sách nhân viên:");
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
//                                    System.out.print("Nhấn Enter để tiếp tục....");
//                                    sc.nextLine();
                                    return;
                                //break;
                                case 3:
                                    System.out.println("=================Lịch sử======================");
                                    System.out.println(dataLichSu.ReadNV());
                                    System.out.println("Nhấn Enter để tiêp tục");
                                    sc.nextLine();
                                    break;
                                case 4:
                                    return;

                                default:
                                    System.out.println("Lựa chọn không hợp lệ\n");

                            }
                        } while (true);
                    } else
                        System.out.println("Tên hoặc mật khẩu không đúng!");
                    break;

                case 2:
                    System.out.println("Đã thoát khỏi chương trình! ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ\n");
            }
        } while (true);
    }

    // Enter choose
    public static int Choose(int a, int b) {
        int choose;
        do {
            try {
                do {
                    System.out.print("\nNhập lựa chọn: ");
                    choose = Integer.parseInt(sc.nextLine());
                    if (choose < a || choose > b)
                        System.out.println("Lựa chọn không chính xác");
                } while (choose < a || choose > b);
                return choose;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ!");
            }
        } while (true);
    }

    // Check username passwork login
    public static boolean KiemTraDangNhap(String username, String password) {
        listAccount = fileController.ReadAccountFromFile("Account.DAT");
        for (int i = 0; i < listAccount.size(); i++)
            if (listAccount.get(i).getUserName().compareTo(username) == 0
                    && listAccount.get(i).getPassword().compareTo(password) == 0){
                Data.acc.setUserName(username);
                Data.acc.setPassword(password);
                dataLichSu.GhiFile("Đăng nhập");
                System.out.println("Đăng nhập thành công!");
                return true;
            }
        System.out.println("Đăng nhập không thành công, kiểm tra lại thông tin đăng nhập!");
        return false;
    }

    public static void DoiMatKhau(String username, String oldPassword, Account account) {
        String checkOldPassword, newPassword, confirmNewPassword;
        // Enter old password
        do {
            System.out.print("\tNhập mật khẩu cũ: ");
            checkOldPassword = sc.nextLine();

            if (checkOldPassword.compareTo(oldPassword) != 0)
                System.out.println("Mật khẩu cũ không hợp lệ");
            else
                break;
        } while (true);

        // Nhập mk mới
        do {
            System.out.print("\tNhập mật khẩu mới: ");
            newPassword = sc.nextLine();
            if (newPassword.compareTo(checkOldPassword) == 0)
                System.out.println("Mật khẩu mới và mật khẩu cũ không được trùng nhau");
            else
                break;
        } while (true);
        // Xác nhận lại mk
        do {
            System.out.print("\tXác nhận lại mật khẩu mới: ");
            confirmNewPassword = sc.nextLine();
            if (newPassword.compareTo(confirmNewPassword) != 0)
                System.out.println("Mật khẩu và mật khẩu xác nhận không khớp");
            else
                break;
        } while (true);

        // cập nhật lại mật khẩu
        account.setPassword(newPassword);
        for (int i = 0; i < listAccount.size(); i++)
            if (listAccount.get(i).getUserName().compareTo(username) == 0) {
                listAccount.set(i, account);
                break;
            }
        fileController.UpdateAccountFile(listAccount, "Account.DAT");
    }

    private static void timKiem() {
        int chonTimKiem;
        do {
            System.out.println("=============Menu Tìm kiếm==============");
            System.out.println("Lựa chọn tìm kiếm theo: ");
            System.out.println("1. Chức vụ                 2. Tên phòng ban");
            System.out.println("3. Quê quán                4. Năm sinh");
            System.out.println("5. Tên                     6. Mã nhân viên");
            System.out.println("7. Thoát khỏi tìm kiếm");
            System.out.println("========================================");
            System.out.print("Nhập lựa chọn tìm kiếm: ");
            chonTimKiem = sc.nextInt();
            switch (chonTimKiem) {
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
//            System.out.print("Nhấn Enter để tiếp tục....");
//            sc.nextLine();
//            return;
        } while (chonTimKiem != 7);

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
        System.out.print("Nhập quê quán: ");
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
            if (i.getPhongBan().equals(phongBans.getMaPhongBan())) {
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

