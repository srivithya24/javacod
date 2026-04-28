class Solution {
    public int countTexts(String pressedKeys) {

        int mod = 1000000007;
        int n = pressedKeys.length();

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            char curr = pressedKeys.charAt(i - 1);

            // check up to 4 previous positions
            long ways = 0;

            for (int j = i; j >= 1 && j >= i - 3; j--) {

                if (pressedKeys.charAt(j - 1) != curr) break;

                int len = i - j + 1;

                // digits 7 and 9 allow 4 presses
                if ((curr == '7' || curr == '9') || len <= 3) {
                    ways = (ways + dp[j - 1]) % mod;
                }
            }

            dp[i] = ways;
        }

        return (int) dp[n];
    }
}
