import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataNv {
    String filename = "NV.DAT";
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    PrintWriter printWriter;
    Scanner scanner;

    public void OpenFile() {
        try {
            fileWriter = new FileWriter(filename, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void CloseFile() {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void OpenRead() {
        try {
            scanner = new Scanner(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void GhiFile(NhanVien nhanvien) {

        OpenFile();
        printWriter.println(nhanvien.getMaNV() + "|" + nhanvien.getHoDem() + "|" + nhanvien.getTen() + "|" + nhanvien.getGioiTinh() + "|" + nhanvien.getNamSinh() + "|" + nhanvien.getQueQuan() + "|" + nhanvien.getSDT() + "|" + nhanvien.getMail() + "|" + nhanvien.getChucVu() + "|" + nhanvien.getPhongBan() + "|" + nhanvien.getThamNien());

        CloseFile();
    }
    public void GhiFile2(List<NhanVien> nhanViens) {
        try {
            fileWriter = new FileWriter(filename);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (NhanVien nhanvien:nhanViens) {
            printWriter.println(nhanvien.getMaNV() + "|" + nhanvien.getHoDem() + "|" + nhanvien.getTen() + "|" + nhanvien.getGioiTinh() + "|" + nhanvien.getNamSinh() + "|" + nhanvien.getQueQuan() + "|" + nhanvien.getSDT() + "|" + nhanvien.getMail() + "|" + nhanvien.getChucVu() + "|" + nhanvien.getPhongBan() + "|" + nhanvien.getThamNien());
        }
        CloseFile();
    }

    public NhanVien Tach(String data) {
        String[] datas = data.split("\\|");
        NhanVien nhanVien = new NhanVien(datas[0], datas[1], datas[2],
                datas[3], datas[4], datas[5], datas[6], datas[7], datas[8], datas[9], Integer.parseInt(datas[10]));
        return nhanVien;
    }

    public List<NhanVien> ReadNV() {
        OpenRead();
        List<NhanVien> nhanViens = new ArrayList<>();
        while (scanner.hasNextLine()) //ch???y cho ?????n khi h???t file
        {
            String str = scanner.nextLine();
            NhanVien nhanVien = Tach(str);
            nhanViens.add(nhanVien);
        }
        scanner.close();
        return nhanViens;
    }

}
