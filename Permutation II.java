import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort to handle duplicates
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        // Base case: permutation complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if already used in this path
            if (used[i]) continue;
            
            // 2. Skip duplicates: 
            // If nums[i] == nums[i-1] and nums[i-1] was NOT used in this level, 
            // it means we already explored that branch.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.add(nums[i]);
            
            backtrack(result, current, nums, used);
            
            // Backtrack: remove last element and reset used flag
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 2};
        System.out.println(sol.permuteUnique(nums));
    }
}
