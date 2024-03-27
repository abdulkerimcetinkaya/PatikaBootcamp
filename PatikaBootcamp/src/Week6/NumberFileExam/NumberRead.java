package Week6.NumberFileExam;

import java.io.*;

public class NumberRead {
    public static void main(String[] args)  {
        String targetPath = "src/Week6/NumberFileExam/Number.txt";
        try {
            //createFile(targetPath);
            writeFile(targetPath);
            readFile(targetPath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // ------------ Dosya Oluşturma(createFile) metodu ------------------------
    public static void createFile(String path) throws IOException{
        // dizin belirtilerek 'Number.txt' dosyası oluşturuldu ve 'file' nesnesine atandı
        File file = new File(path);
        // Belirtilen dizinde dosyanın oluşup oluşmadığı kontrol edildi.
        if (file.createNewFile()){
            System.out.println(file.getName() + " dosyası oluşturuldu");
        }else {
            System.out.println(file.getName() + " dosyası zaten mevcut !");
        }
    }

    // ------------ Dosyaya Yazma(fileWrite) metodu ------------------------
    public static void writeFile(String path) throws IOException{
        File file = new File(path);

        FileWriter fileWriter = new FileWriter(file,false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("5");bufferedWriter.newLine();
        bufferedWriter.write("10");bufferedWriter.newLine();
        bufferedWriter.write("20");bufferedWriter.newLine();
        bufferedWriter.write("12");bufferedWriter.newLine();
        bufferedWriter.write("33");bufferedWriter.newLine();
        bufferedWriter.close();
    }

    // ------------ Dosyayı Okuma(fileRead) metodu ------------------------
    public static void readFile(String path)throws IOException{
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        String line;
        int sum = 0;

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null){
            int number = Integer.parseInt(line);
            sum += number;

        }
        System.out.println("Dosyadaki sayıların toplamı : " + sum);
        bufferedReader.close();
    }
}
