import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class DataLichSu {
    String filename = "LichSu.DAT";
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

    public void GhiFile(String str) {

        Calendar calendar = Calendar.getInstance();
        String s = calendar.get(Calendar.YEAR) + "/"+ (calendar.get(Calendar.MONTH) +1) +"/"+ calendar.get(Calendar.DAY_OF_MONTH)+ " "+calendar.get(Calendar.HOUR)+
                ":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
        OpenFile();
        printWriter.println(s+"-"+Data.acc.getUserName()+"-"+str);
        CloseFile();
    }
//    public void GhiFile2(List<NhanVien> nhanViens) {
//        try {
//            fileWriter = new FileWriter(filename);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            printWriter = new PrintWriter(bufferedWriter);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (NhanVien nhanvien:nhanViens) {
//            printWriter.println(nhanvien.getMaNV() + "|" + nhanvien.getHoDem() + "|" + nhanvien.getTen() + "|" + nhanvien.getGioiTinh() + "|" + nhanvien.getNamSinh() + "|" + nhanvien.getQueQuan() + "|" + nhanvien.getSDT() + "|" + nhanvien.getMail() + "|" + nhanvien.getChucVu() + "|" + nhanvien.getPhongBan() + "|" + nhanvien.getThamNien());
//        }
//        CloseFile();
//    }

//    public NhanVien Tach(String data) {
//        String[] datas = data.split("\\|");
//        NhanVien nhanVien = new NhanVien(datas[0], datas[1], datas[2],
//                datas[3], datas[4], datas[5], datas[6], datas[7], datas[8], datas[9], Integer.parseInt(datas[10]));
//        return nhanVien;
//    }

    public String ReadNV() {
        OpenRead();
       String s = "";
        while (scanner.hasNextLine()) //chạy cho đến khi hết file
        {
            String str = scanner.nextLine();
           s=s+str+"\n";

        }
        scanner.close();
        return s;
    }

}
