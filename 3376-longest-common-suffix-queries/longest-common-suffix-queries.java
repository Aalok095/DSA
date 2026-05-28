class Solution {
    static class TrieNode {
        int idx;
        TrieNode[] children;
        TrieNode() {
            idx = -1; // Initialize with a default value
            children = new TrieNode[26];
        }
    }

    public TrieNode getNode(int idx) {
        TrieNode temp = new TrieNode();
        temp.idx = idx;

        for (int i = 0; i < 26; i++) {
            temp.children[i] = null;
        }
        return temp;
    }

    public void insertTrie(TrieNode pCrawl, int i, String[] wordsContainer) {
        String word = wordsContainer[i];
        int n = word.length();

        for (int j = n - 1; j >= 0; j--) {
            int ch_idx = word.charAt(j) - 'a';

            if (pCrawl.children[ch_idx] == null) {
                pCrawl.children[ch_idx] = getNode(i);
            }
            pCrawl = pCrawl.children[ch_idx];

            if (wordsContainer[pCrawl.idx].length() > n) {
                pCrawl.idx = i;
            }
        }
    }

    public int search(TrieNode pCrawl, String word, String[] wordsContainer) {
        int result_idx = pCrawl.idx;
        int n = word.length();

        for (int i = n - 1; i >= 0; i--) {
            int ch_idx = word.charAt(i) - 'a';
            pCrawl = pCrawl.children[ch_idx];
            if (pCrawl == null) {
                return result_idx;
            }
            result_idx = pCrawl.idx;
        }
        return result_idx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int m = wordsContainer.length;
        int n = wordsQuery.length;
        int[] result = new int[n];

        TrieNode root = getNode(0);

        for (int i = 0; i < m; i++) {
            if (wordsContainer[root.idx].length() > wordsContainer[i].length()) root.idx = i;
            insertTrie(root, i, wordsContainer);
        }

        for (int i = 0; i < n; i++) {
            result[i] = search(root, wordsQuery[i], wordsContainer);
        }
        return result;
    }
}