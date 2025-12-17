class Solution {
    // t[i][k][CASE]
    // CASE:
    // 0 -> No open transaction
    // 1 -> Holding long (bought,waiting to sell)
    // 2 -> Holding short (sold,waiting to buy back)
    long[][][] t;

    long solve(int i, int k, int CASE, int[] prices) {
        if (i == prices.length) {
            if (CASE == 0) return 0;
            return Long.MIN_VALUE / 2; // unfinished transaction is invalid
        }

        if (t[i][k][CASE] != Long.MIN_VALUE) return t[i][k][CASE];

        long take = Long.MIN_VALUE;
        long dontTake;

        // Do nothing today
        dontTake = solve(i + 1,k,CASE,prices);

        // Take action
        if (k > 0) {
            if (CASE == 1) {
                // Sell today (complete normal transaction)
                take = prices[i] + solve(i + 1, k - 1, 0, prices);
            }
            else if (CASE == 2) {
                // Buy back today (complete short transaction)
                take = -prices[i] + solve(i + 1, k - 1, 0, prices);
            }
            else {
                // CASE == 0: start a transaction
                take = Math.max(
                        -prices[i] + solve(i + 1,k,1,prices), // buy
                         prices[i] + solve(i + 1,k,2,prices)  // short sell
                );
            }
        }
        return t[i][k][CASE] = Math.max(take,dontTake);
    }

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        t = new long[n][k+1][3];

        for (int i = 0; i < n; i++)
            for (int j = 0; j <= k; j++)
                for (int l = 0; l < 3; l++)
                    t[i][j][l] = Long.MIN_VALUE;

        return solve(0,k,0,prices);
    }
}