class Solution {
    public int buttonWithLongestTime(int[][] events) {

        int maxTime = events[0][1]; // first event time
        int result = events[0][0];

        for (int i = 1; i < events.length; i++) {

            int time = events[i][1] - events[i - 1][1];
            int index = events[i][0];

            if (time > maxTime || (time == maxTime && index < result)) {
                maxTime = time;
                result = index;
            }
        }

        return result;
    }
}
