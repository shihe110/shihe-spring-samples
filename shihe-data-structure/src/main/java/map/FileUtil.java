package map;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileUtil {
    public static boolean readFile(String filename, ArrayList<String> words){
        if (filename == null || words == null){
            System.out.println("filename is null or words is null");
        }
        return false;
        // 文件读取
        /*Scanner scanner;
        try {
            File file = new File(filename);
            if (file.exists()){
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/

    }
}
