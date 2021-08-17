import java.util.List;

import java.util.*;
public class PowerSet {
    static List<List<Integer>> powerSetResult = new ArrayList<>();

    private static void powerSetRecursive(int[] nums, List<Integer> list, int index) {
        powerSetResult.add(new ArrayList<>(list));
        if(index == nums.length)    
            return;
        for(int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            powerSetRecursive(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> powerSet(int[] nums) {
        powerSetRecursive(nums, new ArrayList<Integer>(), 0);
        return powerSetResult;
    }

    public static void main(String[] args) {
        System.out.println(powerSet(new int[]{0}));
    }
}
