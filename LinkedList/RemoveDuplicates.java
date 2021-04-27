import java.util.HashSet;

public class RemoveDuplicates {
    public static LinkedList removeDuplicates(LinkedList list) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedList.Node temp = list.head, prev = null;
        while (temp.next != null) {
            if (!set.contains(temp.data)) {
                set.add(temp.data);
            } else {
                prev.next = temp.next;
                System.out.println("Duplicate found-> " + temp.data + " <-being deleted");
            }
            prev = temp;
            temp = temp.next;
        }
        return list;
    }
}
