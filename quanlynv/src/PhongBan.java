public class PhongBan {
    private String MaPhongBan;
    private String TenPhong;
    private String ViTriPhong;
    private String TenTruongPhong;

    public PhongBan() {
    }

    public PhongBan(String maPhongBan, String tenPhong, String viTriPhong, String tenTruongPhong) {
        MaPhongBan = maPhongBan;
        TenPhong = tenPhong;
        ViTriPhong = viTriPhong;
        TenTruongPhong = tenTruongPhong;
    }

    public String getMaPhongBan() {
        return MaPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        MaPhongBan = maPhongBan;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String tenPhong) {
        TenPhong = tenPhong;
    }

    public String getViTriPhong() {
        return ViTriPhong;
    }

    public void setViTriPhong(String viTriPhong) {
        ViTriPhong = viTriPhong;
    }

    public String getTenTruongPhong() {
        return TenTruongPhong;
    }

    public void setTenTruongPhong(String tenTruongPhong) {
        TenTruongPhong = tenTruongPhong;
    }
}
