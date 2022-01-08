public class SoNgayLam {
    private String MaNV;
    private String MaChucVu;
    private int Thang;
    private int Nam;
    private int SoNgayLamViec;

    public SoNgayLam() {
    }

    public SoNgayLam(String maNV, String maChucVu, int thang, int nam, int soNgayLamViec) {
        MaNV = maNV;
        MaChucVu = maChucVu;
        Thang = thang;
        Nam = nam;
        SoNgayLamViec = soNgayLamViec;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        MaChucVu = maChucVu;
    }

    public int getThang() {
        return Thang;
    }

    public void setThang(int thang) {
        Thang = thang;
    }

    public int getNam() {
        return Nam;
    }

    public void setNam(int nam) {
        Nam = nam;
    }

    public int getSoNgayLamViec() {
        return SoNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        SoNgayLamViec = soNgayLamViec;
    }
}
