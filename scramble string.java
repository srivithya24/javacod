class Solution {

    public boolean isScramble(String s1, String s2) {

        // If lengths are different
        if (s1.length() != s2.length()) {
            return false;
        }

        // If strings are equal
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();

        // Check character frequencies
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int x : count) {
            if (x != 0) {
                return false;
            }
        }

        // Try all partitions
        for (int i = 1; i < n; i++) {

            // Without swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            // With swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                return true;
            }
        }

        return false;
    }
}
