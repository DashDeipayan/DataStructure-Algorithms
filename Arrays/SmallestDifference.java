import java.util.*;

public class SmallestDifference {
    public static int[] smallestDifference(int []array1,int []array2){
        Arrays.sort(array1);
        Arrays.sort(array2);
        int size1 = array1.length;
        int size2 = array2.length;
        int ptr1=0,ptr2 =0,smallest=Integer.MAX_VALUE,current = Integer.MAX_VALUE;
        int []pair = new int[2];

        while (ptr1<size1&&ptr2<size2){
            int firstNum = array1[ptr1];
            int secondNum = array2[ptr2];
            current = Math.abs(firstNum - secondNum);
            if(firstNum>secondNum){
                ptr2++;
            }
            else if(firstNum<secondNum){
                ptr1++;
            }
            else{
                pair[0] = firstNum;
                pair[1] = secondNum;
                return pair;
            }
            if(current<smallest){
                smallest = current;
                pair[0] = firstNum;
                pair[1] = secondNum;
            }
        }
        return pair;
    }
    public static void main(String[] args){
        int []array1 = {-1,5,10,20,28,135};
        int []array2 = {26,134,135,15,17};
        System.out.println(Arrays.toString(smallestDifference(array1, array2)));
    }
}
