package Week5.PatikaStore;

import java.util.Scanner;

public class PatikaStore {

    public void run(){
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ürün Ekle");
            System.out.println("2. Ürünleri Listele");
            System.out.println("3. Ürün Sil");
            System.out.println("4. Marka Listele");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Cep telefonu -> 1\nNotebook -> 2\nSeçiminiz : ");
                    int select = scanner.nextInt();
                    System.out.print("Ürün adı giriniz : ");
                    String productName = scanner.next();
                    System.out.print("Ürün adet fiyatını giriniz : ");
                    double unitPrice = scanner.nextDouble();
                    System.out.print("Stok adetini giriniz : ");
                    int stock = scanner.nextInt();
                    System.out.print("Marka ID'si giriniz : ");
                    int brandID = scanner.nextInt();
                    System.out.print("İndirim oranını giriniz : ");
                    double discount = scanner.nextInt();
                    System.out.print("Hafıza boyutunu giriniz : ");
                    int memorySize = scanner.nextInt();
                    System.out.print("Ekran boyutunu giriniz : ");
                    double screenSize = scanner.nextDouble();
                    System.out.print("Ram bellek boyutunu giriniz : ");
                    int ram = scanner.nextInt();

                    Brand brand = productManager.getBrandById(brandID);
                    if (brand != null){

                        if (select == 1){
                            System.out.print("Pil gücünü giriniz : ");
                            int batterySize = scanner.nextInt();
                            System.out.print("Renk bilgisini giriniz : ");
                            String color = scanner.next();
                            Phone phone = new Phone(productName,brand,unitPrice,discount,stock,memorySize,screenSize,ram,batterySize,color);
                            productManager.addPhoneProduct(phone);
                        }else {
                            Notebook notebook = new Notebook(productName,brand,unitPrice,discount,stock,memorySize,screenSize,ram);
                            productManager.addNotebookProduct(notebook);
                        }
                        System.out.println("Ürün başarıyla eklendi eklendi");
                    }else {
                        System.out.println("Geçersiz marka ID girdiniz");
                    }
                    break;

                case 2:
                    productManager.productList();
                    break;
                case 3:
                    System.out.println("Silmek istediğiniz ürünü seçiniz : ");
                    int removeID = scanner.nextInt();
                    productManager.removeProduct(removeID);
                    System.out.println("Ürün başarıyla silindi");
                    break;
                case 4:
                    productManager.brandList();
                    break;
                case 5:
                    System.out.println("güvenli çıkış yapılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz bir seçim yaptınız.");




            }
        }
    }
}
