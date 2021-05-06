public class RemoveFromListEndOnePass {
    public static LinkedList removeFromListEndOnePass(LinkedList list, int x) {
        LinkedList.Node temp = list.head;
        for (int i = 0; i < x; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            list.head = list.head.next;
            return list;
        }
        LinkedList.Node prev = null;
        LinkedList.Node toRemove = list.head;
        while (temp != null) {
            prev = toRemove;
            temp = temp.next;
            toRemove = toRemove.next;
        }
        prev.next = toRemove.next;
        return list;
    }
}
