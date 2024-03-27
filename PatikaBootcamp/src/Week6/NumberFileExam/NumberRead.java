package Week6.NumberFileExam;

import java.io.*;

public class NumberRead {
    public static void main(String[] args) throws IOException {

        //-------------Dosya Oluşturma-------------------

        // Bir dizin belirterek 'Number.txt' adında bir dosya oluşturuldu referans olarak 'file' nesnesine atandı.
        File file = new File("src/Week6/NumberReaderExam/Number.txt");
        // Belirtilen dizinde dosyanın oluşup oluşmadığı kontrol edildi.
        if (!file.exists()){
            file.createNewFile();
        }else {
            System.out.println("Dosya Zaten Mevcut !");
        }

        //-------------Dosya Yazma-------------------

        FileWriter fileWriter = new FileWriter(file,false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("5");bufferedWriter.newLine();
        bufferedWriter.write("10");bufferedWriter.newLine();
        bufferedWriter.write("20");bufferedWriter.newLine();
        bufferedWriter.write("12");bufferedWriter.newLine();
        bufferedWriter.write("33");bufferedWriter.newLine();
        bufferedWriter.close();


        //-------------Dosya Okuma-------------------


        FileReader fileReader = new FileReader(file);
        String line;
        int sum = 0;

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null){
            int number = Integer.parseInt(line);
            sum += number;
        }
        bufferedReader.close();


        System.out.println("Dosyadaki sayıların toplamı : " + sum);





    }
}
