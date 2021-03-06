import java.io.*;
import java.util.*;

public class Menu1 {
    // static Date dateTime;
    static List<Account> listAccount = new ArrayList<>();
    static FileController fileController = new FileController();
    static Scanner sc = new Scanner(System.in);
    private static DataNv dataNv;
    // private static Object PhongBan;

    public Menu1() {
        Calendar k = Calendar.getInstance();
        Data.Thang = k.get(Calendar.MONTH) + 1;
        Data.Nam = k.get(Calendar.YEAR);
    }


    public static void xemDanhSach() throws IOException {
        Display.ShowNhanVien(Data.nhanVienList, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
        int chon;
        do {
            System.out.println("\n=====================MENU1=====================");
            System.out.println("0. Xem thống kê");
            System.out.println("1. Xem chi tiết");
            System.out.println("2. Thêm");
            System.out.println("3. Sửa");
            System.out.println("4. Lọc");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Quay lại");
            System.out.println("================================================");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            switch (chon) {
                case 0:
                    xemThongKe();
                    break;
                case 1:
                    xemChiTiet();
                    break;
                case 2:
                    them();
                    break;
                case 3:
                    sua();
                    break;
                case 4:
                    loc();
                    break;
                case 5:
                    sapXep();
                    break;
                case 6:
                    System.out.println("Thoát ");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (chon != 6);

        System.out.print("Nhấn Enter để tiếp tục....");
        sc.nextLine();
     //   return;
    }

    public static void xemThongKe() {
        System.out.println("=================================================================");
        System.out.println("Nhập năm muốn xem: ");
        Calendar m = Calendar.getInstance();
        int nam = sc.nextInt();
        if (nam > m.get(Calendar.YEAR)) {
            System.out.println("Năm không hợp lệ");
            return;
        }
        System.out.println("Nhập tháng muốn xem: ");
        int thang = sc.nextInt();
        if (thang > 12 || thang < 1) {
            System.out.println("Tháng không hợp lệ");
            return;
        }
        if (nam == m.get(Calendar.YEAR) && (thang - 1) > m.get(Calendar.MONTH)) {
            System.out.println("Tháng không hợp lệ");
            return;
        }
        Data.Nam = nam;
        Data.Thang = thang;
        Display.ShowNhanVien(Data.nhanVienList, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
    }
    //==================================================================3.Sua=======================================================================

    public static void sua() {

        //  sc.nextLine();
        DataLichSu dataLichSu = new DataLichSu();
        listAccount = fileController.ReadAccountFromFile("Account.DAT");
        System.out.println("Đăng nhập để sửa: ");
        String username, password;
        sc.nextLine();
        System.out.print("Nhập tên tài khoản: ");
        username = sc.nextLine();
        System.out.print("Nhập mật khẩu: ");
        password = sc.nextLine();

        listAccount = fileController.ReadAccountFromFile("Account.DAT");
        for (int m = 0; m < listAccount.size(); m++)
            if (listAccount.get(m).getUserName().compareTo(username) == 0
                    && listAccount.get(m).getPassword().compareTo(password) == 0) {
                Account account = new Account();
                for (int n = 0; n < listAccount.size(); n++)
                    if (listAccount.get(n).getUserName().compareTo(username) == 0)
                        account = listAccount.get(n);


                System.out.println("Nhập Mã nhân viên muốn sửa: ");
                String Manv = sc.nextLine();
                for (int i = 0; i < Data.nhanVienList.size(); i++) {
                    if (Data.nhanVienList.get(i).getMaNV().equals(Manv)) {
                        int chon2;
                        do {

                            NhanVien nhanVien = Data.nhanVienList.get(i);
                            System.out.println("=================================================");
                            System.out.println("1.Sửa Họ đệm                2.Sửa Tên");
                            System.out.println("3.Sửa Giới tính             4.Sửa Năm sinh");
                            System.out.println("5.Sửa Quê quán              6.Sửa SDT");
                            System.out.println("7.Sửa Email                 8.Sửa Chức vụ");
                            System.out.println("9.Sửa Phòng ban             10.Sửa Thâm niên");
                            System.out.println("0.Quay lại");
                            System.out.println("=================================================");
                            System.out.print("Nhập lựa chọn sửa: ");
                            chon2 = sc.nextInt();
                            switch (chon2) {
                                case 1:
                                    System.out.print("Nhập họ đệm mới: ");
                                    sc.nextLine();
                                    String HoDemNew = sc.nextLine();
                                    nhanVien.setHoDem(HoDemNew);
                                    Data.nhanVienList.set(i, nhanVien);
                                    break;
                                case 2:
                                    System.out.print("Nhập tên mới: ");
                                    sc.nextLine();
                                    String TenNew = sc.nextLine();
                                    nhanVien.setTen(TenNew);
                                    Data.nhanVienList.set(i, nhanVien);
                                    break;
                                case 3:
                                    System.out.print("Nhập giới tính mới: ");
                                    sc.nextLine();
                                    String GioiTinhNew = sc.nextLine();
                                    nhanVien.setGioiTinh(GioiTinhNew);
                                    Data.nhanVienList.set(i, nhanVien);
                                    break;
                                case 4:
                                    System.out.print("Nhập năm sinh mới: ");
                                    sc.nextLine();
                                    String NamSinhNew = sc.nextLine();
                                    nhanVien.setNamSinh(NamSinhNew);
                                    Data.nhanVienList.set(i, nhanVien);
                                    break;
                                case 5:
                                    System.out.print("Nhập quê quán mới: ");
                                    sc.nextLine();
                                    String QueQuanNew = sc.nextLine();
                                    nhanVien.setQueQuan(QueQuanNew);
                                    Data.nhanVienList.set(i, nhanVien);
                                    break;
                                case 6:
                                    System.out.print("Nhập sđt mới: ");
                                    String SDTNew = sc.nextLine();
                                    nhanVien.setSDT(SDTNew);
                                    Data.nhanVienList.set(i, nhanVien);
                                    break;
                                case 7:
                                    System.out.print("Nhập mail mới: ");
                                    sc.nextLine();
                                    String MailNew = sc.nextLine();
                                    nhanVien.setMail(MailNew);
                                    Data.nhanVienList.set(i, nhanVien);
                                    break;
                                case 8:
                                    System.out.println("Chọn chức vụ mới: ");
                                    int d = 0;
                                    for (ChucVu j : Data.chucVuList) {
                                        d++;
                                        System.out.println(d + "." + j.getTenChucVu());
                                    }
                                    int chonSo;
                                    System.out.print("Chọn chức vụ số: ");
                                    sc.nextLine();
                                    chonSo = sc.nextInt();
                                    //tìm kiếm chức vụ được chọn
                                    d = 0;
                                    ChucVu chucVus = new ChucVu();
                                    for (ChucVu j : Data.chucVuList) {
                                        d++;
                                        if (d == chonSo) {
                                            String ChucVuNew = j.getMaChucVu();
                                            nhanVien.setChucVu(ChucVuNew);
                                            Data.nhanVienList.set(i, nhanVien);
                                        }
                                    }

                                    break;
                                case 9:
                                    System.out.println("Chọn phòng ban mới: ");
                                    int d1 = 0;
                                    for (PhongBan j : Data.phongBanList) {
                                        d1++;
                                        System.out.println(d1 + "." + j.getTenPhong());
                                    }
                                    int chonSo1;
                                    System.out.print("Chọn phòng ban số: ");
                                    sc.nextLine();
                                    chonSo1 = sc.nextInt();
                                    //tìm kiếm chức vụ được chọn
                                    d1 = 0;
                                    PhongBan phongBans = new PhongBan();
                                    for (PhongBan j : Data.phongBanList) {
                                        d1++;
                                        if (d1 == chonSo1) {
                                            String PhongBanNew = j.getMaPhongBan();
                                            nhanVien.setPhongBan(PhongBanNew);
                                            Data.nhanVienList.set(i, nhanVien);
                                        }
                                    }
                                    break;
                                case 10:
                                    System.out.print("Nhập thâm niên mới: ");
                                    sc.nextLine();
                                    int ThamNienNew = sc.nextInt();
                                    nhanVien.setThamNien(ThamNienNew);
                                    Data.nhanVienList.set(i, nhanVien);
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Nhập lựa chọn sai");

                            }

                        } while (chon2 != 0);
                        dataLichSu.GhiFile("Sửa thông tin nhân viên  " + Manv);

                        System.out.print("Nhấn Enter để tiếp tục....");
                        sc.nextLine();
                        return;

                    }


                }
            }
//            } else
//
//                System.out.println("Đăng nhập sửa không thành công!");


    }


    //============================================================2.Thêm===============================================================================
    public static void them() throws IOException {
        DataLichSu dataLichSu = new DataLichSu();
        NhanVien nhanVien = new NhanVien();
        Data.nhanVienList = RunMain.dataNv.ReadNV();
        sc.nextLine();
        System.out.println("Nhập Mã nhân viên: ");
        String MaNV = sc.nextLine();
        nhanVien.setMaNV(MaNV);

        for (NhanVien t : Data.nhanVienList) {
            if (t.getMaNV().equals(MaNV)) {
                System.out.println("Mã nhân viên đã tồn tại");
                return;
            }
        }
        {
            System.out.println("Nhập Họ đệm: ");
            String HoDem = sc.nextLine();
            nhanVien.setHoDem(HoDem);

            System.out.println("Nhập Tên: ");
            String Ten = sc.nextLine();
            nhanVien.setTen(Ten);

            System.out.println("Nhập Giới tính: ");
            String GioiTinh = sc.nextLine();
            nhanVien.setGioiTinh(GioiTinh);

            System.out.println("Nhập Năm sinh: ");
            String NamSinh = sc.nextLine();
            nhanVien.setNamSinh(NamSinh);

            System.out.println("Nhập Quê quán: ");
            String QueQuan = sc.nextLine();
            nhanVien.setQueQuan(QueQuan);

            System.out.println("Nhập Sđt: ");
            String SDT = sc.nextLine();
            nhanVien.setSDT(SDT);

            System.out.println("Nhập mail: ");
            String mail = sc.nextLine();
            nhanVien.setMail(mail);

            System.out.println("Chọn chức vụ: ");
            System.out.println("Danh sách chức vụ: ");
            int d1 = 0;
            for (ChucVu i : Data.chucVuList) {
                d1++;
                System.out.println(d1 + "." + i.getTenChucVu());
            }
            int chonSo1;
            System.out.print("Chọn chức vụ số: ");
            chonSo1 = sc.nextInt();
            //tìm kiếm chức vụ được chọn
            d1 = 0;
            ChucVu chucVus = new ChucVu();
            for (ChucVu i : Data.chucVuList) {
                d1++;
                if (d1 == chonSo1)
                    nhanVien.setChucVu(i.getMaChucVu());
            }
            //String ChucVu = sc.nextLine();


            System.out.println("Chọn Phòng ban: ");
            System.out.println("Danh sách phòng ban: ");
            int d = 0;
            for (PhongBan i : Data.phongBanList) {
                d++;
                System.out.println(d + "." + i.getTenPhong());
            }
            int chonSo;
            System.out.print("Chọn phòng ban số: ");
            chonSo = sc.nextInt();
            //tìm kiếm phòng ban được chọn
            d = 0;
            PhongBan phongBans = new PhongBan();
            for (PhongBan i : Data.phongBanList) {
                d++;
                if (d == chonSo)
                    nhanVien.setPhongBan(i.getMaPhongBan());
            }


            System.out.println("Nhập Thâm niên: ");
            int ThamNien = sc.nextInt();
            nhanVien.setThamNien(ThamNien);

            Data.nhanVienList.add(nhanVien);
            DataNv dataNv = new DataNv();
            dataNv.GhiFile(nhanVien);
            RunMain.LayDuLieu();
            System.out.println("Đã thêm thành công ");
            Display.ShowNhanVien(Data.nhanVienList, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);

            dataLichSu.GhiFile("Đã thêm nhân viên " + nhanVien.getMaNV());


        }
    }


    //==============================================================  5.Sắp xếp     ===========================================================================

    private static void sapXep() {
        DataLichSu dataLichSu = new DataLichSu();
        int chonSapXep;
        do {
            System.out.println("================Menu sắp xếp===================================");
            System.out.println("1. Sắp xếp theo tên                 2. Sắp xếp theo chức vụ ");
            System.out.println("3. Sắp xếp theo thâm niên           4. Sắp xếp theo năm sinh");
            System.out.println("5. Quay lại");
            System.out.println("===============================================================");
            System.out.println("Nhập lựa chọn: ");
            chonSapXep = sc.nextInt();
            switch (chonSapXep) {
                case 1:
                    xepTheoTen();
                    dataLichSu.GhiFile("Đã sắp xếp danh sách theo tên");
                    break;
                case 2:
                    xepTheoChucVu();
                    dataLichSu.GhiFile("Đã sắp xếp danh sách theo chức vụ");
                    break;
                case 3:
                    xepTheoThamNien();
                    dataLichSu.GhiFile("Đã sắp xếp danh sách theo thâm niên");
                    break;
                case 4:
                    xepTheoNamSinh();
                    dataLichSu.GhiFile("Đã sắp xếp danh sách theo năm sinh");
                    break;
                case 5:

                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");


            }
        } while (chonSapXep != 5);

        System.out.print("Nhấn Enter để tiếp tục....");
        sc.nextLine();
        return;

    }

    private static void xepTheoNamSinh() {
        System.out.println("==========Sắp xếp theo năm sinh========");
        System.out.println("1.Tăng");
        System.out.println("2.Giảm");
        System.out.println("Chọn phím khác để thoát");
        System.out.println("=======================================");
        int chon;
        chon = sc.nextInt();
        List<NhanVien> nhanViens = Data.nhanVienList;
        switch (chon) {
            case 1:

                Collections.sort(nhanViens, new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        return o1.getNamSinh().compareTo(o2.getNamSinh());
                    }
                });
                Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
                break;
            case 2:

                Collections.sort(nhanViens, new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        return o2.getNamSinh().compareTo(o1.getNamSinh());
                    }
                });
                Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
                break;

        }

    }

    private static void xepTheoThamNien() {
        System.out.println("==========Sắp xếp theo thâm niên========");
        System.out.println("1.Tăng");
        System.out.println("2.Giảm");
        System.out.println("Chọn phím khác để thoát");
        System.out.println("========================================");
        int chon;
        chon = sc.nextInt();
        List<NhanVien> nhanViens = Data.nhanVienList;
        switch (chon) {
            case 1:

                Collections.sort(nhanViens, new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        if (o1.getThamNien() > o2.getThamNien()) {
                            return 1;
                        }
                        return -1;
                    }
                });
                Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
                break;
            case 2:

                Collections.sort(nhanViens, new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        if (o1.getThamNien() < o2.getThamNien()) {
                            return 1;
                        }
                        return -1;
                    }
                });
                Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
                break;

        }


    }

    private static void xepTheoChucVu() {
        System.out.println("==========Sắp xếp theo chức vụ========");
        System.out.println("1.Tăng");
        System.out.println("2.Giảm");
        System.out.println("Chọn phím khác để thoát");
        System.out.println("======================================");
        int chon;
        chon = sc.nextInt();
        List<NhanVien> nhanViens = Data.nhanVienList;
        switch (chon) {
            case 1:

                Collections.sort(nhanViens, new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        return o1.getChucVu().compareTo(o2.getChucVu());
                    }
                });
                Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
                break;
            case 2:

                Collections.sort(nhanViens, new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        return o2.getChucVu().compareTo(o1.getChucVu());
                    }
                });
                Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
                break;

        }


    }

    private static void xepTheoTen() {
        System.out.println("==========Sắp xếp theo tên========");
        System.out.println("1.Tăng");
        System.out.println("2.Giảm");
        System.out.println("Chọn phím khác để thoát");
        System.out.println("==================================");
        int chon;
        chon = sc.nextInt();
        List<NhanVien> nhanViens = Data.nhanVienList;
        switch (chon) {
            case 1:

                Collections.sort(nhanViens, new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        return o1.getTen().compareTo(o2.getTen());
                    }
                });
                Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
                break;
            case 2:

                Collections.sort(nhanViens, new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        return o2.getTen().compareTo(o1.getTen());
                    }
                });
                Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
                break;

        }


    }

    //==============================================================   4.Lọc     ===========================================================================
    public static void loc() {
        int chonLoc;
        do {
            System.out.println("=========================Menu lọc=========================");
            System.out.println("1. Lọc theo quê quán            2. Lọc theo năm sinh ");
            System.out.println("3. Lọc theo giới tính           4. Lọc theo phòng ban");
            System.out.println("5. Lọc theo chức vụ             6. Lọc theo thâm niên");
            System.out.println("7. Quay lại");
            System.out.println("==========================================================");

            System.out.println("Nhập lựa chọn: ");
            chonLoc = sc.nextInt();
            switch (chonLoc) {
                case 1:
                    locTheoQueQuan();
                    break;
                case 2:
                    locTheoNamSinh();
                    break;
                case 3:
                    locTheoGioiTinh();
                    break;
                case 4:
                    locTheoPhongBan();
                    break;

                case 5:
                    locTheoChucVu();
                    break;
                case 6:
                    locTheoThamNien();
                    break;
                case 7:

                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");


            }
        } while (chonLoc != 7);
        System.out.print("Nhấn Enter để tiếp tục....");
        sc.nextLine();
        return;
    }


    private static void locTheoThamNien() {
        List<NhanVien> nhanViens = new ArrayList<>();
        System.out.println("Nhập Thâm niên: ");
        sc.nextLine();
        int ThamNien = sc.nextInt();
        for (NhanVien i : Data.nhanVienList) {
            if (i.getThamNien() == ThamNien) {
                nhanViens.add(i);
            }
        }
        Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
    }

    private static void locTheoPhongBan() {
        //hiển thị các phòng ban đang có
        System.out.println("Chọn phòng ban lọc: ");
        int d = 0;
        for (PhongBan i : Data.phongBanList) {
            d++;
            System.out.println(d + "." + i.getTenPhong());
        }
        int chonSo;
        System.out.print("Chọn phòng ban số: ");
        chonSo = sc.nextInt();
        //tìm kiếm phòng ban được chọn
        d = 0;
        PhongBan phongBans = new PhongBan();
        for (PhongBan i : Data.phongBanList) {
            d++;
            if (d == chonSo)
                phongBans = i;
        }
        //Tách nhân viên có phòng ban được chọn
        List<NhanVien> nhanViens = new ArrayList<>();
        for (NhanVien i : Data.nhanVienList) {
            if (i.getPhongBan().equals(phongBans.getMaPhongBan())) {
                nhanViens.add(i);
            }
        }
        Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
    }

    private static void locTheoGioiTinh() {
        List<NhanVien> nhanViens = new ArrayList<>();
        System.out.println("Nhập Giới tính: ");
        sc.nextLine();
        String GioiTinh = sc.nextLine();
        for (NhanVien i : Data.nhanVienList) {
            if (i.getGioiTinh().equals(GioiTinh)) {
                nhanViens.add(i);
            }
        }
        Display.ShowNhanVien(nhanViens, Data.chucVuList, Data.phongBanList, Data.soNgayLamViecList);
    }

    private static void locTheoNamSinh() {
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

    private static void locTheoChucVu() {
        //hiển thị các chức vụ đang có
        System.out.println("Chọn chức vụ lọc: ");
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

    private static void locTheoQueQuan() {
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


    //==============================================================   1.Xem chi tiết     ===========================================================================

    public static void xemChiTiet() {
        DataLichSu dataLichSu = new DataLichSu();
        System.out.println("Nhập mã nhân viên muốn xem chi tiết: ");
        sc.nextLine();
        String MaNV = sc.nextLine();
        for (NhanVien i : Data.nhanVienList) {
            if (i.getMaNV().equals(MaNV)) {
                ChucVu chucVu = Display.TimChucVu(i.getChucVu(), Data.chucVuList);
                PhongBan phongBan = Display.TimPhongBan(i.getPhongBan(), Data.phongBanList);
                List<SoNgayLam> soNgayLams = Display.TimTatCaThangLuong(i.getMaNV(), Data.soNgayLamViecList);
                System.out.println("================================Thông tin nhân viên================================");
                System.out.println("Mã Nv: " + i.getMaNV());
                System.out.println("Họ và tên: " + i.getHoDem() + " " + i.getTen());
                System.out.println("Giới tính: " + i.getGioiTinh() + "       Năm sinh: " + i.getNamSinh());
                System.out.println("Quê quán: " + i.getQueQuan());
                System.out.println("Sđt: " + i.getSDT() + "      Gmail: " + i.getMail());
                System.out.println("Chức vụ: " + chucVu.getTenChucVu() + " Hệ số lương: " + chucVu.getHeSoLuong());
                System.out.println("Phòng ban: " + phongBan.getTenPhong() + " Trưởng phòng: " + phongBan.getTenTruongPhong());
                System.out.println("Thâm niên: " + i.getThamNien() + " tháng");
                System.out.println("====================================================================================");
         //       System.out.format("%-4s %-10s %-10s %-15s %-15s %-15s %-15s\n", "stt", "Năm", "Tháng", "Chức vụ", "Hệ số lương", "Số ngày làm", "Lương");
                int d = 0;
                for (SoNgayLam j : soNgayLams) {
                    d++;
                    int HeSo = 0;
                    String chucVu1 = null;
                    for (ChucVu m : Data.chucVuList) {
                        if (m.getMaChucVu().equals(j.getMaChucVu())) {
                            chucVu1 = m.getTenChucVu();
                            HeSo = m.getHeSoLuong();
                        }
                    }
                    int luong = HeSo * j.getSoNgayLamViec();
            //        System.out.format("%-4d %-10d %-10d %-15s %-15d %-15d %-15d\n", d, j.getNam(), j.getThang(), chucVu1, HeSo, j.getSoNgayLamViec(), luong);
                }

                dataLichSu.GhiFile("Đã xem chi tiết nhân viên có mã "+ MaNV);
                System.out.print("Nhấn Enter để tiếp tục....");
                sc.nextLine();
                return;
            }
        }
        System.out.println("Không tìm thấy mã nhân viên hợp lệ");
    }


}
