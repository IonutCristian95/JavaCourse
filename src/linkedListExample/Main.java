package linkedListExample;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(6);


        myLinkedList.add(node1);
        myLinkedList.add(node2);
        myLinkedList.add(node3);

        myLinkedList.printMyLinkedList();

        Node<Integer> node4 = new Node<>(15);
        myLinkedList.add(node4);
        myLinkedList.printMyLinkedList();

        System.out.println(myLinkedList.lookup(4) == null);
        System.out.println(myLinkedList.lookup(15) != null);

        myLinkedList.insert(0, 8);
        myLinkedList.printMyLinkedList();
        myLinkedList.insert(200, 80);
        myLinkedList.printMyLinkedList();
        myLinkedList.insert(2, 4);
        myLinkedList.printMyLinkedList();


        myLinkedList.delete(80);
        myLinkedList.printMyLinkedList();

        myLinkedList.insert(70, 20);
        myLinkedList.insert(70, 21);
        myLinkedList.printMyLinkedList();
    }
}
