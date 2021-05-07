public class RotateList {
    private static void rotateListOnce(LinkedList list) {
        LinkedList.Node temp = list.head, prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        temp.next = list.head;
        list.head = temp;
        prev.next = null;
        System.out.println(temp.data + " is being rotated");
    }

    public static LinkedList rotateList(LinkedList list, int times) {
        for (int i = 0; i < times; i++) {
            rotateListOnce(list);
        }
        return list;
    }
}
