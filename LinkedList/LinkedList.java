import java.util.*;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head = null;

    public LinkedList insert(LinkedList list, int data) {
        if (list.head == null) {
            list.head = new Node(data);
        } else {
            Node temp = list.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
        return list;
    }

    public static void printlist(LinkedList list) {
        Node temp = list.head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("end\n");
    }

    public LinkedList delete(LinkedList list, int key) {
        Node temp = list.head, prev = null;
        while (temp != null && temp.data == key) {
            list.head = temp.next;
            System.out.println(temp.data + " was deleted from head");
            temp = null;
        }
        while (temp.next != null) {
            if (temp.data == key) {
                prev.next = temp.next;
                System.out.println(temp.data + " was deleted");
                return list;
            }
            prev = temp;
            temp = temp.next;
        }
        if (temp.data == key) {
            prev.next = null;
            System.out.println(temp.data + " was deleted");
            return list;
        }
        if (temp.next == null) {
            System.out.println(key + " was not found");
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list = list.insert(list, random.nextInt(100));
        }
        list = list.insert(list, 66);
        list = list.insert(list, 69);
        printlist(list);
        list = list.delete(list, 66);
        list = list.delete(list, 69);
        printlist(list);
    }
}