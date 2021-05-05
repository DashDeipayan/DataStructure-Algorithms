public class DoublyLinkedList {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    Node head = null;
    Node tail = null;

    public DoublyLinkedList insert(DoublyLinkedList list, int x) {
        if (list.head == null) {
            list.head = new Node(x);
            tail = head;
        } else {
            Node node = new Node(x);
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        return list;
    }

    public static void printlist(DoublyLinkedList list) {
        Node p = list.head;
        while (p != null) {
            System.out.print(p.data + " <-> ");
            p = p.next;
        }
        System.out.println("end\n");
    }

    public DoublyLinkedList delete(DoublyLinkedList list, int value) {
        Node temp = list.head;
        while (temp != null && temp.data == value) {
            list.head = temp.next;
            System.out.println(temp.data + " was deleted from head");
            temp = null;
        }
        while (temp.next != null) {
            if (temp.data == value) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                Node p = temp;
                System.out.println(temp.data + " was deleted");
                temp = temp.next;
                p.prev = null;
                p.next = null;
                return list;
            } else {
                temp = temp.next;
            }
        }
        if (temp.data == value) {
            temp.prev.next = null;
            System.out.println(temp.data + " was deleted");
            temp.prev = null;
            return list;
        }
        if (temp.next == null) {
            System.out.println(value + " was not found");
        }
        return list;
    }

    public static void setHead(DoublyLinkedList list, Node node) {
        if (list.head == null) {
            list.head = node;
            System.out.println(list.head.data + " is the head now");
            return;
        }
        node.next = list.head.next;
        list.head.next.prev = node;
        list.head = node;
        System.out.println(list.head.data + " is the head now");
    }

    public static void setTail(DoublyLinkedList list, Node node) {
        if (list.tail == null) {
            list.tail = node;
            System.out.println(list.tail.data + " is the tail now");
            return;
        }
        node.prev = list.tail.prev;
        list.tail.prev.next = node;
        list.tail = node;
        System.out.println(list.tail.data + " is the tail now");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list = list.insert(list, 54);
        list = list.insert(list, 69);
        list = list.insert(list, 21);
        list = list.insert(list, 32);
        list = list.insert(list, 53);
        list = list.insert(list, 62);
        list = list.insert(list, 16);
        list = list.insert(list, 66);
        list = list.insert(list, 56);
        list = list.insert(list, 23);
        list = list.insert(list, 16);
        list = list.insert(list, 14);
        list = list.insert(list, 54);
        list = list.insert(list, 32);
        printlist(list);

        setHead(list, new Node(5));
        printlist(list);

        setTail(list, new Node(8));
        printlist(list);

        list = list.delete(list, 66);
        list = list.delete(list, 8);
        printlist(list);
    }
}
