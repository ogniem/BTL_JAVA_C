import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataSoNgayLamViec {
    String filename = "Luong.DAT";
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

//    public void GhiFile(NhanVien nhanvien){
//
//        OpenFile();
//        printWriter.println(nhanvien.getMaNV()+ "|" + nhanvien.getHoDem() + "|"+ nhanvien.getTen()+ "|"+ nhanvien.getGioiTinh()+"|"+nhanvien.getNamSinh()+ "|"+ nhanvien.getQueQuan()+ "|"+ nhanvien.getSDT()+ "|"+nhanvien.getMail()+"|"+nhanvien.getChucVu()+"|"+nhanvien.getPhongBan()+"|"+nhanvien.getThamNien());
//
//        CloseFile();
//    }

    public SoNgayLam Tach(String data) {
        String[] datas = data.split("\\|");
        SoNgayLam soNgayLam = new SoNgayLam(datas[0], datas[1], Integer.parseInt(datas[2]), Integer.parseInt(datas[3]), Integer.parseInt(datas[4]));
        return soNgayLam;
    }

    public List<SoNgayLam> ReadNV() {
        OpenRead();
        List<SoNgayLam> soNgayLams = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            SoNgayLam soNgayLam = Tach(str);
            soNgayLams.add(soNgayLam);
        }
        scanner.close();
        return soNgayLams;
    }

}
