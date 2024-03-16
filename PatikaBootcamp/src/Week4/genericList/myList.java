package Week4.genericList;


import java.util.Arrays;

public class myList<T> {
    private T[] array;
    private int capacity;
    private int size;

    public myList(){
        this.array = (T[]) new Object[10];
    }

    public myList(int initialCapacity) {
        this.array = (T[]) new Object[initialCapacity];
        this.size = 0;
        this.capacity = initialCapacity;
    }

    public int size() {
        System.out.println("Dizinin boyutu : " + size);
        return size;
    }

    public int getCapacity(){
        System.out.println("Dizinin kapasitesi : " + capacity);
        return capacity;
    }

    public void add(T data){
        if (size == capacity){
            updateCapacity();
        }
        array[size] = data;
        size++;
    }

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

    public int get(int index){
        if (array[index] != null){
            System.out.println(array[index]);
        }
        return index;
    }

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

    public void set(int index, T data){
        array[index] = data;
    }

    @Override
    public String toString() {
        for (int i = 0; i < size ; i++) {
            System.out.println(array[i]);
        }
        return super.toString();
    }

    public int indexOf(T data){
        for (int i = 0; i < size - 1; i++) {
            if (array[i].equals(data)){
                System.out.println("Elemanın listedeki indeksi " + i);
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for (int i = size-1; i >= 0; i--) {
            if (array[i].equals(data)){
                System.out.println("Elemanın listedeki indeksi " + i);
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    T[] toArray(){
        return Arrays.copyOf(array,capacity);
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    myList<T> sublist(int start, int finish){
        if (start < 0 || finish > size || start > finish){
            System.out.println("Geçersi değer girdiniz");
        }
        myList<T> subList = new myList<>(finish - start);
        for (int i = start; i < finish; i++) {
            subList.add(array[i]);
        }
        return subList;
    }

    public boolean contains(T data){
        for (int i = 0; i < size ; i++) {
            if (array[i] == data){
                return true;
            }
        }
        return false;
    }
}
