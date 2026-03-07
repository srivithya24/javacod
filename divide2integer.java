class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case: -2^31 / -1 = 2^31 (which exceeds 2^31 - 1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        // True if the signs are different
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Use long to prevent overflow during absolute value conversion
        // Math.abs(Integer.MIN_VALUE) overflows an int
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        long quotient = 0;

        // Core logic: Bit shifting (exponential subtraction)
        while (lDividend >= lDivisor) {
            long tempDivisor = lDivisor;
            long multiple = 1;

            // While the current tempDivisor doubled is still <= lDividend
            while (lDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest power of 2 multiple found
            lDividend -= tempDivisor;
            quotient += multiple;
        }

        // Apply sign and cast back to int
        return isNegative ? (int) -quotient : (int) quotient;
    }
}
