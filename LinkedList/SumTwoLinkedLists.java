public class SumTwoLinkedLists {
    public static LinkedList sumTwoLinkedLists(LinkedList list1, LinkedList list2) {
        LinkedList finalList = new LinkedList();
        int carry = 0;
        LinkedList.Node temp1 = list1.head, temp2 = list2.head;
        while (temp1 != null || temp2 != null) {
            int p = (temp1 != null) ? temp1.data : 0;
            int q = (temp2 != null) ? temp2.data : 0;
            int sum = p + q + carry;
            finalList = finalList.insert(finalList, sum % 10);
            carry = sum / 10;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }
        if (carry > 0) {
            finalList = finalList.insert(finalList, carry);
        }
        return finalList;
    }
}
