public class SwapPairNodes {
    public static LinkedList swapPairNodes(LinkedList list) {
        if (list.head == null || list.head.next == null) {
            return list;
        }
        LinkedList.Node curr = list.head;
        LinkedList.Node nextNode = list.head.next;
        LinkedList.Node tmp = null;
        while (curr.next != null) {
            curr.next = nextNode.next;
            nextNode.next = curr;
            if (tmp == null) {
                list.head = nextNode;
            } else {
                tmp.next = nextNode;
            }
            tmp = curr;
            if (curr == null || curr.next == null) {
                break;
            }
            System.out.println("Swapped: " + curr.data + " <-> " + nextNode.data);
            curr = curr.next;
            nextNode = curr.next;
        }
        return list;
    }
}
