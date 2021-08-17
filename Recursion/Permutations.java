import java.util.*;
public class Permutations {
    static List<List<Integer>> result = new ArrayList<List<Integer>>();

    private static void recursivePerm(int[] nums, List<Integer> tempPerm){
        if(tempPerm.size()==nums.length){
            result.add(new ArrayList<>(tempPerm));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!tempPerm.contains(nums[i])){
                tempPerm.add(nums[i]);
                recursivePerm(nums,tempPerm);
                tempPerm.remove(tempPerm.size()-1);
            }
        }

    }

    public static List<List<Integer>> permute(int[] nums) {
        recursivePerm(nums, new ArrayList<Integer>());
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(permute(arr));
    }
}