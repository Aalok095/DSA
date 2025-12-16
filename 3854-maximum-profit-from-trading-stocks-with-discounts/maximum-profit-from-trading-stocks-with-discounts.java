class Solution {

    // DFS to compute best profit for subtree rooted at u
    private void dfs(
        int u,
        int[] present,
        int[] future,
        List<Integer>[] adj,
        int[][][] statesProfit,
        int budget
    ) {
        // Store profit states of children
        // child[0] -> parent not bought
        // child[1] -> parent bought
        List<int[][]> childrenStatesProfit = new ArrayList<>();

        // Process children first
        for (int v : adj[u]) {
            dfs(v,present,future,adj,statesProfit,budget);
            childrenStatesProfit.add(
                new int[][] { statesProfit[v][0],statesProfit[v][1] }
            );
        }

        // parentBought = 0 means parent not bought
        // parentBought = 1 means parent bought
        for (int parentBought = 0;parentBought <= 1;parentBought++) {

            int price = (parentBought == 1) ? present[u] / 2 : present[u];
            int profit = future[u] - price;

            int[] bestProfitAtU = new int[budget + 1];

            // Case 1: do not buy node u
            int[] childrenProfitIfUNotBought = new int[budget + 1];

            for (int[][] child : childrenStatesProfit) {
                int[] childNoBuy = child[0];
                int[] temp = new int[budget + 1];

                for (int used = 0;used <= budget;used++) {
                    for (int take = 0;used + take <= budget;take++) {
                        temp[used + take] = Math.max(
                            temp[used + take],
                            childrenProfitIfUNotBought[used] + childNoBuy[take]
                        );
                    }
                }
                childrenProfitIfUNotBought = temp;
            }

            for (int b = 0;b <= budget;b++) {
                bestProfitAtU[b] = Math.max(
                    bestProfitAtU[b],
                    childrenProfitIfUNotBought[b]
                );
            }

            // Case 2: buy node u
            if (price <= budget) {
                int[] childrenProfitIfUBought = new int[budget + 1];

                for (int[][] child : childrenStatesProfit) {
                    int[] childBuy = child[1];
                    int[] temp = new int[budget + 1];

                    for (int used = 0;used <= budget;used++) {
                        for (int take = 0;used + take <= budget;take++) {
                            temp[used + take] = Math.max(
                                temp[used + take],
                                childrenProfitIfUBought[used] + childBuy[take]
                            );
                        }
                    }
                    childrenProfitIfUBought = temp;
                }
                for (int b = price;b <= budget;b++) {
                    bestProfitAtU[b] = Math.max(
                        bestProfitAtU[b],
                        childrenProfitIfUBought[b - price] + profit
                    );
                }
            }
            statesProfit[u][parentBought] = bestProfitAtU;
        }
    }

    public int maxProfit(
        int n,
        int[] present,
        int[] future,
        int[][] hierarchy,
        int budget
    ) {
        // Build tree
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0;i < n;i++) adj[i] = new ArrayList<>();

        for (int[] h : hierarchy) {
            int u = h[0] - 1;
            int v = h[1] - 1;
            adj[u].add(v);
        }

        // statesProfit[u][0] -> parent not bought
        // statesProfit[u][1] -> parent bought
        int[][][] statesProfit = new int[n][2][budget + 1];

        dfs(0,present,future,adj,statesProfit,budget);

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, statesProfit[0][0][b]);
        }
        return ans;
    }
}
