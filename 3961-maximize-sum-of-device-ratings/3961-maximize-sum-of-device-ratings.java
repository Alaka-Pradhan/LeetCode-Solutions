import java.util.Arrays;

class Solution {
    public long maxRatings(int[][] units) {
        int n = units[0].length;
        if (n == 1) {
            long sum = 0;
            for (int[] row : units) {
                sum += row[0];
            }
            return sum;
        }

        long ans = 0;
        int globalMin = Integer.MAX_VALUE;
        int smallestSecond = Integer.MAX_VALUE;

        for (int[] row : units) {
            Arrays.sort(row);
            globalMin = Math.min(globalMin, row[0]);
            smallestSecond = Math.min(smallestSecond, row[1]);
            ans += row[1];
        }
        return ans - smallestSecond + globalMin;
    }
}