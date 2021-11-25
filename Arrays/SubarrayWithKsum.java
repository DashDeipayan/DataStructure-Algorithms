import java.util.*;

public class SubarrayWithKsum {
    public static HashSet<Integer> prefixSumSet(int arr[]){
        HashSet<Integer> set = new HashSet<Integer>();
        int sum = 0;
        for (int i : arr) {
            sum+=i;
            set.add(sum);
        }
        return set;
    }

    public static List<Integer> prefixSumList(int arr[]){
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        for(int i:arr){
            sum+=i;
            list.add(sum);
        }
        return list ;
    }

    public static int subarrayWithKsum(int array[], int k){
        HashSet<Integer> set = prefixSumSet(array);
        List<Integer> list = prefixSumList(array);
        int count = 0;
        for(int i=0;i<list.size();i++){
            if(set.contains(k-list.get(i))){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = { -1, -3, -7, -2, -2 };
        System.out.println(subarrayWithKsum(nums, -4));
        System.out.println(subarrayWithKsum(nums, 17));
    }
}
