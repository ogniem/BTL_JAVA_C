public class ChucVu {
    private String MaChucVu;
    private String TenChucVu;
    private int HeSoLuong;

    public ChucVu() {
    }

    public ChucVu(String maChucVu, String tenChucVu, int heSoLuong) {
        MaChucVu = maChucVu;
        TenChucVu = tenChucVu;
        HeSoLuong = heSoLuong;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        MaChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        TenChucVu = tenChucVu;
    }

    public int getHeSoLuong() {
        return HeSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        HeSoLuong = heSoLuong;
    }
}
