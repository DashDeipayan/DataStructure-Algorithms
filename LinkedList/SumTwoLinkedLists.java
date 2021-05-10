public class SumTwoLinkedLists {
    public static LinkedList sumTwoLinkedLists(LinkedList list1, LinkedList list2) {
        LinkedList finalList = new LinkedList();
        int value1 = 0, value2 = 0;
        LinkedList.Node temp = list1.head;
        while (temp != null) {
            value1 = value1 * 10 + temp.data;
            temp = temp.next;
        }
        temp = list2.head;
        while (temp != null) {
            value2 = value2 * 10 + temp.data;
            temp = temp.next;
        }
        value1 = reverse(value1);
        value2 = reverse(value2);
        int sum = value1 + value2;
        while (sum != 0) {
            finalList = finalList.insert(finalList, sum % 10);
            sum /= 10;
        }
        return finalList;
    }

    private static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {

            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
}
