public class NhanVien {
    private String MaNV;
    private String HoDem;
    private String Ten;
    private String GioiTinh;
    private String NamSinh;
    private String QueQuan;
    private String SDT;
    private String mail;
    private String ChucVu;
    private String PhongBan;
    private int ThamNien;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoDem, String ten, String gioiTinh, String namSinh, String queQuan, String SDT, String mail, String chucVu, String phongBan, int thamNien) {
        MaNV = maNV;
        HoDem = hoDem;
        Ten = ten;
        GioiTinh = gioiTinh;
        NamSinh = namSinh;
        QueQuan = queQuan;
        this.SDT = SDT;
        this.mail = mail;
        ChucVu = chucVu;
        PhongBan = phongBan;
        ThamNien = thamNien;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getHoDem() {
        return HoDem;
    }

    public void setHoDem(String hoDem) {
        HoDem = hoDem;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String namSinh) {
        NamSinh = namSinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }

    public String getPhongBan() {
        return PhongBan;
    }

    public void setPhongBan(String phongBan) {
        PhongBan = phongBan;
    }

    public int getThamNien() {
        return ThamNien;
    }

    public void setThamNien(int thamNien) {
        ThamNien = thamNien;
    }


}
