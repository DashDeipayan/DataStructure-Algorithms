import java.util.*;

public class MoveElementToEnd {
    
    public static int [] moveElementToEnd(int []array, int num){
        int start = 0;
        int  end = array.length-1;
        while(start < end){
            while(start<end && array[end] == num){
                end--;
            }
            if(array[start] ==num ){
                int c = array[start];
                array[start]=array[end];
                array[end] = c;
            }
            start++;
        }
        return array;
    }
    public static void main(String[] args){
        int []array = {2,1,2,2,2,3,4,2};
        int num =2;
        System.out.println(Arrays.toString(moveElementToEnd(array,num)));
    } 
}
