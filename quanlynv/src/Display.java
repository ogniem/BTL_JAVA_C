import java.util.ArrayList;
import java.util.List;

public class Display {
    public static void ShowNhanVien(List<NhanVien> nhanViens, List<ChucVu> chucVus, List<PhongBan> phongBans, List<SoNgayLam> soNgayLams) {
        System.out.format("%-4s%-15s%-15s%-10s%-10s%-10s%-15s%-10s    %-20s%-15s%-15s%-10s %-18s\n", "Stt", "Mã Nhân viên"
                , "Họ đệm", "Tên", "Giới tính", "Năm sinh", "Quê quán", "Sđt", "Mail", "Chức Vụ", "Phòng ban", "Thâm niên", "Lương(" + Data.Thang + "/" + Data.Nam + ")");
        int d = 0;
        //  System.out.println(Data.Thang+", "+ Data.Nam);
        for (NhanVien i : nhanViens) {
            d++;
            ChucVu chucVu = TimChucVu(i.getChucVu(), chucVus);
            PhongBan phongBan = TimPhongBan(i.getPhongBan(), phongBans);
            SoNgayLam soNgayLam = TimThangLuong(i.getMaNV(), soNgayLams);

            int HeSo = 0;
            for (ChucVu j : chucVus) {
                if (j.getMaChucVu().equals(soNgayLam.getMaChucVu())) {
                    HeSo = j.getHeSoLuong();
                }
            }
            int luong = HeSo * soNgayLam.getSoNgayLamViec();

            System.out.format("%-4d%-15s%-15s%-10s%-10s%-10s%-15s%-10s    %-20s%-15s%-15s%-10d %18d\n", d, i.getMaNV()
                    , i.getHoDem(), i.getTen(), i.getGioiTinh(), i.getNamSinh(), i.getQueQuan(), i.getSDT(),
                    i.getMail(), chucVu.getTenChucVu(), phongBan.getTenPhong(), i.getThamNien(), luong);

        }

    }

    public static ChucVu TimChucVu(String MaChucVu, List<ChucVu> chucVus) {
        ChucVu chucVu = new ChucVu();
        for (ChucVu i : chucVus) {
            if (i.getMaChucVu().equals(MaChucVu)) {
                chucVu = i;
            }
        }
        return chucVu;
    }

    public static PhongBan TimPhongBan(String MaPhongBan, List<PhongBan> phongBans) {
        PhongBan phongBan = new PhongBan();
        for (PhongBan i : phongBans) {
            if (i.getMaPhongBan().equals(MaPhongBan)) {
                phongBan = i;
            }
        }
        return phongBan;
    }

    public static SoNgayLam TimThangLuong(String MaNV, List<SoNgayLam> soNgayLams) {
        SoNgayLam soNgayLam = new SoNgayLam();
        for (SoNgayLam i : soNgayLams) {
            if (i.getMaNV().equals(MaNV) && i.getThang() == Data.Thang && i.getNam() == Data.Nam) {
                soNgayLam = i;
            }
        }
        return soNgayLam;
    }

    public static List<SoNgayLam> TimTatCaThangLuong(String MaNV, List<SoNgayLam> soNgayLams) {
        List<SoNgayLam> soNgayLam = new ArrayList<>();
        for (SoNgayLam i : soNgayLams) {
            if (i.getMaNV().equals(MaNV)) {
                soNgayLam.add(i);
            }
        }
        return soNgayLam;
    }
}
