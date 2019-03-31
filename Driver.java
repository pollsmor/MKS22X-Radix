public class Driver {
  public static void main(String[] args) {
    MyLinkedList t1 = new MyLinkedList();
    MyLinkedList t2 = new MyLinkedList();

    //for (int i = 0; i < 100000; ++i)
      //t1.add(i + 1);

    //for (int i = 0; i < 100000; ++i)
      //t2.add(i + 10);

    t1.add(69);
    t2.add(10);
    System.out.println(t1);
    System.out.println(t2);

    t1.extend(t2);
    System.out.println(t1);
  }
}
