class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Iterate up to the second-to-last element
        for (int i = 0; i < nums.length - 1; i++) {
            // 1. Update the farthest we can reach from the current position
            farthest = Math.max(farthest, i + nums[i]);

            // 2. If we reach the end of the range for the current jump
            if (i == currentEnd) {
                jumps++;           // We must take another jump
                currentEnd = farthest; // The new range ends at the farthest point we found
                
                // Optional: If we can already reach the end, stop early
                if (currentEnd >= nums.length - 1) break;
            }
        }

        return jumps;
    }
}
