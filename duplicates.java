class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: if array is empty, return 0
        if (nums.length == 0) return 0;

        // 'i' is the slow pointer (tracks the position of unique elements)
        int i = 0;

        // 'j' is the fast pointer (scans the array)
        for (int j = 1; j < nums.length; j++) {
            // If we find a new unique element
            if (nums[j] != nums[i]) {
                i++; // Move the unique position forward
                nums[i] = nums[j]; // Update the element at that position
            }
        }

        // Return the count of unique elements (index + 1)
        return i + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        
        int k = sol.removeDuplicates(nums);
        
        System.out.println("Number of unique elements: " + k);
        System.out.print("Modified array: ");
        for (int m = 0; m < k; m++) {
            System.out.print(nums[m] + " ");
        }
    }
}
