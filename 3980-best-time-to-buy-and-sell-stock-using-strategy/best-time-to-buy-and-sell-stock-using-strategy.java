class Solution {
    public long maxProfit(int[] p, int[] s, int k) {
        int n = p.length;

        long actualProfit = 0;
        long[] profit = new long[n];
        for(int i=0;i<n;i++){
            profit[i] = (long)p[i]*s[i];
            actualProfit += profit[i];
        }
        
        long originalWindowProfit = 0;
        long modifiedWindowProfit = 0;
        long maxGain = 0; // modifiedWindowProfit - originalWindowProfit

        int i = 0, j = 0;
        // khandani pusto se chali aati hui sliding window technodoggy
        while (j < n) {
            originalWindowProfit += profit[j];
            // Second half of the window contributes to modifiedWindowProfit
            if (j - i + 1 > k / 2) modifiedWindowProfit += p[j];
            
            if (j - i + 1 > k) {
                originalWindowProfit -= profit[i];
                modifiedWindowProfit -= p[i + k/2];
                i++;
            }

            // Evaluate window of size k
            if (j - i + 1 == k) {
                maxGain = Math.max(maxGain,modifiedWindowProfit - originalWindowProfit);
            }
            j++;
        }
        return actualProfit + maxGain;
    }
}