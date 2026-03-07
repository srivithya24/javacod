import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its "rightful" place
        // Number 'x' should be at index 'x - 1'
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the element at its target position
                int targetIdx = nums[i] - 1;
                int temp = nums[targetIdx];
                nums[targetIdx] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first index where the number is not (index + 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all numbers 1 to n are present, return n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 4, -1, 1};
        System.out.println("Missing: " + sol.firstMissingPositive(nums)); // Output: 2
    }
}
