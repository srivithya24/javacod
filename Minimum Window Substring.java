class Solution {

    public String minWindow(String s, String t) {

        // If t is larger than s
        if (s.length() < t.length()) {
            return "";
        }

        int[] need = new int[128];

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int left = 0;
        int count = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Sliding window
        for (int right = 0; right < s.length(); right++) {

            char r = s.charAt(right);

            // If character is needed
            if (need[r] > 0) {
                count--;
            }

            need[r]--;

            // Valid window found
            while (count == 0) {

                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left);

                need[l]++;

                // Window becomes invalid
                if (need[l] > 0) {
                    count++;
                }

                left++;
            }
        }

        // Return result
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
