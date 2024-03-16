package Week4.genericList;

public class Main {
    public static void main(String[] args) {
        myList<Integer> list = new myList<>(1);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        list.add(100);
        list.get(2);

        list.set(2,30);
        list.print();






        

    }
}
