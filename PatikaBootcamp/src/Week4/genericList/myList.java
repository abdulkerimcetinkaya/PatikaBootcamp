package Week4.genericList;


import java.util.Arrays;

public class myList<T> {
    private T[] array;
    private int capacity;
    private int size;

    // Parametresiz constructor
    public myList(){
        this.array = (T[]) new Object[10];
    }
    // Parametreli constructor
    public myList(int initialCapacity) {
        this.array = (T[]) new Object[initialCapacity];
        this.size = 0;
        this.capacity = initialCapacity;
    }

    // Boyutu getir
    public int size() {
        System.out.println("Dizinin boyutu : " + size);
        return size;
    }

    // kapasiteyi getir
    public int getCapacity(){
        System.out.println("Dizinin kapasitesi : " + capacity);
        return capacity;
    }

    // Veriyi ekle
    public void add(T data){
        if (size == capacity){
            updateCapacity();
        }
        array[size] = data;
        size++;
    }

    // Kapasiteyi artır
    private void updateCapacity(){
        int newCapacity = capacity * 2;
        T[] newArray = Arrays.copyOf(array, newCapacity);
        array = newArray;
        capacity = newCapacity;
    }

    public void print(){
        getCapacity();
        size();
    }
    // verilen indexte ki değeri getirir.
    public int get(int index){
        if (array[index] != null){
            System.out.println(array[index]);
        }
        return index;
    }
    // Verilen indexte ki değeri sil
    public void remove (int index){
        if (index < 0 || index >= size){
            System.out.println("Geçersiz indis numarası girdiniz");
        }
        // sola kaydırma işlemi
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        // son elemanı null yapma
        array[size-1] = null;
        // dizinin boyutunu azalt
        size--;
    }

    // Girilen veriyi girilen indexte ki değerle değiştirme
    public void set(int index, T data){
        array[index] = data;
    }


    // Listeyi yazdırma
    @Override
    public String toString() {
        for (int i = 0; i <size; i++) {
            System.out.println(array[i]);
        }
        return super.toString();
    }
    // Grilen değerin index sırası (Baştan)
    public int indexOf(T data){
        for (int i = 0; i < size - 1; i++) {
            if (array[i].equals(data)){
                System.out.println("Elemanın listedeki indeksi " + i);
                return i;
            }
        }
        return -1;
    }
    // Grilen değerin index sırası (Sondan)
    public int lastIndexOf(T data){
        for (int i = size-1; i >= 0; i--) {
            if (array[i].equals(data)){
                System.out.println("Elemanın listedeki indeksi " + i);
                return i;
            }
        }
        return -1;
    }

    //Boş mu?
    public boolean isEmpty(){
        return size == 0;
    }

    // Yeni bir Array oluştur
    T[] toArray(){
        return Arrays.copyOf(array,capacity);
    }

    // Listeyi temizle
    public void clear(){
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    // belirtilen index noktaları aralığında yeni bir liste üret
    public myList<T> sublist(int start, int finish){
        if (start < 0 || finish > size || start > finish){
            System.out.println("Geçersiz değer girdiniz");
        }
        myList<T> newList = new myList<>(finish - start);
        for (int i = start; i < finish; i++) {
            newList.add(array[i]);
        }
        return newList;
    }
    // Liste verilen datayı içeriyor mu?
    public boolean contains(T data){
        for (int i = 0; i < size ; i++) {
            if (array[i] == data){
                return true;
            }
        }
        return false;
    }
}
