package Week6.Notepad;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            //createFile(); // Her dosya oluşturduğumuz da bir kere kullanılır
            readFile();
            writeFile();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    // -------------- Dosya Oluşturma -----------------
    public static void createFile() throws IOException {
        File file = new File("src/Week6/Notepad/Notepad.txt");
        if (file.createNewFile()) {
            System.out.println(file.getName() + " dosyası oluşturuldu.");
        } else {
            System.out.println(file.getName() + " dosyası zaten var");
        }

    }
    // -------------- Dosyaya Yazma -----------------
    public static void writeFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("src/Week6/Notepad/Notepad.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        System.out.print("Notunuzu giriniz : ");
        String metin = scanner.nextLine();
        bufferedWriter.write(metin);bufferedWriter.newLine();
        System.out.println("Notunuz başarılı bir şekilde eklendi.");
        bufferedWriter.close();
    }

    // -------------- Dosyaya Okuma -----------------
    public static void readFile() throws IOException{
        File file = new File("src/Week6/Notepad/Notepad.txt");
        Scanner scanner = new Scanner(file);
        int i  = 1;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(i +") "+ line);
            i++;
        }
        scanner.close();
    }
}



