import java.util.*;
class PermsWithDuplicates {
    static List<List<Integer>> ans;
    static List<Integer> perm;
    static boolean[] visited;
    
    public static List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        ans = new ArrayList<>();
        perm = new ArrayList<>();
        visited = new boolean[n];
        Arrays.sort(nums);
        perm_gen(nums, n);
        
        return ans;
        
    }
    
    private static void perm_gen(int[] nums, int n){
        if(perm.size()==n){
            ans.add(new ArrayList<>(perm));
            return;
        }
        
        int prev = -11; // less than min in the constraints
        
        for(int i=0; i<n; i++){
            if(!visited[i] && nums[i]!=prev){
                perm.add(nums[i]);
                visited[i] = true;
                prev = nums[i];
                perm_gen(nums, n);
                visited[i] = false;
                perm.remove(perm.size()-1);
                
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {3, 1, 3};
        System.out.println(permuteUnique(arr));
    }
}
