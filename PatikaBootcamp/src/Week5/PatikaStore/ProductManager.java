package Week5.PatikaStore;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Brand> brands;
    private List<Phone> phones;
    private List<Notebook> notebooks;

    public ProductManager(){
        this.brands = new ArrayList<>();
        this.phones = new ArrayList<>();
        this.notebooks = new ArrayList<>();
        // Markalar eklendi
        brands.add(new Brand(1,"Samsung"));
        brands.add(new Brand(2,"Lenovo"));
        brands.add(new Brand(3,"Apple"));
        brands.add(new Brand(4,"Huawei"));
        brands.add(new Brand(5,"Casper"));
        brands.add(new Brand(6,"Asus"));
        brands.add(new Brand(7,"HP"));
        brands.add(new Brand(8,"Xiaomi"));
        brands.add(new Brand(9,"Monster"));
    }

    public void addPhoneProduct(Phone phone){
        if (phone instanceof Phone){
            for (Brand brand : brands){
                if (phone.getBrand().getName().equals(brand.getName())){
                    phones.add(phone);
                }
            }
        }
    }
    //--------------------------------------------
    public void addNotebookProduct(Notebook notebook){
        if (notebook instanceof Notebook){
            for (Brand brand : brands){
                if (notebook.getBrand().getName().equals(brand.getName())){
                    notebooks.add(notebook);
                }
            }
        }
    }
    //------------------------------------------

    public void removeProduct(int id){
        phones.removeIf(phone -> phone.getId() == id);
        notebooks.removeIf(notebook -> notebook.getId() == id);
    }
    //---------------------------------------------------

    public void productList(){
        System.out.println("Notebook Listesi");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM         |");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Notebook notebook : notebooks) {
            System.out.format("| %-2d | %-30s | %-9.1f TL | %-9s | %-10d | %-6.1f | %-11d |\n", notebook.getId(), notebook.getName(), notebook.getUnitPrice(), notebook.getBrand().getName(), notebook.getMemorySize(), notebook.getScreenSize(), notebook.getRam());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("\nCep Telefonu Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (Phone phone : phones) {
            System.out.format("| %-2d | %-30s | %-9.1f TL | %-9s | %-10d | %-6.1f | %-9d | %-9.1f | %-9d | %-9s |\n", phone.getId(), phone.getName(), phone.getUnitPrice(), phone.getBrand().getName(), phone.getMemorySize(), phone.getScreenSize(), phone.getBatteryPower(), phone.getRam(), phone.getColor());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }

    //----------------------------------------------

    public  void brandList(){
        System.out.println("| ID | Marka Adı  |");
        for (Brand brand : brands) {
            System.out.format("| %-1d  | %-1s    |\n",brand.getId(),brand.getName());
        }
    }
    //------------------------------------------------

    public Brand getBrandById(int id) {
        for (Brand brand : brands) {
            if (brand.getId() == id) {
                return brand;
            }
        }
        return null;
    }
}
