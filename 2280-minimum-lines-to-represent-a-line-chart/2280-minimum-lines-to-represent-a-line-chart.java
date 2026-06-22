import java.util.Arrays;

class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;

        if (n == 1) {
            return 0;
        }

        Arrays.sort(stockPrices, (a, b) -> Integer.compare(a[0], b[0]));

        int lines = 1;

        long prevDy = (long) stockPrices[1][1] - stockPrices[0][1];
        long prevDx = (long) stockPrices[1][0] - stockPrices[0][0];

        for (int i = 2; i < n; i++) {
            long dy = (long) stockPrices[i][1] - stockPrices[i - 1][1];
            long dx = (long) stockPrices[i][0] - stockPrices[i - 1][0];

            if (prevDy * dx != dy * prevDx) {
                lines++;
            }

            prevDy = dy;
            prevDx = dx;
        }

        return lines;
    }
}